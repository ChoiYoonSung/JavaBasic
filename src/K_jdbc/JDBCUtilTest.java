package K_jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JDBCUtilTest {

	public static void main(String[] args) {
		JDBCUtil jdbc = JDBCUtil.getInstance();
	/*	String sql = " select * from cart"
				   + " where cart_member = ?";
		List<Object> param = new ArrayList<>();
		param.add("a001");
		
		List<Map<String,Object>> list = jdbc.selectList(sql, param);
		System.out.println(list);*/
		/*
		String sql = "select * from member where mem_id = ?";
		List<Object> param = new ArrayList<>();
		param.add("a001");
		
		Map<String, Object> hashMap = jdbc.selectOne(sql, param);
		System.out.println(hashMap);
		*/
		
		String sql = " insert into tb_jdbc_board values("
				+ " (select nvl(max(board_no),0)+1 from tb_jdbc_board)"
				+ " ,?,?,?,sysdate)";
		List<Object> param = new ArrayList<>();
		param.add("제목");
		param.add("내용");
		param.add("a001");
		
		int result = jdbc.update(sql, param);
		System.out.println(result);
		
	}

}
