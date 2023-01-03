package kr.or.iei.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import kr.or.iei.member.vo.Member;

public class MemberDao {

	public Member selectMemberId(Connection conn, String memberId) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member m = null;
		String query = "select * from member_tbl where member_id=?";
		
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Member(rset.getString("member_id"), rset.getString("member_pw"), rset.getString("member_name"), 
							   rset.getString("member_addr"), rset.getString("member_phone"), rset.getInt("member_age"), 
							   rset.getString("member_gender"), rset.getString("enroll_date"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return m;
	}//selectMemberId

	public int updateMember(Connection conn, Member m) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		String query = "update member_tbl set member_pw=?,member_addr=?,member_phone=? where member_id=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getMemberPw());
			pstmt.setString(2, m.getMemberAddr());
			pstmt.setString(3, m.getMemberPhone());
			pstmt.setString(4, m.getMemberId());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteMember(Connection conn, String memberId) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from member_tbl where member_id=?";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}//deleteMember

	public int delInsertMember(Connection conn, Member m) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "insert into test_tbl values(?,?,?,sysdate)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberName());
			pstmt.setString(3, m.getMemberPhone());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Member> selectAllMember(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ArrayList<Member> list = new ArrayList<Member>();
		String query = "select * from member_tbl";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Member m = new Member(rset.getString("member_id"), rset.getString("member_pw"), rset.getString("member_name"),
							   rset.getString("member_addr"), rset.getString("member_phone"), rset.getInt("member_age"), 
							   rset.getString("member_gender"), rset.getString("enroll_date"));
				list.add(m);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		
		return list;
	}

	public ArrayList<Member> selectMemberName(Connection conn, String next) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> list = new ArrayList<Member>();
		String query = "select * from member_tbl where member_name like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+next+"%");
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Member m = new Member(rset.getString("member_id"), rset.getString("member_pw"), rset.getString("member_name"),
									  rset.getString("member_addr"), rset.getString("member_phone"), rset.getInt("member_age"),
									  rset.getString("member_gender"), rset.getString("enroll_date"));
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		
		return list;
	}//selectMemberName

	public int insertMember(Connection conn, Member m) {
		
		PreparedStatement pstmt = null; //<--나중에 반납해줘야하기 때문에 여기에 써주는거임!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		
		int result = 0;
		String query = "insert into member_tbl values(?,?,?,?,?,?,?,sysdate)";
		
		try {
			pstmt = conn.prepareStatement(query);
			// --------- ↑ 여기까지는 아직 ?위치홀더가 채워지지 않았기 때문에 쿼리문이 실행이 안된상태임
			
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPw());
			pstmt.setString(3, m.getMemberName());
			pstmt.setString(4, m.getMemberAddr());
			pstmt.setString(5, m.getMemberPhone());
			pstmt.setInt(6, m.getMemberAge());
			pstmt.setString(7, m.getMemberGender());
			// --------- ↑ 여기에선 위치홀더가 채워지긴 했지만 실행이 안된상태
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}//insertMember

}//MemberDao
