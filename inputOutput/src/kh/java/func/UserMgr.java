package kh.java.func;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class UserMgr {

	private User user;
	private Scanner sc;
	
	public UserMgr() {
		super();
		// TODO Auto-generated constructor stub
		sc = new Scanner(System.in);
	}
	
	public void main() {
		while(true) {
			System.out.println("1. User 정보 입력");
			System.out.println("2. User 정보 출력");
			System.out.println("3. User 정보 내보내기");
			System.out.println("4. User 정보 불러오기");
			System.out.print("선택 > ");
			int sel = sc.nextInt();
			switch (sel) {
			case 1:
				insertUser();
				break;
			case 2:
				printUser();
				break;
			case 3:
				saveUser();
				break;
			case 4:
				loadUser();
				break;
			}
		}
	}//main
	
	
	public void insertUser() {
		System.out.println("=== 1. 유저 정보 입력 ===");
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		user = new User(id, pw, name, age);
		System.out.println("등록 완료");
	}//insertUser
	
	
	public void printUser() {
		if(user != null) {
			System.out.println("아이디 : "+user.getId());
			System.out.println("비밀번호 : "+user.getPw());
			System.out.println("이름: "+user.getName());
			System.out.println("나이 : "+user.getAge());
		}else {
			System.out.println("유저 정보가 없습니다");
		}
	}//printUser
	
	
	public void saveUser() {
		if(user==null) {
			System.out.println("내보낼 데이터가 없습니다");
		}else {
			System.out.print("저장할 파일 명을 입력하세요 : ");
			String filename = sc.next();
			
			//객체를 내보내기 위한 보조스트림(내보내는 파일 형식이 사용자 정의 형식)
			ObjectOutputStream oos = null;
			
			try {
				//내보내기 위한 파일 생성 및 스트림연결을 위한 주스트림
				FileOutputStream fos = new FileOutputStream(filename);
				//주스트림을 이용한 보조스트림 생성
				oos = new ObjectOutputStream(fos);
				
				//객체 내보내기
				oos.writeObject(user); //<--반환타입이 Object (어떤 클래스가 들어올지 모르겠으니까 일단 Object클래스)
				System.out.println("[백업완료]");
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
	}//saveUser
	
	public void loadUser() {
		System.out.println("불러올 파일명을 입력하세요 : ");
		String filename = sc.next();
		
		ObjectInputStream ois = null;
		
		try {
			FileInputStream fis = new FileInputStream(filename);
			ois = new ObjectInputStream(fis);
			Object obj = ois.readObject();
			
			user = (User)obj; //<--다운캐스팅을 해줘야함
			System.out.println("로드완료");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}//loadUser
	
	
	
}//UserMgr
