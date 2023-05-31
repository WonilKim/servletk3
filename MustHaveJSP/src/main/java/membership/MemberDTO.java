package membership;

import java.io.Serializable;

public class MemberDTO implements Serializable{
	
	// 클래스의 데이터가 바뀌었을때 확인을 하기 위해서
	private static final long serialVersionUID = 1L;
	
	// 멤버 변수 선언
	private String id;
	private String pass;
	private String name;
	private String regidate;
	
	public MemberDTO() {
		this.id = "";
		this.pass = "";
		this.name = "";
		this.regidate = "";
	}
	
	public MemberDTO(String id, String pass, String name, String regidate) {
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.regidate = regidate;
	}

	// 멤버 변수별 게터와 세터
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegidate() {
		return regidate;
	}

	public void setRegidate(String regidate) {
		this.regidate = regidate;
	}

	@Override
	public String toString() {
		return "MemberDTO [" + "id = " + id + 
				", pass = " + pass + ", name = " + name + 
				", residate = " + regidate + "]";
	}
}