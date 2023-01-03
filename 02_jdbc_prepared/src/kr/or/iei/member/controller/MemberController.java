package kr.or.iei.member.controller;

import java.util.ArrayList;
import java.util.Scanner;

import kr.or.iei.member.dao.MemberDao;
import kr.or.iei.member.vo.Member;

public class MemberController {

	private Scanner sc;
	private MemberDao dao;
	
	public MemberController() {
		super();
		sc = new Scanner(System.in);
		dao = new MemberDao();
	}
	
	
	public void main() {
		while(true) {
			
			System.out.println("------ 회원 관리 프로그램 ver.PrepareStatement ------");
			System.out.println("[1] 전체회원조회"); 		
			System.out.println("[2] 아이디로 회원 검색"); 	
			System.out.println("[3] 이름으로 회원 검색"); 	
			System.out.println("[4] 회원 가입"); 			
			System.out.println("[5] 회원 정보 수정");	    
			System.out.println("[6] 회원 탈퇴"); 			
			System.out.println("[0] 프로그램 종료");
			System.out.print("선택 >> ");
			int menu = sc.nextInt();
			
			switch (menu) {
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
				System.out.println("프로그램을 종료합니다");
				return;
			default:
				System.out.println("없는 메뉴입니다");
			}
			
			
		}//while
	}//main
	
	



	public void selectAllMember() {
		
		System.out.println("[ 1. 전 체 회 원 ]");
		
		ArrayList<Member> list = dao.selectAllMember();
		
		System.out.println("아이디\t비밀번호\t이름\t주소\t\t전화번호\t\t나이\t성별\t가입일");
		for(Member m : list) {
			System.out.println(m.getMemberId()+"\t"+m.getMemberPw()+"\t"+m.getMemberName()+"\t"+m.getMemberAddr()+"\t\t"+m.getMemberPhone()+"\t\t"+
		m.getAge()+"\t"+m.getMemberGender()+"\t"+m.getEnrollDate());
		}
		
		
		
		
	}//selectAllMember
	
	
	
	public void selectMemberId() {
		System.out.println("[ 2. selectMemberId ]");
		System.out.print("검색할 아이디를 입력하세요 : ");
		String memberId = sc.next();
		
		//select * from member_tbl where member_id='아이디'

		Member m = dao.selectMemberId(memberId);
		
		if(m != null) {
			System.out.println("아이디\t비밀번호\t이름\t주소\t\t전화번호\t\t나이\t성별\t가입일");
			System.out.println(m.getMemberName()+"\t"+m.getMemberPw()+"\t"+m.getMemberName()
			+"\t"+m.getMemberAddr()+"\t\t"+m.getMemberPhone()+"\t"+m.getAge()+"\t"+m.getMemberGender()+"\t"+m.getEnrollDate());
		}else {
			System.out.println("회원 정보를 찾을 수 없습니다.......");
		}
		
	}//selectMemberId
	
	
	
	private void selectMemberName() {
		
		System.out.println("[ 3. 이 름 으 로 검 색 ]");
		System.out.print("검색할 회원의 이름 : ");
		String userName = sc.next();
		
		ArrayList<Member> list = dao.selectMemberName(userName);
		
		if(list.size() == 0) {
			System.out.println("검색 결과가 없습니다 :'(");
		}else {
			System.out.println("아이디\t비밀번호\t이름\t주소\t\t전화번호\t\t나이\t성별\t가입일");
			for(Member m : list) {
				System.out.println(m.getMemberName()+"\t"+m.getMemberPw()+"\t"+m.getMemberName()
				+"\t"+m.getMemberAddr()+"\t\t"+m.getMemberPhone()+"\t"+m.getAge()+"\t"+m.getMemberGender()+"\t"+m.getEnrollDate());
			}
		}
		
	}//selectMemberName
	
	
	private void insertMember() {

		System.out.println("[ 4. 회 원 가 입 ]");
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
		System.out.print("성별 : ");
		String memberGender = sc.next();
		
		Member m = new Member(memberId, memberPw, memberName, memberAddr, memberPhone, memberAge, memberGender);
		
		int result = dao.insertMember(m);
		
		if(result > 0) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
		
		
	}//insertMember
	
	

	private void updateMember() {
		
		while(true) {
			
			System.out.print("수정할 아이디 입력 : ");
			String memberId = sc.next();
			
			if(dao.selectMemberId(memberId)==null) {
				System.out.println("수정할 회원이 없습니다");
				continue;
			}else {
				System.out.print("수정할 비밀번호 : ");
				String memberPw = sc.next();
				System.out.print("수정할 이름 :");
				String memberName = sc.next();
				System.out.print("수정할 주소 : ");
				sc.nextLine();
				String memberAddr = sc.nextLine();
				System.out.print("수정할 전화번호 : ");
				String memberPhone = sc.next();
				System.out.print("수정할 나이 : ");
				int memberAge = sc.nextInt();
				System.out.print("수정할 성별 : ");
				String memberGender = sc.next();
				
				Member m = new Member(memberId, memberPw, memberName, memberAddr, memberPhone, memberAge, memberGender);
				int result = dao.updateMember(m);
				
				if(result > 0) {
					System.out.println("수정완료");
					break;
				}else {
					System.out.println("수정실패");
					break;
				}
			}
		}//while 
		
	}//updateMember
	
	
	private void deleteMember() {
		
		System.out.println("[ ㅠㅠ. 회원 탈퇴 ~~~ ]");
	

		System.out.print("탈퇴할 아이디를 입력하세요 : ");
		String memberId = sc.next();
		
		if(dao.selectMemberId(memberId)==null) {
			System.out.println("존재하지 않는 회원입니다");
		}else { //회원이 존재한다면
		
			System.out.println("정말...탈퇴하시겠습니까?ㅠㅠ [예: 1 / 아니오: 그 외 모든 버튼] : ");
			String yesOrNo = sc.next();
			if(!yesOrNo.equals("1")) {
				System.out.println("기뻐요 :)");
				return;
			}else{
				
				int result = dao.deleteMember(memberId);
					if(result > 0) {
						System.out.println("회원 탈퇴 성공");
					}else {
						System.out.println("오류. 탈퇴 실패.");
					}
				
			}//회원이 존재하고 & 회원탈퇴를 진행할경우
		}
	}//deleteMember
	
	
	
	
}//MemberController
