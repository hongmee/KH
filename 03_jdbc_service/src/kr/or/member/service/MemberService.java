package kr.or.member.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import kr.or.iei.member.dao.MemberDao;
import kr.or.iei.member.vo.Member;

public class MemberService {

	
	private MemberDao dao;

	public MemberService() {
		super();
		
		dao = new MemberDao();
	}//생성자

	
	
	public Member selectMemberId(String memberId) {
		// Connection 관리 : Connection 생성, close, commit, rollback;
		Connection conn = null;
		Member m = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "1234");
			
			m = dao.selectMemberId(conn,memberId);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return m;
		
	}//selectMemberId



	public int updateMember(Member m) {
		Connection conn = null;
		int result = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "1234");
			
			result = dao.updateMember(conn,m);
			if(result > 0) {
				conn.commit();
			}else {
				conn.rollback();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}//updateMember



	public int deleteMember(String memberId) {

		Connection conn = null;
		int result = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "1234");
			
			Member m = dao.selectMemberId(conn, memberId);
			
			if(m!=null) { // 조회결과가 있을경우
				result = dao.deleteMember(conn,memberId);
				if(result > 0) {
					result = dao.delMemberInsert(conn,m);
					if(result > 0) {
						conn.commit();
					}else {
						conn.rollback();
					}//집어넣기 성공-실패할경우
				}else {
					//MEMBER_TBL 에 delete가 실패하면 
					//DEL_MEMBER에 insert하지 않고 MEMBER_TBL에서 삭제된 데이터를 복구하는 롤백
					conn.rollback();
				}
			}//조회여부 if문

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}//deleteMember
	
	
	
	
	
}//MemberService
