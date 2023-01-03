package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {

	// Connection 생성 후 리턴
	// commit 처리
	// rollback 처리
	// 자원 반환(커넥션,stmt계열,rset계열)
	
	public static Connection getConnection() {
		
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "1234");
			conn.setAutoCommit(false); // <--자동으로 commit되는 기능을 비활성화 ★★★
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
	}//getConnection
	
	
	public static void commit(Connection conn) {
		try {
			
			if(conn!=null && !conn.isClosed()) { //<-- 커넥션 상태가 정상이면
				conn.commit();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}//commit
	
	public static void rollback(Connection conn) {
		try {
			
			if(conn!=null && !conn.isClosed()) { //<-- 커넥션 상태가 정상이면
				conn.rollback();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}//rollback
	
	
	public static void close(Connection conn) {
		
		try {
			if(conn!=null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//close(conn)
	
	
	public static void close(Statement stmt) {

		try {
			if (stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//close(stmt)
	
	
	
	public static void close(ResultSet rset) {

		try {
			if (rset != null && !rset.isClosed()) {
				rset.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//close(rset)
	
	
}//JDBCTemplate
