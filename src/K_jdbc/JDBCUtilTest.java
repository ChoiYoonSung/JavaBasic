package K_jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JDBCUtilTest {

	public static void main(String[] args) {
		JDBCUtil jdbc = JDBCUtil.getInstance();
		String sql = " select * from cart"
				   + " where cart_member = ?";
		List<Object> param = new ArrayList<>();
		param.add("a001");
		
		List<Map<String,Object>> list = jdbc.selectList(sql, param);
		System.out.println(list);
		
		
	}

}
