package kr.or.iei.member.controller;

import java.util.Scanner;

import kr.or.iei.member.vo.Member;
import kr.or.member.service.MemberService;

public class MemberController {

	private Scanner sc;
	private MemberService service;
	
	
	public MemberController() {
		super();
		sc = new Scanner(System.in);
		service = new MemberService();
		
	}//생성자
	
	
	public void main() {
		
		while(true) {
			
			System.out.println("===== 회원 관리 프로그램 ver.service =====");
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
			case 2:
				selectMemberId();
				break;
			case 5:
				updateMeber();
				break;
			case 6:
				deleteMember();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다");
				return;
			default:
				System.err.println("없는 메뉴입니다");
				break;
			}//switch
			
		}//while
		
	}//main


	private void deleteMember() {
		//select * from member_tbl where member_id =? ;
		//delete from member_tbl where member_id = ? ;
		//insert into test_tbl values(아이디,이름,전화번호,sysdate);
		
		System.out.print("삭제할 회원 아이디를 입력하세요 : ");
		String memberId = sc.next();
		
		int result = service.deleteMember(memberId);
		
		if(result > 0) {
			System.out.println("탈퇴완료");
		}else {
			System.out.println("오류. 탈퇴실패.");
		}
		
	}//deleteMember


	private void updateMeber() {
		//update member_tbl set member_pw=?,member_addr=?,member_phone=? where member_id=?;
		System.out.print("수정할 아이디 : ");
		String memberId = sc.next();
		System.out.print("수정할 비번 : ");
		String memberPw = sc.next();
		System.out.print("수정할 주소 : ");
		sc.nextLine();
		String memberAddr = sc.nextLine();
		System.out.print("수정할 전화번호 : ");
		String memberPhone = sc.next();
		
		Member m = new Member();
		m.setMemberId(memberId);
		m.setMemberPw(memberPw);
		m.setMemberAddr(memberAddr);
		m.setMemberPhone(memberPhone);
		
		int result = service.updateMember(m);
		
		if(result > 0) {
			System.out.println("정보변경 완료");
		}else {
			System.out.println("실패");
		}
		
	}//updateMeber


	private void selectMemberId() {
		
		System.out.print("조회할 아이디 입력 : ");
		String memberId = sc.next();
		
		
		Member m = service.selectMemberId(memberId);
		
		if(m == null) {
			System.out.println("회원을 조회할 수 없습니다");
		}else {
			System.out.println("아이디\t비밀번호\t이름\t주소\t\t전화번호\t\t나이\t성별\t가입일");
			System.out.println(m.getMemberName()+"\t"+m.getMemberPw()+"\t"+m.getMemberName()
			+"\t"+m.getMemberAddr()+"\t\t"+m.getMemberPhone()+"\t"+m.getMemberAge()+"\t"+m.getMemberGender()+"\t"+m.getEnrollDate());
		}
		
	}//selectMemberId
	
	
	
}//MemberController
