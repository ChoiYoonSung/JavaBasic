package K_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class JDBC2 {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "pc06";
		String password = "java";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url,user,password);
			
			String sql = "SELECT * FROM CART WHERE CART_MEMBER = ?"; //유동적으로 바뀔 수 있는 값은 ?로 작성한다
			ps = con.prepareStatement(sql);
			ps.setString(1, "a001"); //ps.setString(n,m)에서 n은 ? 위치의 순서, m은 대체 할 단어
//			ps.setObject(parameterIndex, x); //setObject : 타입에 상관없이 사용할 수 있음
			
			rs = ps.executeQuery();
			
			ResultSetMetaData md = rs.getMetaData(); //메타데이터 : 데이터에 대한 데이터
			
			int columnCount = md.getColumnCount();
			while(rs.next()){
				for(int i = 1; i <= columnCount; i++){
					System.out.print(md.getColumnName(i) + "\t");
					Object value = rs.getObject(i);
					System.out.print(value + "\t");
				}
				System.out.println();
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally { //닫을 때에는 연 순서의 역순으로 닫는다
			if(rs!=null) try {rs.close();} catch (Exception e) {}
			if(ps!=null) try {ps.close();} catch (Exception e) {}
			if(con!=null) try {con.close();} catch (Exception e) {}
		}
	}
	

}
