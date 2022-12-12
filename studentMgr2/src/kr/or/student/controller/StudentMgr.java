package kr.or.student.controller;

import java.util.Scanner;

import kr.or.student.vo.Student;

public class StudentMgr {

	private Student[] students; // 학생정보를 저장하는 Student 배열
	private int index;			// 배열 인덱스 관리용 변수
	private Scanner sc;			// 입력을 받기위한 스캐너 객체
	
	public StudentMgr() { 		// 초기화를 위한 기본 생성자~!~!~!~!
		students = new Student[10];
		index = 0;
		sc = new Scanner(System.in);
	}
	
	public void main() {
		while(true) {
			System.out.println("\n----- 학생관리 프로그램 v2 -----\n");
			System.out.println("[1] 학생 정보 등록");
			System.out.println("[2] 학생 정보 조회(전체 학생)");
			System.out.println("[3] 학생 정보 조회(검색 학생)");
			System.out.println("[4] 학생 정보 수정");
			System.out.println("[5] 학생 정보 삭제");
			System.out.println("[0] 프로그램 종료");
			System.out.print("선택 > ");
			int menu = sc.nextInt();
			switch (menu) {
			case 1:
				insertStudent();
				break;
			case 2:
				printAllStudent();
				break;
			case 3:
				printOneStudent();
				break;
			case 4:
				updateStudent();
				break;
			case 5:
				deleteStudent();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("지원하지 않는 메뉴입니다.");
				break;
			}//메뉴 입력 switch
			
		}//메뉴 반복 while 끝
		
	}//main 메소드 끝
	
	
	public void insertStudent() {
		System.out.println("\n----- 학생 정보 등록 -----\n");
		System.out.print("학생 이름 입력 : ");
		String name = sc.next();
		System.out.print("학생 나이 입력 : ");
		int age = sc.nextInt();
		System.out.print("학생 주소 입력 : ");
		sc.nextLine(); //버퍼 제거용
		String addr = sc.nextLine();
		
		//입력받은 이름,나이,주소로 --> Student객체를 만들고 --> Student[] 배열에 저장 
		//객체를 만드는 방법은 두 가지가 있다.(Student 클래스 만들때 생성자 두 개 써줬으므로)
		//방법은 뭐가 맞고 틀리고 한건 아니고.. 상황에 따라 알아서 쓰자
		
		//방법 1. 객체를 만들어서 데이터를 저장하는 방법 ( 기본 생성자로 빈 객체 생성 후 setter 값 대입 )
/*		Student s = new Student(); //<--현재 이 단계에선 변수에 각 기본값이 들어있을 뿐.....
		s.setName(name); // name setter를 이용해서 값 대입
		s.setAge(age);
		s.setAddr(addr);
		
		students[index] = s; //setter로 받아온걸 students[]배열에 넣어줘야 정보가 등록됨!!!(당연함)
		index++;
		System.out.println("학생 정보 등록 완료.");
*/		
		
		
		//방법 2. 객체를 만들어서 데이터를 저장하는 방법 ( 매개변수가 있는 생성자를 이용해서, 객체를 생성하면서 바로 값을 대입 ) 
		Student s = new Student(name, age, addr); //<--이 값을 다 가지고 있지 않다면 쓸 수 없는 방법... ㅠㅠ
		
		students[index] = s;
		index++;
		System.out.println("학생 정보 등록 완료.");
		
	}//insertStudent 메소드 끝 
	
	
	public void printAllStudent() {
		System.out.println("\n----- 학생 정보 출력(전체 학생) -----\n");
		System.out.println("이름\t|\t나이\t|\t주소");
		System.out.println("------------------------------------------");
		for(int i = 0 ; i < index ; i++) {
			Student s = students[i];
			System.out.println(s.getName()+"\t|\t"+s.getAge()+"\t|\t"+s.getAddr());
		}
	}//printAllStudent 메소드 끝
	
	
	public int searchStudent(String searchName) {
		for(int i = 0 ; i<index ; i++) {
			Student s = students[i];
			String name = s.getName();
				if(name.equals(searchName)){
					return i;
				}
			}
		return -1;
	}//searchStudent 메소드 끝
	
	
	public void printOneStudent() {
		System.out.println("\n----- 학생 정보 출력(검색 학생) -----\n");
		System.out.print("검색할 학생의 이름을 입력하세요 : ");
		String name = sc.next();
		int searchIndex = searchStudent(name);
		if(searchIndex != -1) {
			Student s = students[searchIndex];
			System.out.println("이름\t|\t나이\t|\t주소");
			System.out.println("------------------------------------------");
			System.out.println(s.getName()+"\t|\t"+s.getAge()+"\t|\t"+s.getAddr());
			
		}else {
			System.out.println("조회 결과가 없습니다.");
		}
		
	}//printOneStudent 메소드 끝
	
	
	public void deleteStudent() {
		System.out.println("\n----- 학생 정보 삭제 -----\n");
		System.out.print("삭제할 학생 이름 : ");
		String name = sc.next();
		int searchIndex = searchStudent(name);
		if(searchIndex != -1) {
			for(int i = searchIndex ; i < index-1 ; i++) { //왜 index-1이냐면, 만약 i가 배열의 마지막 인덱스라면 i+1은 안되잖아.
				students[i] = students[i+1]; //이렇게 지워진.. 주소와 연결되지 못한 students[i]값은 JVM의 GC가 알아서 지워준다.
			}
			index--; //일단 for문 다 끝내고 index(앞으로 정보가 들어갈 배열인덱스)를 하나 낮춰줌
			students[index] = null;
			System.out.println("삭제 완료."); 
		}else {
			System.out.println("학생 정보를 조회할 수 없습니다");
		}
	}
	
	public void updateStudent() {
		System.out.println("\n----- 학생 정보 수정 -----\n");
		System.out.println("수정할 학생 이름 : ");
		String name = sc.next();
		int searchIndex = searchStudent(name);
		if(searchIndex == -1) {
			System.out.println("학생 정보를 조회할 수 없습니다");
		}else {
			Student s = students[searchIndex];
			System.out.print("이름 수정하기(수정 전-"+s.getName()+") : ");
			String updateName = sc.next();
			System.out.print("나이 수정하기(수정 전-"+s.getAge()+") : ");
			int updateAge = sc.nextInt();
			System.out.print("주소 수정하기(수정 전-"+s.getAddr()+") : ");
			String updateAddr = sc.next();
			
			//방법1. 해당 객체의 값을 변경하는 방법 (setter를 이용)
/*			s.setName(updateName);
			s.setAge(updateAge);
			students[searchIndex].setAddr(updateAddr);
			System.out.println("정보 수정 완료.");
*/			
			//방법2. 새로 객체를 만들어서 기존 자리에 주소를 넣어 교체하는 방법.(모든 값이 다 있을때 가능할듯~)
			Student s1 = new Student(updateName, updateAge, updateAddr) ;
			students[searchIndex] = s1;
			System.out.println("정보 수정 완료.");
			
		}
	}//updateStudent
	
	
	
	
}//StudentMgr 클래스 끝!!!
