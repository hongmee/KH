package kr.or.iei.member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kr.or.iei.member.vo.Member;

public class MemberDao {

	
	
	public ArrayList<Member> selectAllMember(){
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ArrayList<Member> list = new ArrayList<Member>();
		String query = "select * from member_tbl";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","jdbc","1234");
			pstmt = conn.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				
				Member m = new Member();
				
				m.setAge(rset.getInt("member_age"));
				m.setEnrollDate(rset.getDate("enroll_date"));
				m.setMemberAddr(rset.getString("member_addr"));
				m.setMemberGender(rset.getString("member_gender"));
				m.setMemberId(rset.getString("member_id"));
				m.setMemberName(rset.getString("member_name"));
				m.setMemberPhone(rset.getString("member_phone"));
				m.setMemberPw(rset.getString("member_pw"));
				
				list.add(m);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
				rset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return list;
	}//selectAllMember

	public Member selectMemberId(String memberId) {
		Connection conn = null;
		// Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		Member m = null;
		//PreparedStatement에서는 쿼리문에서 변수값으로 대체될 부분을 ?(위치홀더)로 대체
		String query = "select * from member_tbl where member_id=?";
		//위치홀더는 리터럴을 대체해준다 --> '값'에 대한 부분만 처리 가능(테이블 이름, 컬럼명, 조건 불가능)				
		//-->위치홀더를 값으로 대체하기 전이어도 쿼리문은 문법상의 문제가 없어야 한다
		//위치홀더(?) : SQL구문에 나타내는 토큰, 실제 SQL문이 실행되기 전에 값으로 대체되어야 함
		//위치홀더를 값으로 대체하지 않고 쿼리문 실행 시 에러 발생
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "1234");
			
			/*
			    stmt = conn.createStatement();
				rset = stmt.executeQuery(query);
				
			*/
			
			
			//PrepareStatement 객체 생성 시에 쿼리문을 전달해줘야 함
			//추후에 ?(위치홀더)를 값으로 대체해주는 역할도 PrepareStatement
			pstmt = conn.prepareStatement(query);
			
			//위치홀더에 값 대입해주기
			pstmt.setString(1, memberId); //<--이 시점에서 쿼리문 완성
			rset = pstmt.executeQuery(); // <-- 쿼리문 실행 후 결과를 받아올때는 query를 매개변수로 주지 않음
			
			if(rset.next()) {
				m = new Member();
				m.setMemberId(rset.getString("member_id"));
				m.setMemberPw(rset.getString("member_pw"));
				m.setAge(rset.getInt("member_age"));
				m.setEnrollDate(rset.getDate("enroll_date"));
				m.setMemberAddr(rset.getString("member_addr"));
				m.setMemberPhone(rset.getString("member_phone"));
				m.setMemberName(rset.getString("member_name"));
				m.setMemberGender(rset.getString("member_gender"));
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rset.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return m;
	}//selectMemberId

	public ArrayList<Member> selectMemberName(String userName) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ArrayList<Member> list = new ArrayList<Member>();
		String query = "select * from member_tbl where member_name like ? ";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "1234");
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+userName+"%");
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Member m = new Member();
				m.setMemberId(rset.getString("member_id"));
				m.setMemberPw(rset.getString("member_pw"));
				m.setAge(rset.getInt("member_age"));
				m.setEnrollDate(rset.getDate("enroll_date"));
				m.setMemberAddr(rset.getString("member_addr"));
				m.setMemberPhone(rset.getString("member_phone"));
				m.setMemberName(rset.getString("member_name"));
				m.setMemberGender(rset.getString("member_gender"));
				
				list.add(m);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
				rset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return list;
	}//selectMemberName

	public int insertMember(Member m) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int result = 0;
		String query = "insert into member_tbl values(?,?,?,?,?,?,?,sysdate)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "1234");
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPw());
			pstmt.setString(3, m.getMemberName());
			pstmt.setString(4, m.getMemberAddr());
			pstmt.setString(5, m.getMemberPhone());
			pstmt.setInt(6, m.getAge());
			pstmt.setString(7, m.getMemberGender());
			
			result = pstmt.executeUpdate();
			
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
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return result;
	}//insertMember

	public int updateMember(Member m) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int result = 0;
		String query = "update member_tbl set member_pw=?,member_name=?,member_addr=?,member_phone=?,member_age=?,member_gender=? where member_id=?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "1234");
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getMemberPw());
			pstmt.setString(2, m.getMemberName());
			pstmt.setString(3, m.getMemberAddr());
			pstmt.setString(4, m.getMemberPhone());
			pstmt.setInt(5, m.getAge());
			pstmt.setString(6, m.getMemberGender());
			
			pstmt.setString(7, m.getMemberId());
			
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				conn.commit();
			}else{
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
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return result;
	}

	public int deleteMember(String memberId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int result = 0;
		String query = "delete member_tbl where member_id = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "1234");
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			result = pstmt.executeUpdate();
			
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
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return result;
	}

	
}//MemberDao
