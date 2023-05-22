package membership;

import java.util.ArrayList;

public class MemberDAOTest {

	private static MemberDAO memberDAO = new MemberDAO();
	
	public static void main(String[] args) {
		
//		MemberDTO memberDTO = memberDAO.getMemberDTO("dohave", "1234");
//		System.out.println(memberDTO);
		
		ArrayList<MemberDTO> list = memberDAO.getAllMemberDTO();
		for(MemberDTO m : list) {
			System.out.println(m);
		}
		
		int index = 0;
		for(MemberDTO m : list) {
			index++;
			m.setId(m.getId() + index);
			m.setPass(m.getPass() + index);
			m.setName(m.getName() + index);
			memberDAO.insertMemberDTO(m);
		}
	}
}
