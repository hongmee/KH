package kr.or.iei.controller;

import java.util.Scanner;

import kr.or.iei.vo.Gold;
import kr.or.iei.vo.Grade;
import kr.or.iei.vo.Silver;
import kr.or.iei.vo.Vip;
import kr.or.iei.vo.Vvip;

public class PointMgrImpl implements PointMgr{

	private Scanner sc;
	private Grade[] members;
	private int index;
	
	private String gradeType;
	
	public PointMgrImpl() {
		super();
		sc = new Scanner(System.in);
		members = new Grade[40];
		index = 0;
		
		gradeType = "(silver/gold/vip/vvip)";
		
		// new Grade(); <--이렇게는 쓸 수 없다. 왜냐? Grade는 abstract클래스라 객체를 만들 수 없다. 부모타입으로서 자료형이 되어줄순 있음 (ㅠㅠ머라는거야)
	}

	@Override
	public void main() {
		while(true) {
			System.out.println("===== 포인트 관리 프로그램 v4 =====");
			System.out.println("[1] 회원 정보 등록");
			System.out.println("[2] 전체 회원 정보");
			System.out.println("[3] 회원 한명 검색");
			System.out.println("[4] 회원 정보 수정");
			System.out.println("[5] 회원 정보 삭제");
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
			}//메뉴 실행 switch
			
			
			
		}//메뉴반복 while문 끝
		
		
	}//main

	@Override
	public void insertMember() {
		System.out.println("===== 회원 정보 등록 =====");
		System.out.print("회원 등급 등록"+gradeType+" : ");
		String grade = sc.next();
		
		String name="";
		while(true) { 
			System.out.print("회원 이름 등록 : ");
			name = sc.next();
			if(searchMember(name) == -1) { //중복이름 없음!
					break;
			}else{
				System.out.println("중복된 이름은 사용할 수 없습니다");
			}
		}//중복검사 반복 while문
		
		System.out.print("포인트 등록 : ");
		int point = sc.nextInt();
		
		switch (grade) {
		case "silver":
			Silver s = new Silver(grade, name, point);
			members[index++] = s; //member[]배열은 Grade자료형인데, 다형성 때문의 Grade(부모)의 변수로 Silver(자식)객체를 다룰수 있는 것이다.
			break;
		case "gold":
			Grade g = new Gold(grade, name, point); //다형성
			members[index++] = g;
			break;
		case "vip":
			members[index++] = new Vip(grade, name, point); //다형성
			break;
		case "vvip":
			members[index++] = new Vvip(grade, name, point);
			break;
		default:
			System.out.println("등급을 잘못 입력하셨습니다.");
		}
	}//insertMember

	@Override
	public void printAllMember() {
		System.out.println("===== 전체 회원 정보 =====");
		System.out.println("등급\t이름\t포인트\t보너스");
		for(int i = 0 ; i < index ; i++) {
			Grade g = members[i];	
			System.out.println(g.getGrade()+"\t"+g.getName()+"\t"+g.getPoint()+"\t"+g.getBonus());
		}
	}//printAllMember

	@Override
	public void printOneMember() {
		System.out.println("===== 회원 한명 검색 =====");
		System.out.print("조회할 회원 이름 : ");
		String name = sc.next();
		
		int searchIndex = searchMember(name);
		
		if(searchIndex == -1) {
			System.out.println("회원 정보를 조회할 수 없습니다");
		}else {
			Grade g = members[searchIndex];
			System.out.println("등급 : "+g.getGrade());
			System.out.println("이름 : "+g.getName());
			System.out.println("포인트 : "+g.getPoint());
			System.out.println("보너스 : "+g.getBonus());
		}
		
		
	}//printOneMember

	@Override
	public void updateMember() {
		System.out.println("===== 회원 정보 수정 =====");
		System.out.print("수정할 회원 이름 : ");
		String name = sc.next();
		int searchIndex = searchMember(name);
		if(searchIndex == -1) {
			System.out.println("수정할 회원의 정보가 없습니다");
		}else {
			System.out.print("수정할 회원 등급"+gradeType+" : ");
			String updateGrade = sc.next();
			String updateName="";
			while(true) {
				System.out.print("수정할 회원 이름 : ");
				updateName = sc.next();
				if(searchMember(updateName) == -1) {
					break;
				}
				System.out.println("중복된 이름입니다");
			}
			System.out.print("수정할 회원 포인트 : ");
			int updatePoint = sc.nextInt();
			
			switch (updateGrade) {
			case "silver":
				members[searchIndex] = new Silver(updateGrade, updateName, updatePoint);
				break;
			case "gold":
				members[searchIndex] = new Gold(updateGrade, updateName, updatePoint);
				break;
			case "vip":
				members[searchIndex] = new Vip(updateGrade, updateName, updatePoint);
				break;
			case "vvip":
				members[searchIndex] = new Vvip(updateGrade, updateName, updatePoint);
				break;
			}
			System.out.println("수정 완료");
		}
	}//updateMember

	@Override
	public void deleteMember() {
		System.out.println("===== 회원 정보 삭제 =====");
		System.out.print("삭제할 회원 이름 : ");
		String name = sc.next();
		int searchIndex = searchMember(name);
		
		if(searchIndex == -1) {
			System.out.println("삭제할 회원 정보가 없습니다.");
		}else {
			for(int i=searchIndex ; i<index-1 ; i++) {
				members[i] = members[i+1];
			}
			members[--index] = null;
		}
		System.out.println("삭제 완료");
	}//deleteMember

	@Override
	public int searchMember(String searchName) {
		for(int i = 0 ; i < index ; i++) {
			if(members[i].getName().equals(searchName)) {
				return i;
			}
		}
		return -1;
	}//searchMember

}//PointMgrImpl 클래스 끝
