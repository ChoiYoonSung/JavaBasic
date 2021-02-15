package I_api;

public class StringSpeedTest {
	
	public static void main(String[] args) {
		//기존 문자열에 다른 문자열을 추가하게 되면 새로운 객체가 생성되는 구조
		/*long start = System.currentTimeMillis();
		
		String str = "a";
		
		for (int i = 0; i < 200000; i++) {
			str += "a";
			
		}
		long end = System.currentTimeMillis();
		
		System.out.println(end - start + "ms");*/
		
		StringBuffer sb = new StringBuffer("a");
		
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			sb.append("a");
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start + "ms");
		
	}
}





