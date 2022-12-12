package kr.or.student.controller;

import java.util.Scanner;

//(학생정보(이름,나이,주소) 10개를 관리하는 프로그램
public class StudentMgr {
	
	/*
	 이름 : String
	 나이 : int
	 주소 : String
	 */
	
	private Scanner sc; //키보드값 입력을 위한 객체
	
	private String[] names; //이름 저장할 배열
	private int[] ages; 	//나이 저장할 배열
	private String[] addrs; //주소 저장할 배열
	
	private int index; 		//학생 등록시 저장해야 할 인덱스번호
	
	
	public StudentMgr() {
		sc = new Scanner(System.in);
		names = new String[10];
		ages = new int[10];
		addrs = new String[10];
		index = 0;
	}
	
	/*메인메뉴 메소드*/
	public void main() {
		while(true) {
			System.out.println("\n----- 학생관리 프로그램 v1 -----\n");   //데이터의 다루기의 기본! CRUD
			System.out.println("[1] 학생 정보 등록"); 			         //Create
			System.out.println("[2] 학생 정보 출력(등록된 전체 학생)");      //Read
			System.out.println("[3] 학생 정보 출력(이름으로 검색)");        //Read
			System.out.println("[4] 학생 정보 수정");			        //Update
			System.out.println("[5] 학생 정보 삭제");			        //Delete
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
				System.out.println("프로그램을 종료합니다");
				return;
			default:
				System.out.println("지원하지 않는 메뉴입니다.");
				break;
			}//switch괄호 끝
		}//메뉴 반복 while문 끝
	}//main 메소드 끝
	
	
	public void insertStudent() { //학생정보를 입력받아서 배열에 저장하는 메소드
		System.out.println("\n----- 학생 정보 등록 -----\n");
		System.out.print("학생 이름 입력 : ");
		String name = sc.next();
		System.out.print("학생 나이 입력 : ");
		int age = sc.nextInt();
		System.out.print("학생 주소 입력 : ");
		sc.nextLine(); //<--버퍼에 남아있는 엔터 제거용도!!!!
		String addr = sc.nextLine();
		
		//index위치에 데이터 저장하기
		names[index] = name;
		ages[index] = age;
		addrs[index] = addr;
		
		System.out.println("학생 정보 등록 완료.");
		index++;//index는 다음 위치로 값 변경
	}//insertStudent메소드 끝 
	
	
	public void printAllStudent() { // 학생 출력(전체 학생)
		System.out.println("\n----- 학생 정보 출력 (전체 학생) -----\n");
		System.out.println("이름\t|\t나이\t|\t주소");
		System.out.println("--------------------------------------------");
		for(int i=0 ; i<index ; i++) {
			System.out.println(names[i]+"\t|\t"+ages[i]+"\t|\t"+addrs[i]);
		}
	}//printAllStudent메소드 끝
	
	
	public void printOneStudent() {// 학생 출력(검색 학생)
		System.out.println("\n----- 학생 정보 출력 (검색 학생) -----\n");
		System.out.print("조회할 학생의 이름을 입력하세요 : ");
		String name = sc.next();
		//입력받은 이름이 배열(names)의 몇번째에 있는지 찾아보기
/*		int searchIndex = -1; //조회되지 않았을 때, 사용할 값으로 초기화. 배열은 0부터 인덱스번호 시작하기 때문에 0으론 못해줌
		for(int i=0 ; i<index ; i++) {
			if(names[i].equals(name)) { //name.equals(names[i]로 써도 ㄱㅊ
				searchIndex = i;
				break;
			}
		}
		
*/
		int searchIndex = searchStudent(name);
		
		if(searchIndex == -1) {
			System.out.println("학생 '"+name+"'을(를) 조회할 수 없습니다.");
		}else {
			System.out.println("이름\t|\t나이\t|\t주소");
			System.out.println("--------------------------------------------");
			System.out.println(names[searchIndex]+"\t|\t"+ages[searchIndex]+"\t|\t"+addrs[searchIndex]);
		}
		
	}//printOneStudent 메소드 끝
	
	
	public void updateStudent() {// 학생 정보 수정
		System.out.println("\n----- 학생 정보 수정 -----\n");
		System.out.print("수정할 학생의 이름을 입력하세요 : ");
		String name = sc.next();
		int searchIndex = searchStudent(name);
/*		for(int i=0 ; i<index ; i++) {
			if(name.equals(names[i])) {
				searchIndex = i;
				break;
			}
		}//for문
*/		
		if(searchIndex != -1) { //이름이 조회가 된 경우
			System.out.print("수정할 이름(현재 이름 "+names[searchIndex]+"): ");
			String updateName = sc.next();
			System.out.print("수정할 나이(현재 나이 "+ages[searchIndex]+"): ");
			int updateAge = sc.nextInt();
			System.out.print("수정할 주소(현재 주소 "+addrs[searchIndex]+"): ");
			sc.nextLine();//버퍼 엔터 제거
			String updateAddr = sc.nextLine();
			names[searchIndex] = updateName;
			ages[searchIndex] = updateAge;
			addrs[searchIndex] = updateAddr;
			System.out.println("정보 수정이 완료되었습니다.");
		}else {
			System.out.println("학생 정보가 존재하지 않습니다.");
		}
	}//updateStudent메소드 끝
	
	
	public void deleteStudent() {
		System.out.println("\n----- 학생 정보 삭제 -----\n");
		System.out.print("삭제할 학생 이름 입력 : ");
		String name = sc.next();
		int searchIndex = searchStudent(name);
/*		for(int i = 0 ; i<index ; i++) {
			if(names[i].equals(name)) {
				searchIndex = i;
				break;
			}
		}
*/		
		
		if(searchIndex == -1) {
			System.out.println("학생 정보를 조회할 수 없습니다");
		}else {
			for(int i = searchIndex ; i<index-1 ; i++) { // 이거 왜 index-1인지 생각해봐!!!!!!!!!!
				names[i] = names[i+1];
				ages[i] = ages[i+1];
				addrs[i] = addrs[i+1];
			}//정보 삭제 for문
			index--;
			names[index] = null;
			ages[index] = 0;
			addrs[index] = null;
			System.out.println("학생 정보 삭제 완료.");
		}
	
	}//deleteStudent메소드 끝 
	
	
	public int searchStudent(String searchName) {//학생이 names배열의 몇번 인덱스인지 찾는 메소드
	/*	int searchIndex = -1;
		for(int i=0 ; i<index ; i++) {
			if(names[i].equals(searchName)) {
				searchIndex = i;
				break;
			}
		}
		return searchIndex;
	*/
		for(int i=0 ; i<index ; i++) {
			if(names[i].equals(searchName)) {
				return i;
			}
		}
		return -1;
	}//searchStudents메소드 끝
	
	
	
	

}//클래스 끝
