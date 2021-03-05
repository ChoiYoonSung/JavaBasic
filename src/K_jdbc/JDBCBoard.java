package K_jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import E_oop.ScanUtil;

public class JDBCBoard {
	
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String user = "pc06";
	private static String password = "java";

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/DD");
	
	public static void main(String[] args) {
		/*
		 * 오라클 데이터베이스에 게시판 테이블을 생성하고, 게시판 프로그램을 만들어주세요 테이블 : TB_JDBC_BOARD 컬럼 :
		 * BOARD_NO, TITLE, CONTENT, USER_ID, REG_DATE
		 */
		new JDBCBoard().start();
	}
	
	private void start() {
		while(true){
			try {
				con = DriverManager.getConnection(url, user, password);
				String sql = "SELECT BOARD_NO, TITLE, CONTENT, USER_ID, REG_DATE FROM TB_JDBC_BOARD";
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();

				System.out.println("----------------------------");
				System.out.println("번호\t제목\t작성자\t작성일");
				System.out.println("----------------------------");
				while(rs.next()){
					System.out.print(rs.getObject("board_no") + "\t");
					System.out.print(rs.getObject("title")+ "\t");
					System.out.print(rs.getObject("user_id")+ "\t");
					System.out.println(sdf.format(rs.getObject("reg_date")));
				}

				System.out.println("----------------------------");
				System.out.println("1.조회\t2.등록\t3.종료");
				int input = ScanUtil.nextInt();

				int num = 0;
				switch (input) {
				case 1:
					search();
					
					break;
				case 2:
					num++;
					insert(num);
					int result = ps.executeUpdate();
					System.out.println(result + "개의 행 업데이트");
					break;
				case 3:
					System.out.println("종료");
					System.exit(0);
					break;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
	}

	private void search(){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			System.out.println("검색 번호 입력 : ");
			int i = ScanUtil.nextInt();
			String select = " SELECT BOARD_NO, TITLE, CONTENT, USER_ID, REG_DATE "
						  + "FROM TB_JDBC_BOARD WHERE BOARD_NO = ?";
			con = DriverManager.getConnection(url, user, password);

			ps = con.prepareStatement(select);
			ps.setInt(1, i);

			rs = ps.executeQuery();

			while (rs.next()) {
				System.out.print(rs.getInt("BOARD_NO") + "\t");
				System.out.print(rs.getString("TITLE") + "\t");
				System.out.println(rs.getString("CONTENT") + "\t");
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
	
	private void insert(int num){
		Connection con = null;
		PreparedStatement ps = null;
		
		System.out.println("등록하려는 내용을 입력하십시오.");
		System.out.println("제목 : ");
		String title = ScanUtil.nextLine();
		System.out.println("내용 : ");
		String content = ScanUtil.nextLine();
		System.out.println("이름 : ");
		String name = ScanUtil.nextLine();


		try {
			con = DriverManager.getConnection(url, user, password);
			String insert = " INSERT INTO TB_JDBC_BOARD(BOARD_NO, TITLE, CONTENT, USER_ID, REG_DATE)"
					  + " VALUES (("
					  + "SELECT NVL(MAX(BOARD_NO),0) + 1 FROM TB_JDBC_BOARD"
					  + "),?,?,?,SYSDATE)";
			ps = con.prepareStatement(insert);
			ps.setString(1, title);
			ps.setString(2, content);
			ps.setString(3, name);
			
			int result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (ps != null)	try {ps.close();} catch (Exception e) {}
			if (con != null) try {con.close();} catch (Exception e) {}
		}
	}
	
	
}



