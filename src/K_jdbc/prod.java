package K_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

import E_oop.ScanUtil;

public class prod {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "pc06";
		String password = "java";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url,user,password);
			
			int a = ScanUtil.nextInt();
			System.out.println("1.검색 2.수정");
			if(a == 1){
				System.out.println();
				String select = "SELECT MEM_ID, MEM_NAME, MEM_MILEAGE FROM MEMBER WHERE MEM_MILEAGE > 1000";
				ps = con.prepareStatement(select);
				
				rs = ps.executeQuery();
				
				ResultSetMetaData md = rs.getMetaData();
				int Collum = md.getColumnCount();
				
				while (rs.next()) {
					for (int i = 1; i <= Collum; i++) {
						System.out.print(md.getColumnName(i) + "\t");
						Object value = rs.getObject(i);
						System.out.print(value + "\t");
					}
					System.out.println();
				}
			}
			if(a == 2){
				System.out.println("테이블 : ");
				String table = ScanUtil.nextLine();
				System.out.println("셋 : ");
				String set = ScanUtil.nextLine();
				System.out.println("조건 : ");
				String where = ScanUtil.nextLine();
				
				String update = "UPDATE ? SET ? WHERE ?";
				ps = con.prepareStatement(update);
				ps.setString(1, table);
				ps.setString(2, set);
				ps.setString(3, where);
				
				int result = ps.executeUpdate();
				System.out.println(result + "개의 행 업데이트");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { //닫을 때에는 연 순서의 역순으로 닫는다
			if(rs!=null) try {rs.close();} catch (Exception e) {}
			if(ps!=null) try {ps.close();} catch (Exception e) {}
			if(con!=null) try {con.close();} catch (Exception e) {}
		}
	}
}
