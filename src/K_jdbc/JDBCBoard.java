package K_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import E_oop.ScanUtil;

public class JDBCBoard {
	
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String user = "pc06";
	private static String password = "java";

	public static void main(String[] args) {
		/*
		 * 오라클 데이터베이스에 게시판 테이블을 생성하고, 게시판 프로그램을 만들어주세요 테이블 : TB_JDBC_BOARD 컬럼 :
		 * BOARD_NO, TITLE, CONTENT, USER_ID, REG_DATE
		 */
		

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(url, user, password);
			String sql = "SELECT * FROM TB_JDBC_BOARD";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			ResultSetMetaData md = rs.getMetaData();
			int Collum = md.getColumnCount();

			System.out.println("----------------------------");
			System.out.println("번호\t제목\t작성자\t작성일");
			System.out.println("----------------------------");
			while (rs.next()) {
				for (int i = 1; i < args.length; i++) {
					System.out.print(rs.getInt("BOARD_NO") + "\t");
					System.out.print(rs.getString("TITLE") + "\t");
					System.out.print(rs.getString("USER_ID") + "\t");
					System.out.print(rs.getDate("REG_DATE"));
					System.out.println();
				}
			}
			System.out.println("1.조회\t2.등록\t3.종료");
			int a = ScanUtil.nextInt();

			int no = 0;
			JDBCBoard jb = new JDBCBoard();
			switch (a) {
			case 1:
				jb.search();

				break;

			case 2:
				no++;


				int result = ps.executeUpdate();
				System.out.println(result + "개의 행 업데이트");
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	private void search(){
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "pc06";
		String password = "java";

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			System.out.println("검색 번호 입력 : ");
			int i = ScanUtil.nextInt();
			String select = " SELECT BOARD_NO, TITLE, CONTENT, USER_ID, REG_DATE "
						  + "FROM TB_JDBC_BOARD WHERE BOARD_NO = ?";

			ps = con.prepareStatement(select);
			ps.setInt(1, i);

			rs = ps.executeQuery();

			while (rs.next()) {
				System.out.print(rs.getInt("BOARD_NO") + "\t");
				System.out.print(rs.getString("TITLE") + "\t");
				System.out.print(rs.getString("USER_ID") + "\t");
				System.out.print(rs.getDate("REG_DATE"));
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally { // 닫을 때에는 연 순서의 역순으로 닫는다
			if (rs != null)
				try {rs.close();} catch (Exception e) {}
			if (ps != null)	try {ps.close();} catch (Exception e) {}
			if (con != null)
				try {con.close();} catch (Exception e) {}
		}
	}
	
	void insert(){
		String url = "jdbc:oracle:thin@localhost:1521:xe";
		String user = "pc06";
		String password = "java";
		
		Connection con = null;
		PreparedStatement ps = null;
		
		System.out.println("등록하려는 내용을 입력하십시오.");
		System.out.println("제목 : ");
		String title = ScanUtil.nextLine();
		System.out.println("내용 : ");
		String content = ScanUtil.nextLine();
		System.out.println("이름 : ");
		String name = ScanUtil.nextLine();

		String insert = "INSERT INTO TB_JDBC_BOARD(BOARD_NO, TITLE, CONTENT, USER_ID, REG_DATE) VALUES (?,'?','?','?',SYSDATE)";
		ps = con.prepareStatement(insert);
		ps.setInt(1, no);
		ps.setString(2, title);
		ps.setString(3, content);
		ps.setString(4, name);
	}
	
	
}



