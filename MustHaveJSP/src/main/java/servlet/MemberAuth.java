package servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import membership.MemberDAO;
import membership.MemberDTO;

@WebServlet(urlPatterns = "/13Servlet/MemberAuth.mvc", 
	initParams = { @WebInitParam(name="admin_id", value="nakja")})
public class MemberAuth extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
	MemberDAO dao;
	Connection con;

    @Override
    public void init() throws ServletException {
        // application 내장 객체 얻기
        ServletContext application = this.getServletContext();

        // web.xml에서 DB 연결 정보 얻기
        String driver = application.getInitParameter("MysqlDriver");
        String connectUrl = application.getInitParameter("MysqlURL");
        String oId = application.getInitParameter("MysqlId");
        String oPass = application.getInitParameter("MysqlPwd");

        // DAO 생성
        dao = new MemberDAO(driver, connectUrl, oId, oPass);
        con = dao.getConnection();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 서블릿 초기화 매개변수에서 관리자 ID 받기
        String admin_id = this.getInitParameter("admin_id");
        
        // 인증을 요청한 ID/패스워드
        String id = req.getParameter("id");
        String pass = req.getParameter("pass");

        // 회원 테이블에서 인증 요청한 ID/패스워드에 해당하는 회원 찾기
        MemberDTO memberDTO = dao.getMemberDTO(id, pass);

        // 찾은 회원의 이름에 따른 처리
        String memberName = memberDTO.getName();
        if (memberName != null) {  // 일치하는 회원 찾음
            req.setAttribute("authMessage", memberName + " 회원님 방가방가^^*");
        }
        else {  // 일치하는 회원 없음
            if (admin_id.equals(id))  // 관리자
                req.setAttribute("authMessage", admin_id + "는 최고 관리자입니다.");
            else  // 비회원
                req.setAttribute("authMessage", "귀하는 회원이 아닙니다.");
        }
        // req.getRequestDispatcher("/13Servlet/MemberAuth.jsp").forward(req, resp); // 이 파일은 직접 실행 된다
        req.getRequestDispatcher("/WEB-INF/view/MemberAuthView.jsp").forward(req, resp); // 이 파일은 실행 안됨 404 에러
        // MVC 패턴에서 View 는 컨트롤러를 통해서만 접근할 수 있도록 한다
        // Servlet(.java) 을 통해서 실행 할 수 있다.
        // 요즘은 이런 방식으로 숨긴다
    }

    @Override
    public void destroy() {
        dao.closeConnection(con);
    }
}
