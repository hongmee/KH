package kr.or.iei.member.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import kr.or.iei.member.dao.MemberDao;
import kr.or.iei.member.vo.Member;

public class MemberService {
	
	private MemberDao dao ;

	public MemberService() {
		super();
		dao = new MemberDao();
	}//생성자

	public Member selectMemberId(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		
		Member m = dao.selectMemberId(conn,memberId);
		JDBCTemplate.close(conn);
		return m;
	}//selectMemberId

	public int updateMember(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.updateMember(conn,m);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}//updateMember

	public int deleteMember(String memberId) {

		Connection conn = JDBCTemplate.getConnection();
		
		int result = 0;
		Member m = dao.selectMemberId(conn, memberId);
		if(m!=null) { //지워줄 사용자가 있다면
			
			result = dao.deleteMember(conn,memberId);
			if(result > 0) { //delete를 성공했다면
				result = dao.delInsertMember(conn,m);
				if(result > 0) { //탈퇴 멤버 저장소에 insert도 성공했다면
					JDBCTemplate.commit(conn);
				}else { //delete는 해줬으나 제대로 insert하지 못했다면
					JDBCTemplate.rollback(conn);
				}//if문 - insert
			}//if문 - delete
		}//정보 조회
		
		JDBCTemplate.close(conn);
		
		return result;
	}//deleteMember

	public ArrayList<Member> selectAllMember() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Member> list = dao.selectAllMember(conn);
		JDBCTemplate.close(conn);
		return list;
	}//selectAllMember

	public ArrayList<Member> selectMemberName(String next) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Member> list = dao.selectMemberName(conn,next);
		JDBCTemplate.close(conn);
		return list;
	}//selectMemberName

	public int insertMember(Member m) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.insertMember(conn,m);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}//insertMember
	
	
	

}//MemberService

