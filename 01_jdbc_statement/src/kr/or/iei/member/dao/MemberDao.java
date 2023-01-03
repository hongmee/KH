package kr.or.iei.member.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kr.or.iei.member.vo.Member;

public class MemberDao {
	//데이터베이스에 접속하고, 쿼리문을 수행하고, 결과를 되돌려주는 클래스
	//DAO : Data Access Object
	
	
	
	
	//데이터베이스에 접속해서 전체 회원을 조회하여 리턴하는 메소드
	public ArrayList<Member> selectAllMember(){
		// [0] 자원반환을 해야하는 객체를 미리 선언
		Connection conn = null; // 2번에서 사용할 객체
		Statement stmt = null; // 3번에서 사용할 객체
		ResultSet rset = null; // 4번에서 사용할 객체(SELECT인 경우에만 사용)
		
		ArrayList<Member> list = new ArrayList<Member>(); //결과를 반환할 객체
		
		// 사용할 쿼리문 작성 (문자열에 작성, ;은 반드시 제거)
		String query = "select * from member_tbl";
		
		
		try {
		// [1] 드라이버등록 : 연결 시 사용할 클래스 등록 (ojdbc6 을 추가했기 때문에 가능!)
			Class.forName("oracle.jdbc.driver.OracleDriver"); //import해서 직접 쓰는건 아니고 패키지.클래스 위치만 알려주면 쓸수있음
			
		// [2] 커넥션 생성 : 1번에서 등록한 드라이버를 이용해서 연결 생성
		// 접속에 문제가 없으면 Connection 객체 리턴
		// 접속정보에 문제가 있으면 null 리턴
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","JDBC","1234");
			
		// [3] 쿼리문을 실행하고 결과를 가져올 객체 생성(Statement)	
		// 2번에서 만들어진 conn을 이용해서 생성
			stmt = conn.createStatement();
		
		// [4] 쿼리문 실행, [5] 쿼리문 실행결과를 저장
			rset = stmt.executeQuery(query); //<--SELECT문'만' 실행하는 메소드, 결과로 ResultSet을 반환.
			// 5-1. 수행결과를 자바에서 사용하기 위한 형태로 편집. = ResultSet에 있는 정보를 ArrayList<Member>로 변환해 주기
			// rset.next(); : ResultSet에서 커서를 한 줄 내리고(*최초 커서는 컬럼명 row를 가리키고 있음) 데이터가 있으면 true / false
			while(rset.next()) {
				String memberId = rset.getString("member_id");
				String memberPw = rset.getString("member_pw");
				String memberName = rset.getString("member_name");
				String memberAddr = rset.getString("member_addr");
				String memberPhone = rset.getString("member_phone");
				int memberAge = rset.getInt("member_age");
				char memberGender = rset.getString("member_gender").charAt(0);
				Date enrollDate = rset.getDate("enroll_date");
				
				Member m = new Member(memberId, memberPw, memberName, memberAddr, memberPhone, memberAge, memberGender, enrollDate);
				list.add(m);
			}//while
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
		// [6] 자원 반환하기		
				stmt.close();
				rset.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}//selectAllMember
	
	
	public Member selectMemberId(String searchMemberId) {
		
		// [0] 반환할 객체 선언
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null; //<-- SELECT를 쓸거면 이 객체는 꼭 선언해줘야 함
		// 결과처리할 변수
		Member m = null;
		
		String query = "select * from member_tbl where member_id='"+searchMemberId+"'";
		
		try {
			// [1] 드라이버 등록
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			
			// [2] 등록된 드라이버를 이용해 커넥션 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "1234");
			// ↑ 만약 이 접속에 문제가 있다면 null을 반환할거임
			
			
			// [3] 결과를 가져올 객체
			stmt = conn.createStatement();
					
			// [4] 쿼리문 수행하고 [5] 결과 저장하기
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				m = new Member();
				// m == null 조회가 되지 않음
				// m == 객체주소가 조회 성공
				
				String memberId = rset.getString("member_id");
				m.setMemberId(memberId);
				String memberPw = rset.getString("member_pw");
				m.setMemberPw(memberPw);
				String memberName = rset.getString("member_name");
				m.setMemberName(memberName);
				m.setMemberAddr(rset.getString("member_addr"));
				m.setMemberPhone(rset.getString("member_addr"));
				m.setMemberAge(rset.getInt("member_age"));
				m.setMemberGender(rset.getString("member_gender").charAt(0));
				m.setEnrollDate(rset.getDate("enroll_date"));
				
			}//if (어차피 한명 나올거니까 굳이 while 안 하기)
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// [6] 자원반환
			try {
				conn.close();
				stmt.close();
				rset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return m;
	}//selectMemberId
	
	
	public ArrayList<Member> selectMemberName(String searchName){
		// 0. 반환해줄거 먼저 선언
		Connection conn = null; //지역변수니까 처음부터 뭐라도 값 넣어주지 않으면 쓰레기 들어있어서 못씀
		Statement stmt = null;
		ResultSet rset = null;
		
		// 1. 결과처리할 변수와 쿼리문 작성
		ArrayList<Member> list = new ArrayList<Member>();
		String query = "select * from member_tbl where member_name like '%"+searchName+"%'";
		
		// 2. 드라이버 등록
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 3. 등록된 드라이버를 이용해 커넥션 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "1234");
			
			// 4. 결과를 받아올 객체
			stmt = conn.createStatement();
			
			// 5. 쿼리문 수행 및 결과 ResultSet에 담기
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				String memberId = rset.getString(1);
				String memberPw = rset.getString(2);
				String memberName = rset.getString(3);
				String memberAddr = rset.getString(4);
				String memberPhone = rset.getString(5);
				int memberAge = rset.getInt(6);
				char memberGender = rset.getString(7).charAt(0);
				Date enrollDate = rset.getDate(8);
				
				Member m = new Member(memberId, memberPw, memberName, memberAddr, memberPhone, memberAge, memberGender, enrollDate);
				list.add(m);
			}//while
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rset.close();
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}//selectMemberName
	
	
	public int insertMember(Member m) {
		Connection conn = null;
		Statement stmt = null;
		//수행할 query가 SELECT가 아니므로 ResultSet은 필요없다
		
		int result = 0; //결과처리할 변수
		String query =  "insert into member_tbl values('" + m.getMemberId() + "'," +
						"'" + m.getMemberPw() + "'," +
						"'" + m.getMemberName() + "'," +
						"'" + m.getMemberAddr() + "'," +
						"'" + m.getMemberPhone() + "'," +
						m.getMemberAge()+","+
						"'" + m.getMemberGender() + "',"+
						"sysdate)";
		System.out.println(query);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.41:1521:xe","jdbc","1234");
			stmt = conn.createStatement();
					
			result = stmt.executeUpdate(query); //<--결과는 쿼리수행으로 변경된 테이블의 행의 개수
			
			if(result > 0) { //<--insert가 정상적으로 수행됐을 경우
				conn.commit();
			}else { //<-- 정상적으로 수행되지 않을 경우
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
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
		
	}//insertMember
	
	
	public int updateMember(Member m) {
		
		Connection conn = null;
		Statement stmt = null;
		
		int result = 0;
		String query = "update member_tbl set member_pw='"+m.getMemberPw()+"',"+
					   "member_name='"+m.getMemberName()+"',"+
					   "member_addr='"+m.getMemberAddr()+"',"+
					   "member_phone='"+m.getMemberPhone()+"',"+
					   "member_age="+m.getMemberAge()+","+
					   "member_gender='"+m.getMemberGender()+"'"+
					   " where member_id='"+m.getMemberId()+"'";
		System.out.println(query);
					   
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.41:1521:xe", "jdbc", "1234");
			stmt = conn.createStatement();
			
			result = stmt.executeUpdate(query);
			
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
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return result;
	}//updateMember
	
	
	
	public int deleteMember(String memberId) {
		
		Connection conn = null;
		Statement stmt = null;
		
		int result = 0;
		String query = "delete member_tbl where member_id='"+memberId+"'";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.41:1521:xe", "jdbc", "1234");
			stmt = conn.createStatement();
			
			result = stmt.executeUpdate(query);
			
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
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}//deleteMember
	
	
	
}//MemberDao

