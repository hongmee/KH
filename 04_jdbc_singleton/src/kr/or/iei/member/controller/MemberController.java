package kr.or.iei.member.controller;

import java.util.ArrayList;
import java.util.Scanner;

import kr.or.iei.member.service.MemberService;
import kr.or.iei.member.vo.Member;

public class MemberController {

	private Scanner sc;
	private MemberService service;
	
	
	public MemberController() {
		super();
		sc = new Scanner(System.in);
		service = new MemberService();
	}
	
	public void main() {
		
		while(true) {
			System.out.println("===== 회원관리 프로그램 ver.Singleton =====");
			System.out.println("[1] 전체회원조회");
			System.out.println("[2] 아이디로 찾기");
			System.out.println("[3] 이름으로 찾기");
			System.out.println("[4] 회원 가입");
			System.out.println("[5] 회원정보 수정");
			System.out.println("[6] 회원 탈퇴");
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
				insertMemeber();
				break;
			case 5:
				updateMember();
				break;
			case 6:
				deleteMember();
				break;
			case 0 :
				System.out.println("bye :'(");
				return;
			default:
				System.out.println("없는 메뉴입니다");
				break;
			}//switch
			
		}//while
		
		
	}//main

	private void insertMemeber() {
		
		Member m = new Member();
		
		System.out.print("가입할 아이디 : ");
		m.setMemberId(sc.next());
		System.out.print("비밀번호 : ");
		m.setMemberPw(sc.next());
		System.out.print("이름 : ");
		m.setMemberName(sc.next());
		System.out.print("주소 : ");
		sc.nextLine();
		m.setMemberAddr(sc.next());
		System.out.print("전화번호 : ");
		m.setMemberPhone(sc.next());
		System.out.print("나이 : ");
		m.setMemberAge(sc.nextInt());
		System.out.print("성별[여/남] : ");
		m.setMemberGender(sc.next());
			
		int result = service.insertMember(m);
		
		if(result>0) {
			System.out.println("회원가입을 축하합니다");
		}else {
			System.out.println("뭔가 오류가 났음. 가입실패.");
		}
		
	}//insertMemeber

	private void selectMemberName() {

		System.out.print("조회할 사용자 이름 : ");
		ArrayList<Member> list = service.selectMemberName(sc.next());
		
		if(list.isEmpty()) {
			System.out.println("사용자 정보가 없습니다");
		}else {
			System.out.println("아이디\t비밀번호\t이름\t주소\t\t전화번호\t\t나이\t성별\t가입일");
			System.out.println("------------------------------------------------------------------");
			for(Member m : list) {
				System.out.println(m.getMemberId()+"\t"+m.getMemberPw()+"\t"+m.getMemberName()+"\t"+m.getMemberAddr()+"\t\t"+
								   m.getMemberPhone()+"\t"+m.getMemberAge()+"\t"+m.getMemberGender()+"\t"+m.getEnrollDate());	
			}
		}
		
	}//selectMemberName

	private void selectAllMember() {
		
		ArrayList<Member> list = service.selectAllMember();
		
		System.out.println("아이디\t비밀번호\t이름\t주소\t\t전화번호\t\t나이\t성별\t가입일");
		System.out.println("------------------------------------------------------------------");
		for(Member m : list) {
			System.out.println(m.getMemberId()+"\t"+m.getMemberPw()+"\t"+m.getMemberName()+"\t"+m.getMemberAddr()+"\t\t"+
							   m.getMemberPhone()+"\t"+m.getMemberAge()+"\t"+m.getMemberGender()+"\t"+m.getEnrollDate());	
		}
		
	}//selectAllMember

	private void deleteMember() {

		System.out.print("삭제할 아이디 입력 : ");
		
		int result = service.deleteMember(sc.next());
		
		if(result > 0) {
			System.out.println("탈퇴 성공");
		}else {
			System.out.println("오류. 탈퇴 실패");
		}
		
		
	}//deleteMember

	private void updateMember() {
		
		Member m = new Member();
		
		System.out.print("수정할 아이디 : ");
		String memberId = sc.next();
		m.setMemberId(memberId);
		System.out.print("수정할 비밀번호 : ");
		m.setMemberPw(sc.next());
		System.out.print("수정할 주소 : ");
		sc.nextLine();
		m.setMemberAddr(sc.nextLine());
		System.out.print("수정할 전화번호 : ");
		m.setMemberPhone(sc.next());
		
		int result = service.updateMember(m);
		if(result > 0) {
			System.out.println("정보 수정 완료");
		}else {
			System.out.println("오류.실패");
		}
		
		
	}//updateMember

	private void selectMemberId() {
		
		System.out.print("검색할 아이디 : ");
		String memberId = sc.next();
		
		Member m = service.selectMemberId(memberId);
		if(m==null) {
			System.out.println("정보를 조회할 수 없습니다");
		}else {
			System.out.println("아이디: "+m.getMemberId());
			System.out.println("비밀번호: "+m.getMemberPw());
			System.out.println("이름: "+m.getMemberName());
			System.out.println("주소: "+m.getMemberAddr());
			System.out.println("전화번호: "+m.getMemberPhone());
			System.out.println("나이: "+m.getMemberAge());
			System.out.println("성별: "+m.getMemberGender());
			System.out.println("가입일: "+m.getEnrollDate());
		}
		
	}//selectMemberId
	
	
	
	
	
}//MemberController
