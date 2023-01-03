package kr.or.iei.member.controller;

import java.util.ArrayList;
import java.util.Scanner;

import kr.or.iei.member.dao.MemberDao;
import kr.or.iei.member.vo.Member;

public class MemberController {

	private Scanner sc;
	private MemberDao dao; //<--데이터베이스 관련 코드를 처리하는 객체를 전역번수로 선언 (여러 메소드에서 사용해야하므로)
	
	public MemberController() {
		super();
		sc = new Scanner(System.in); //객체생성
		dao = new MemberDao(); //객체생성
	}//생성자
	
	
	public void main() {
		while(true) {
			System.out.println("---------회원관리프로그램 v.1---------");
			System.out.println("[1] 전체회원조회"); 		//SELECT
			System.out.println("[2] 아이디로 회원 검색"); 	//SELECT
			System.out.println("[3] 이름으로 회원 검색"); 	//SELECT
			System.out.println("[4] 회원 가입"); 			//INSERT
			System.out.println("[5] 회원 정보 수정");	    //UPDATE
			System.out.println("[6] 회원 탈퇴"); 			//DELETE
			System.out.println("[0] 프로그램 종료");
			System.out.print("선택 >> ");
			int sel = sc.nextInt();
			
			switch (sel) {
			case 1:
				selectAllMember();
				break;
			case 2:
				selectMemberId();
				break;
			case 3:
				selectMemberName();
				break;
			case 4:
				insertMember();
				break;
			case 5:
				updateMember();
				break;
			case 6:
				deleteMember();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}//switch
		}//while
	}//main
	
	
	public void selectAllMember() {
		System.out.println("<<< 1. 전체회원출력 >>>");
		//여기서 DB작업이 필요한지 고민하기
		//필요하다면, 사용할 쿼리문 작성하기 : SELECT * FROM MEMBER_TBL;
		//↗위 쿼리문을 사용하기 위해서 사용자한테 입력받아야 할 값이 있는가?
		//사용자한테 입력받을 값이 없다면, 바로 쿼리문을 실행하고 결과받아오는 작업을 하면 된다
		
		/*
		 * 회원정보 1명을 받을거면 Member타입, 회원정보 여러개를 받을거면 Member[]...가 원래는 맞지만,
		 * 배열은 길이를 먼저 정해줘야 하므로 길이제한이 없는 배열 ArrayList<>
		*/
		ArrayList<Member> list = dao.selectAllMember();
		System.out.println("아이디\t비밀번호\t이름\t주소\t\t전화번호\t나이\t성별\t가입일");
		System.out.println("----------------------------------------------------------------------------------");
		for(int i = 0 ; i < list.size() ; i++) {
			Member m = list.get(i);
			System.out.print(m.getMemberId()+"\t");
			System.out.print(m.getMemberPw()+"\t");
			System.out.print(m.getMemberName()+"\t");
			System.out.print(m.getMemberAddr()+"\t\t");
			System.out.print(m.getMemberPhone()+"\t");
			System.out.print(m.getMemberAge()+"\t");
			System.out.print(m.getMemberGender()+"\t");
			System.out.println(m.getEnrollDate()+"\t");
		}//for
		
	}//selectAllMember
	
	
	public void selectMemberId() {
		System.out.println("<<< 2. 아이디로 회원 검색 >>>");

		// DB작업이 필요한지? --> 예
		// query문 작성 : select * from member_tbl where member_id = '아이디'
		// 쿼리문을 사용하기 위해서는 사용자에게 아이디를 입력받아야 함
		System.out.print("조회할 아이디를 입력하세요 : ");
		String memberId = sc.next();
		
		// 쿼리문에서 조건절이 primary key이기 때문에!!! 조회결과는 회원 0 or 1명이라고 확신할 수 있다 
		Member m = dao.selectMemberId(memberId);
		
		if( m == null ) {
			System.out.println("검색한 회원 정보가 없습니다.");
		}else {
			System.out.println("아이디\t비밀번호\t이름\t주소\t\t전화번호\t나이\t성별\t가입일");
			System.out.println("----------------------------------------------------------------------------------");
			System.out.print(m.getMemberId()+"\t");
			System.out.print(m.getMemberPw()+"\t");
			System.out.print(m.getMemberName()+"\t");
			System.out.print(m.getMemberAddr()+"\t\t");
			System.out.print(m.getMemberPhone()+"\t");
			System.out.print(m.getMemberAge()+"\t");
			System.out.print(m.getMemberGender()+"\t");
			System.out.println(m.getEnrollDate()+"\t");
		}

	}//selectMemberId
	
	
	public void selectMemberName(){
		System.out.println("<<< 2. 이름으로 회원 검색 >>>");
		
		// select * from member_tbl where member_name like '%searchName%'
		System.out.print("조회할 회원 이름을 입력하세요 : ");
		String searchName = sc.next();
		
		ArrayList<Member> list = dao.selectMemberName(searchName);
		if(list.isEmpty()) {
			System.out.println("검색 결과가 없습니다.");
		}else {
			System.out.println("아이디\t비밀번호\t이름\t주소\t\t전화번호\t나이\t성별\t가입일");
			System.out.println("----------------------------------------------------------------------------------");
			for(Member m : list) {
				System.out.print(m.getMemberId()+"\t");
				System.out.print(m.getMemberPw()+"\t");
				System.out.print(m.getMemberName()+"\t");
				System.out.print(m.getMemberAddr()+"\t\t");
				System.out.print(m.getMemberPhone()+"\t");
				System.out.print(m.getMemberAge()+"\t");
				System.out.print(m.getMemberGender()+"\t");
				System.out.println(m.getEnrollDate()+"\t");
			}//for
		}//if
	}//selectMemberName
	
	
	public void insertMember() {
		// insert into member_tbl values('아이디','비밀번호','이름','주소','전번','나이','성별',sysdate);
		System.out.println("<<< 3. 회원가입 >>>");
		System.out.print("아이디 : ");
		String memberId = sc.next();
		System.out.print("비밀번호 : ");
		String memberPw = sc.next();
		System.out.print("이름 : ");
		String memberName = sc.next();
		System.out.print("주소 : ");
		sc.nextLine();
		String memberAddr = sc.nextLine();
		System.out.print("전화번호 : ");
		String memberPhone = sc.next();
		System.out.print("나이 : ");
		int memberAge = sc.nextInt();
		System.out.print("성별[여/남] : ");
		char memberGender = sc.next().charAt(0);
		
		
		//방법 세가지
		//1. 모든 매개변수가 있는 생성자 사용
		//2. 매개변수에 enrollDate가 없는 생성자를 또 만들어서 사용
		Member m = new Member(memberId, memberPw, memberName, memberAddr, memberPhone, memberAge, memberGender);
		//3. 기본생성자로 객체 생성 후 (예시 : Member m = new Member(); ) setter로 값 집어넣기
		
		int result = dao.insertMember(m); //<--insert/update/delete를 수행하여 반영된 행의 수를 리턴. 무조건 정수로 받아줌.
		
		if(result > 0) {
			System.out.println("회원 가입을 축하합니다");
		}else{
			System.out.println("오류로 인해 가입에 실패하였습니다.");
		}
		
		
	}//insertMember
	
	
	
	public void updateMember() {
		System.out.println("<<< 4. 회원 정보 수정 >>>");
		//update member_tbl set member_pw = '수정후비번' where member_id = '바꿀아이디'
		
		System.out.print("수정할 아이디 입력 : ");
		String memberId = sc.next();
		
		System.out.print("수정할 비밀번호 : ");
		String memberPw = sc.next();
		System.out.print("수정할 이름 : ");
		String memberName = sc.next();
		System.out.print("수정할 주소 : ");
		sc.nextLine();
		String memberAddr = sc.nextLine();
		System.out.print("수정할 전화번호 : ");
		String memberPhone = sc.next();
		System.out.print("수정할 나이 : ");
		int memberAge = sc.nextInt();
		System.out.print("수정할 성별 : ");
		char memberGender = sc.next().charAt(0);
		
		Member m = new Member(memberId, memberPw, memberName, memberAddr, memberPhone, memberAge, memberGender);
		
		int result = dao.updateMember(m);
		
		if(result > 0) {
			System.out.println("수정완료");
		}else {
			System.out.println("오류로 인해 수정에 실패하였습니다.");
		}
		
	}//updateMember
	
	
	public void deleteMember() {
		System.out.println("<<< 5. 회원 탈퇴 >>>");
		//delete * from member_tbl where member_id = '아이디';
		
		System.out.print("탈퇴할 아이디를 입력하세요 : ");
		String memberId = sc.next();
		
		int result = dao.deleteMember(memberId);
		
		if(result > 0) {
			System.out.println("회원탈퇴에 성공했습니다.");
		}else {
			System.out.println("회원 탈퇴 실패");
		}
		
	}//deleteMember
	
	
	
}//MemberController
