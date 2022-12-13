package kh.java.controller;

import java.util.Scanner;

import kh.java.vo.Silver;

public class ReviewPointMgr {
	
	private Scanner sc ; //<--아직 이상태니까 null.. 참조형이니까
	private Silver[] members;
	private int index;
	
	
	public ReviewPointMgr() { //생성자는 메소드 영여이라 for문같은것도 적용된다~
		sc = new Scanner(System.in);
		members = new Silver[10];
		index = 0;
	}
	
	
	public void main() {
		
		while(true) {
			System.out.println("===(강의 복습용) 회원관리프로그램 v1 ===");
			System.out.println("1. 회원 정보 등록");
			System.out.println("2. 전체 회원 출력");
			System.out.println("3. 회원 1명 출력");
			System.out.println("4. 회원 정보 수정");
			System.out.println("5. 회원 정보 삭제");
			System.out.println("0. 프로그램 종료");
			System.out.print("선택 > ");
			int menu = sc.nextInt();
			switch (menu) {
			case 1:
				insertMember();
				break;
				
			case 2:
				printAllMember();
				break;
	
			case 3:
				printOneMember();
				break;
	
			case 4:
				updateMember();
				break;
	
			case 5:
				deleteMember();
				break;
	
			case 0:
				return;
	
			default:
				System.out.println("지원하지 않는 메뉴입니다.");
				break;
			}
		}//메뉴 반복용 while	
	}//main메소드 끝
	
	
	public void insertMember() {
		System.out.println("=== 회원 정보 등록 ===");
		System.out.print("회원 등급 입력[silver/gold/vip]: ");
		String grade = sc.next();
		System.out.print("회원 이름 입력 : ");
		String name = sc.next();
		System.out.print("포인트 입력 : ");
		int point = sc.nextInt();
		
		Silver s = new Silver();
		s.setGrade(grade);
		s.setName(name);
		s.setPoint(point);
		
		members[index] = s;
		index++;
		
		System.out.println("등록완료");
	}//insertMember 메소드 끝 
	
	public void printAllMember() {
		System.out.println("=== 회원 전체 출력 ===");
		System.out.println("등급\t이름\t포인트\t보너스");
		for(int i=0 ; i<index ; i++) {
			Silver s = members[i];
			String grade = s.getGrade();
			String name = s.getName();
			int point = s.getPoint();
			double bonus = members[i].getBonus();
			
			System.out.print(grade+"\t"+name+"\t"+point+"\t");
			System.out.printf("%.2f\n",bonus);
		}//for문 끝
	}//printAllMember메소드 끝
	
	
	public int searchIndex(String searchName) {
		for(int i = 0 ; i < index ; i++) {
	/*		Silver s = members[i]; //s에 members[i]의 주소가 얕은복사 된 상태
			if(searchName.equals(s.getName())) {
				return i;
			}
	*/
			if(searchName.equals(members[i].getName())) {
				return i;
			}
		}
		return -1;
	}//searchIndex 메소드 끝 
	
	
	public void printOneMember() {
		System.out.println("=== 회원 정보 출력 ===");
		System.out.print("조회 할 회원 이름 입력 : ");
		String name = sc.next();
		int searchIndex = searchIndex(name);
		if(searchIndex == -1) {
			System.out.println("회원 정보를 찾을 수 없습니다");
		}else {
			Silver s = members[searchIndex];
			System.out.println("등급 : "+s.getGrade());
			System.out.println("이름 : "+s.getName());
			System.out.println("포인트 : "+s.getPoint());
			System.out.printf("보너스 : %.2f\n",members[searchIndex].getBonus());
		}
		
	}//printOneMember 메소드 끝
	
	
	public void updateMember() {
		System.out.println("=== 회원 정보 수정 ===");
		System.out.print("수정할 회원 이름 입력 : ");
		String name = sc.next();
		int searchIndex = searchIndex(name);
		if(searchIndex == -1) {
			System.out.println("회원 정보를 찾을 수 없습니다");
		}else {
			System.out.print("변경할 회원 등급(수정 전-"+members[searchIndex].getGrade()+"): ");
			String updateGrade = sc.next();
			System.out.print("변경할 회원 이름(수정 전-"+members[searchIndex].getName()+"): ");
			String updateName = sc.next();
			System.out.print("변경할 포인트(수정 전-"+members[searchIndex].getPoint()+"): ");
			int updatePoint = sc.nextInt();
			
			Silver s = members[searchIndex]; //<--주소를 s한테 얕은복사 해준거임
			s.setGrade(updateGrade);
			s.setName(updateName);
			members[searchIndex].setPoint(updatePoint);

			System.out.println("수정 완료");
		}
		
	}//updateMember 메소드 끝
	
	
	public void deleteMember() {
		System.out.println("=== 회원 정보 삭제 ===");
		System.out.print("삭제할 회원 이름 입력 : ");
		String name = sc.next();
		int searchIndex = searchIndex(name);
		if(searchIndex == -1) {
			System.out.println("회원 정보를 찾을 수 없습니다");
		}else {
			for(int i=searchIndex ; i<index-1 ; i++) {
				members[i] = members[i+1];
			}
			index--;
			members[index] = null;
			System.out.println("삭제 완료");
		}
		
		
		
	}//deleteMember메소드 끝
	
	
	
	
	
}//ReviewPointMgr 클래스 끝!!
