package kh.java.controller;

import java.util.Scanner;

import kh.java.vo.Silver;

public class PointMgr {

	private Scanner sc;
	private Silver[] members;
	private int index;
	
	
	public PointMgr() {
		sc = new Scanner(System.in);
		members = new Silver[10];
		index = 0;
	}
	
	
	public void main() {
		while(true) {
			System.out.println("===== 포인트 관리 프로그램 v.1 =====");
			System.out.println("[1] 회원 정보 등록");
			System.out.println("[2] 전체 회원 조회");
			System.out.println("[3] 회원 1명 조회");
			System.out.println("[4] 회원 정보 수정");
			System.out.println("[5] 회원 삭제");
			System.out.println("[0] 프로그램 종료");
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
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("지원하지 않는 메뉴입니다.");
				break;
			}
		}//메뉴 무한반복 while 끝
	}//main 메소드 끝
	
	public void insertMember() {
		System.out.println("===== 회원 정보 입력 =====");
		System.out.print("등급입력 : ");
		sc.nextLine();
		String grade = sc.nextLine();
		System.out.print("이름입력 : ");
		String name = sc.nextLine();
		System.out.print("포인트 입력 : ");
		int point = sc.nextInt();
		
		Silver s = new Silver();
		s.setGrade(grade);
		s.setName(name);
		s.setPoint(point);
		members[index] = s; 
		index++;
		System.out.println("등록완료!");
	}//insertMember 메소드 끝
	
	
	public void printAllMember() {
		System.out.println("===== 전체 회원 출력 =====");
		System.out.println("등급\t|\t이름\t|\t포인트\t|\t보너스");
		for(int i = 0 ; i<index ; i++) {
			Silver s = members[i];
			System.out.print(s.getGrade()+"\t|\t"+s.getName()+"\t|\t"+s.getPoint()+"\t|\t");
			System.out.printf("%.2f\n",s.getBonus());
			
		}
	}//printAllMember 메소드 끝
	
	public void printOneMember() {
		System.out.println("===== 회원 정보 출력 =====");
		System.out.print("조회 할 회원 이름 입력 : ");
		String name = sc.next();
		
		int searchIndex = searchIndex(name);
		
		if(searchIndex != -1) {
			Silver s = members[searchIndex];
			System.out.println("등급 : "+s.getGrade());
			System.out.println("이름 : "+s.getName());
			System.out.println("포인트 : "+s.getPoint());
			System.out.println("보너스 : "+s.getBonus());
		}else {
			System.out.println("회원 정보가 없습니다.");
		}
		
	}//printOneMember메소드 끝
	
	
	public int searchIndex(String searchName) {
		for(int i=0 ; i<index ; i++) {
			Silver s = members[i];
			if(searchName.equals(s.getName())) {
				return i;
			}
		}
		return -1;
	}//searchIndex 메소드 끝
	
	
	public void updateMember() {
		System.out.println("===== 회원 정보 수정 =====");
		System.out.print("수정할 회원 이름 입력 : ");
		String name = sc.next();
		int searchIndex = searchIndex(name);
		
		if(searchIndex != -1) {
			System.out.print("수정 등급 입력(현재 등급-"+members[searchIndex].getGrade()+"): ");
			String updateGrade = sc.next();
			System.out.print("수정 이름 입력(현재 이름-"+members[searchIndex].getName()+"): ");
			String updateName = sc.next();
			System.out.print("수정 포인트 입력(현재 포인트-"+members[searchIndex].getPoint()+"): ");
			int updatePoint = sc.nextInt();
	
			members[searchIndex].setGrade(updateGrade);
			members[searchIndex].setName(updateName);
			members[searchIndex].setPoint(updatePoint);
			members[searchIndex].setBonus(updatePoint);
	
			System.out.println("수정완료");
		}else {
			System.out.println("회원 정보가 없습니다.");
		}
	}//updateMember 메소드 끝
	
	
	public void deleteMember() {
		System.out.println("===== 회원 정보 삭제 =====");
		System.out.print("삭제할 회원 이름 입력 : ");
		String name = sc.next();
		int searchIndex = searchIndex(name);
		if(searchIndex == -1) {
			System.out.println("회원 정보가 없습니다.");
		}else {
			for(int i=searchIndex ; i<index-1 ; i++) {
				members[i] = members[i+1];
			}
			index--;
			members[index] = null;
			System.out.println("삭제완료.");
		}
	}//deleteMember메소드 끝
	
	
	
}//PointMgr 클래스 끝
