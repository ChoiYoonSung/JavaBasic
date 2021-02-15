package J_collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class HashMapClass {
	public static void main(String[] args) {
		/*
		 * key로는 대부분 String을 사용한다
		 * Object put(Object key, Object value) : 지정된 키와 값을 저장한다
		 * Object remove(Object key) : 저장된 키로 저장된 값을 제거한다
		 * Object get(Object key) : 지정된 키의 값(없으면 null)을 반환한다
		 * Set keySet() : 저장된 모든 키를 Set으로 반환한다 -> 어떤 키로 저장되어 있는지 모를 때, 저장된 어떤 키들이 있는지 확인할 때
		 */
		//         키               값
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("number", 10);
		map.put("number2", 20);
		map.put("hangeul", "가나다라");
		map.put("scanner", new Scanner(System.in));
		//ArrayList와 달리 제네릭을 특정하지 않아도 괜찮다.
		//키를 이용해 값의 형태를 확인할 수 있기 때문
		
		System.out.println(map);
		
		map.put("number2","ABCD");
		System.out.println(map);
		
		map.remove("number");
		
		Object value = map.get("hangeul");
		System.out.println(value);
		
		System.out.println(((String)value).substring(0,1) + "...");
		
		//Set : 중복된 값을 가지지 않는 배열형태. 사용 빈도는 떨어진다.
		Set<String> keys = map.keySet();
		
		for(String key : keys){
			System.out.println(key + " : " + map.get(key));
		}
		
		/*
		 * 래퍼클래스 : 기본형 타입을 객체로 사용해야 할 때 대신 사용하는 클래스
		 * - byte : Byte
		 * - short : Short
		 * - int - Integer
		 * - long : Long
		 * - folat : Float
		 * - double : Double
		 * - char : Character
		 * - boolean : Boolean
		 */
		
		//회원테이블
		//아이디, 비밀번호, 이름, 전화번호
		ArrayList<HashMap<String, Object>> users = new ArrayList<>();
		
		HashMap<String, Object> user = new HashMap<>();
		user.put("id", "admin");
		user.put("password", "admin123");
		user.put("name", "관리자");
		user.put("tel", "010-0101-0101");
		users.add(user);
		
		HashMap<String, Object> user1 = new HashMap<>();
		user1.put("id","user1");
		user1.put("password","1q2w3e4r");
		user1.put("name","유저1");
		user1.put("tel","010-1234-1234");
		users.add(user1);
		
		for (int i = 0; i < users.size(); i++) {
			HashMap<String, Object> uk = users.get(i);
			for(String key : uk.keySet()){
				System.out.println(key + " : " + uk.get(key));
			}
		}
				
	}
}





