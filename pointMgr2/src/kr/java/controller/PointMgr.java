package kr.java.controller;

import java.util.Scanner;

import kr.java.vo.Gold;
import kr.java.vo.Silver;
import kr.java.vo.Vip;

public class PointMgr {

	Scanner sc;
	private Silver[] sMembers;
	private int sIndex;
	
	private Gold[] gMembers;
	private int gIndex;
	
	private Vip[] vMembers;
	private int vIndex;
	
	private char flag;
	
	public PointMgr() {
		super();

		sc = new Scanner(System.in);
		
		sMembers = new Silver[10];
		gMembers = new Gold[10];
		vMembers = new Vip[10];
		
		sIndex = 0;
		gIndex = 0;
		vIndex = 0;
		
		flag = 'A';
	}//생성자

	
	public void main() {
		while(true) {
			System.out.println("===== 포인트 관리 프로그램 v2 =====");
			System.out.println("1. 회원 정보 등록");
			System.out.println("2. 회원 전체 조회");
			System.out.println("3. 회원 1명 조회");
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
				printAllMembers();
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
			
			
		}//메뉴 반복 while 끝
		
	}//main메소드 끝
	
	
	public void insertMember() {
		System.out.println("===== 회원 정보 등록 =====");
		System.out.print("등록할 회원 등급[silver/gold/vip]: ");
		String grade = sc.next();
		System.out.print("등록할 회원 이름 : ");
		String name = sc.next();
		System.out.print("등록할 회원 포인트 : ");
		int point = sc.nextInt();
		
		switch (grade) {
		case "silver":
			Silver s = new Silver(grade,name,point);
			sMembers[sIndex] = s;
			sIndex++;
			break;
			
		case "gold":
			gMembers[gIndex] = new Gold(grade, name, point);
			gIndex++;
			break;
			
		case "vip":
			vMembers[vIndex++] = new Vip(grade, name, point); //<--vIndex에 후위연산을 사용해줌!!!!!!!!!!
			break;
			
		default:
			System.out.println("등록된 등급이 아닙니다");
			return;
		}
		System.out.println("회원 정보 등록 완료");
	}//insertMember 메소드 끝 
	
	
	public void printAllMembers() {
		System.out.println("===== 전체 회원 정보 =====");
		System.out.println("등급\t이름\t포인트\t보너스");
		for(int i=0 ; i<sIndex ; i++) {
			Silver s = sMembers[i]; //sMembers[i]의 주소가 s로 얕은복사됨
			String grade = s.getGrade();
			String name = s.getName();
			int point = s.getPoint();
			double bonus = s.getBonus();
			System.out.println(grade+"\t"+name+"\t"+point+"\t"+bonus);
		} //<--for
		for(int i=0 ; i<gIndex ; i++) {
			Gold g = gMembers[i];
			System.out.println(g.getGrade()+"\t"+g.getName()+"\t"+g.getPoint()+"\t"+g.getBonus());
		}
		for(int i=0 ; i<vIndex ; i++) {
			System.out.println(vMembers[i].getGrade()+"\t"+vMembers[i].getName()+"\t"+vMembers[i].getPoint()+"\t"+vMembers[i].getBonus());
		}
	}//printAllMembers 메소드 종료
	
	public void printOneMember() {
		System.out.println("===== 회원 1명 정보 =====");
		System.out.print("조회할 회원 이름 입력 : ");
		String name = sc.next();
		int[] searchIndex = searchMember(name);
		if(searchIndex[0] == 0 ) {
			System.out.println("회원 정보가 없습니다");
		}else {
			if(searchIndex[0] == 1) { //silver
				int i = searchIndex[1];
				Silver s = sMembers[i];
				System.out.println("등급 : "+s.getGrade());
				System.out.println("이름 : "+s.getName());
				System.out.println("포인트 : "+s.getPoint());
				System.out.println("보너스 : "+s.getBonus());
			}else if (searchIndex[0] == 2) { // gold
				Gold g = gMembers[searchIndex[1]];
				System.out.println("등급 : "+g.getGrade());
				System.out.println("이름 : "+g.getName());
				System.out.println("포인트 : "+g.getPoint());
				System.out.println("보너스 : "+g.getBonus());
			}else if (searchIndex[0] == 3) { // vip
				System.out.println("등급 : "+vMembers[searchIndex[1]].getGrade());
				System.out.println("이름 : "+vMembers[searchIndex[1]].getName());
				System.out.println("포인트 : "+vMembers[searchIndex[1]].getPoint());
				System.out.println("보너스 : "+vMembers[searchIndex[1]].getBonus());
			}
		}
	}//printOneMember 메소드 종료
	
	
	public int[] searchMember(String searchName) {
		int[] arr = new int[2];
		for(int i=0; i<sIndex ; i++) {
			Silver s = sMembers[i];
			if(searchName.equals(s.getName())) {
				arr[0]=1;
				arr[1]=i;
				return arr;
			}
		}
		for(int i=0; i<gIndex ; i++) {
			Gold g = gMembers[i];
			if(searchName.equals(g.getName())) {
				arr[0]=2;
				arr[1]=i;
				return arr;
			}
		}
		for(int i=0; i<vIndex ; i++) {
			Vip v = vMembers[i];
			if(searchName.equals(v.getName())) {
				arr[0]=3;
				arr[1]=i;
				return arr;
			}
		}
		return arr;
	}//searchMember메소드 끝
	
	public void deleteMember() {
		System.out.println("===== 회원 정보 삭제 =====");
		System.out.print("삭제할 회원의 이름 : ");
		String name = sc.next();
		int searchIndex = searchMember2(name);
		if(searchIndex == -1) {
			System.out.println("회원 정보를 찾을 수 없습니다");
		}else {
			if(flag=='s') {
				for(int i = searchIndex ; i<sIndex-1 ; i++) {
					sMembers[i] = sMembers[i+1];
				}
				sIndex--;
				sMembers[sIndex]= null;
			}else if(flag=='g') {
				for(int i = searchIndex ; i<gIndex-1 ; i++) {
					gMembers[i] = gMembers[i+1];
				}
				gIndex--;
				gMembers[gIndex]= null;
			}else if(flag=='v') {
				for(int i = searchIndex ; i<vIndex-1 ; i++) {
					vMembers[i] = vMembers[i+1];
				}
				vMembers[--vIndex]= null; //<--전위연산을 사용해줌!!!!!!!!!!
			}
			System.out.println("삭제완료.");
		}//else구문 끝
		
	}//deleteMember 메소드 끝
	
	
	public int searchMember2(String searchName) {
		for(int i=0 ; i<sIndex ; i++) {
			Silver s = sMembers[i];
			if(searchName.equals(s.getName())) {
				flag = 's';
				return i;
			}
		}
		for(int i=0 ; i<gIndex ; i++) {
			Gold g = gMembers[i];
			if(searchName.equals(g.getName())) {
				flag = 'g';
				return i;
			}
		}
		for(int i=0 ; i<vIndex ; i++) {
			if(searchName.equals(vMembers[i].getName())) {
				flag = 'v';
				return i;
			}
		}
		return -1;
	}//searchMember2 메소드 끝
	
	
	
	public void updateMember() {
		System.out.println("===== 회원 정보 수정 =====");
		System.out.print("수정할 회원 이름 입력 : ");
		String name = sc.next();
		int searchIndex = searchMember3(name);
		if(searchIndex == -1) {
			System.out.println("회원 정보가 없습니다.");
		}else {
			
			System.out.print("수정할 등급[silver/gold/vip] : ");
			String updateGrade = sc.next();
			System.out.print("수정할 이름 : ");
			String updateName = sc.next();
			System.out.print("수정할 포인트 : ");
			int updatePoint = sc.nextInt();
			
			//!!!!만약 등급이 수정되면 등급에 맞게 객체도 이동해야하니까 매우 번거로움!!!!!!!!!!
			
			if(searchIndex/100 == 1) { //<--1이 나온다면 vip라는 뜻.
				searchIndex -= 100;
				for(int i=searchIndex ; i < vIndex-1 ; i++) {
					vMembers[i] = vMembers[i+1];
				}
				vMembers[--vIndex] = null;
			}else if(searchIndex/10 == 1){ // gold
				searchIndex -= 10;
				for(int i=searchIndex ; i < gIndex-1 ; i++) {
					gMembers[i] = gMembers[i+1];
				}
				gMembers[--gIndex] = null;
			}else { 
				for(int i=searchIndex ; i < sIndex-1 ; i++) {
					sMembers[i] = sMembers[i+1];
				}
				sMembers[--sIndex] = null;
			}//silver
			
			switch (updateGrade) {
			case "silver":
				sMembers[sIndex] = new Silver(updateGrade, updateName, updatePoint);
				sIndex++;
				break;
			case "gold":
				gMembers[gIndex++] = new Gold(updateGrade, updateName, updatePoint);
				break;
			case "vip":
				vMembers[vIndex++] = new Vip(updateGrade, updateName, updatePoint);
				break;

			}//switch
			
		}//수정 else문 끝
		
	}//updateMember 메소드 끝
	
	
	public int searchMember3(String searchName) {
		for(int i=0 ; i<sIndex ; i++) {
			Silver s = sMembers[i];
			if(searchName.equals(s.getName())) {
				return i;
			}
		}
		for(int i=0 ; i<gIndex ; i++) {
			Gold g = gMembers[i];
			if(searchName.equals(g.getName())) {
				return i+10; //10~19의 값을 리턴한다
			}
		}
		for(int i=0 ; i<vIndex ; i++) {
			if(searchName.equals(vMembers[i].getName())) {
				return i+100; //100~109의 값을 리턴한다
			}
		}
		return -1;
	}//searchMember3 메소드 끝
	
	
	
}//PointMgr 클래스 끝
