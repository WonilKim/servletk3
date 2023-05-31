package fileio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import membership.MemberDTO;

public class ObjectMain {

	public void serialize(MemberDTO obj, String fileName) throws IOException {
		try (FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {

			oos.writeObject(obj);
		}
	}

	public void serialize(ArrayList<MemberDTO> list, String fileName) throws IOException {
		try (FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {

			for(MemberDTO obj : list) {
				oos.writeObject(obj);
			}
		}
	}

	public MemberDTO deserialize(String fileName) throws IOException, ClassNotFoundException {
		MemberDTO m = null;
		try (FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis);) {

			m = (MemberDTO)ois.readObject();
		}		
		return m;
	}	
	
	public ArrayList<MemberDTO> deserializeList(String fileName) throws IOException, ClassNotFoundException {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		Object m = null;
		
		try (FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis);) {

			while((m = ois.readObject()) != null) {
				list.add((MemberDTO)m);
			}
		}		
		return list;
	}	
	
	public static void main(String[] args) throws Exception {
		
		ObjectMain om = new ObjectMain();

		om.serialize(new MemberDTO("id1", "pass1", "홍길동", "2023-05-31"), "testObject.dat");
		
		MemberDTO m = om.deserialize("testObject.dat");
		System.out.println(m);
		
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		
		list.add(new MemberDTO("id1", "pass1", "홍길동", "2023-05-31"));
		list.add(new MemberDTO("id2", "pass1", "홍길동", "2023-05-31"));
		list.add(new MemberDTO("id3", "pass1", "홍길동", "2023-05-31"));
		list.add(new MemberDTO("id4", "pass1", "홍길동", "2023-05-31"));
		
		om.serialize(list, "testObjects.dat");
		
		ArrayList<MemberDTO> listRead = om.deserializeList("testObjects.dat");
		System.out.println(listRead);

	}
}
