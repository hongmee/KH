package kr.java.controller;

import java.util.ArrayList;
import java.util.Scanner;

import kr.java.vo.Gold;
import kr.java.vo.Grade;
import kr.java.vo.Silver;
import kr.java.vo.Vip;

public class PointMgr {

	Scanner sc;
	ArrayList<Grade> members;
	
	
	public PointMgr() {
		super();
		sc = new Scanner(System.in);
		members = new ArrayList<Grade>();
	}
	
	public void main() {
		
		while(true) {
		
		System.out.println("===== 포인트 관리 프로그램 v.H =====");
		System.out.println("[1] 회원 정보 저장");
		System.out.println("[2] 전체 정보 조회");
		System.out.println("[3] 회원 정보 검색");
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
			break;
		}//메뉴 switch
		
		}//메뉴 반복 while
		
	}//main
	
	
	public void insertMember() {
		System.out.println("===== 회원 정보 등록 =====");
		System.out.print("회원 등급 : ");
		String grade = sc.next();
		System.out.print("회원 이름 : ");
		String name = sc.next();
		System.out.print("회원 포인트 : ");
		int point = sc.nextInt();
		
		switch (grade) {
		case "silver":
			Silver s = new Silver(grade, name, point);
			members.add(s);
			break;
		case "gold":
			Gold g = new Gold(grade, name, point);
			members.add(g);
			break;
		case "vip":
			Vip v = new Vip(grade, name, point);
			members.add(v);
			break;
		default:
			System.out.println("없는 등급입니다");
			return;
		}
		System.out.println("정보 등록 완료.");
	}//insertMember
	
	public void printAllMember() {
		System.out.println("===== 회원 정보 출력 =====");
		System.out.println("등급\t이름\t포인트\t보너스");
		for(Grade g : members) {
			System.out.print(g.getGrade()+"\t"+g.getName()+"\t"+g.getPoint()+"\t");
			System.out.printf("%.2f",g.getBonus());
			System.out.println();
		}
	}//printAllMember
	
	public int searchMember(String searchName) {
		for(int i = 0 ; i < members.size() ; i++) {
			if(members.get(i).getName().equals(searchName)) {
				return i;
			}
		}
		return -1;
	}//searchMember
	
	public void printOneMember() {
		System.out.println("===== 회원 정보 검색 =====");
		System.out.print("검색할 회원 이름 : ");
		String name = sc.next();
		int searchIndex = searchMember(name);
		if(searchIndex == -1) {
			System.out.println("회원 정보가 없습니다");
		}else {
			Grade g = members.get(searchIndex);
			System.out.println("등급 : "+g.getGrade());
			System.out.println("이름 : "+g.getName());
			System.out.println("포인트 : "+g.getPoint());
			System.out.println("보너스 : "+g.getBonus());
		}
	}//printOneMember

	
	public void updateMember() {
		System.out.println("===== 회원 정보 수정 =====");
		System.out.print("수정할 회원 이름 : ");
		String name = sc.next();
		int searchIndex = searchMember(name);
		if(searchIndex == -1) {
			System.out.println("회원 정보가 없습니다.");
		}else {
			Grade g = members.get(searchIndex);
			System.out.print("수정할 등급(수정전-"+g.getGrade()+") : ");
			String updateGrade = sc.next();
			System.out.print("수정할 이름(수정전-"+g.getName()+") : ");
			String updateName = sc.next();
			System.out.print("수정할 포인트(수정전-"+g.getPoint()+") : ");
			int point = sc.nextInt();
			
			switch (updateGrade) {
			case "silver":
				Silver newS = new Silver(updateGrade, updateName, point);
				members.set(searchIndex, newS);
				break;
			case "gold":
				Gold newG = new Gold(updateGrade, updateName, point);
				members.set(searchIndex, newG);
				break;
			case "vip":
				Vip newV = new Vip(updateGrade, updateName, point);
				members.set(searchIndex, newV);
				break;
			default:
				System.out.println("잘못 입력하셨습니다");
				return;
			}//swith
			System.out.println("정보 수정 완료.");
		}
	}//updateMember
	
	public void deleteMember() {
		System.out.println("===== 회원 정보 삭제 =====");
		System.out.print("삭제할 회원 이름 : ");
		String name = sc.next();
		int searchIndex = searchMember(name);
		if(searchIndex == -1) {
			System.out.println("회원 정보가 없습니다.");
		}else {
			Grade g = members.get(searchIndex);
			System.out.println(g.getName()+"님의 정보를 정말 삭제하시겠습니까? [확인 : 0 입력]");
			if(sc.nextInt()==0) {
				members.remove(searchIndex);
				System.out.println("정보 삭제 완료.");
			}else {
				return;
			}
		}
	}//deleteMember
	
	
	
}//PointMgr
