package membership;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import common.JDBCConnect;
import common.JDBCConnect2;

public class MemberDAO extends JDBCConnect {

	public MemberDAO() {
		super();
	}

	// 명시한 데이터베이스로의 연결이 완료된 MemberDAO 객체를 생성합니다.
	public MemberDAO(String drv, String url, String id, String pw) {
		super(drv, url, id, pw);
	}

	// 명시한 아이디/패스워드와 일치하는 회원 정보를 반환합니다.
	public MemberDTO getMemberDTO(String uid, String upass) {
		MemberDTO dto = new MemberDTO(); // 회원 정보 DTO 객체 생성
		String query = "SELECT * FROM member WHERE id=? AND pass=?"; // 쿼리문 템플릿

		try {
			// 쿼리 실행
			psmt = con.prepareStatement(query); // 동적 쿼리문 준비
			psmt.setString(1, uid); // 쿼리문의 첫 번째 인파라미터에 값 설정
			psmt.setString(2, upass); // 쿼리문의 두 번째 인파라미터에 값 설정
			rs = psmt.executeQuery(); // 쿼리문 실행

			// 결과 처리
			if (rs.next()) {
				// 쿼리 결과로 얻은 회원 정보를 DTO 객체에 저장
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString(3));
				dto.setRegidate(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dto; // DTO 객체 반환
	}

	public ArrayList<MemberDTO> getAllMemberDTO() {

		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();

		String query = "SELECT * FROM member"; // 쿼리문 템플릿

		try {
			// 쿼리 실행
			Statement st = con.createStatement(); // 동적 쿼리문 준비
			rs = st.executeQuery(query); // 쿼리문 실행

			// 결과 처리
			while (rs.next()) {
				MemberDTO dto = new MemberDTO();
				// 쿼리 결과로 얻은 회원 정보를 DTO 객체에 저장
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString(3));
				dto.setRegidate(rs.getString(4));

				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}

	public int insertMemberDTO(MemberDTO member) {

		// 쿼리문 생성
		String sql = "INSERT INTO member (id, pass, name) VALUES (?, ?, ?)";

		PreparedStatement psmt;
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, member.getId());
			psmt.setString(2, member.getPass());
			psmt.setString(3, member.getName());
			
			// 쿼리 수행
			int inResult = psmt.executeUpdate();
			System.out.println(inResult + "행이 입력되었습니다.");
			
			return inResult;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

}
