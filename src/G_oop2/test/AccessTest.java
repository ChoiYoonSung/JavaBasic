package G_oop2.test;

import G_oop2.AccessModifier;

public class AccessTest extends AccessModifier{
	
	public static void main(String[] args){
		AccessModifier am = new AccessModifier();
		
		System.out.println(am.publicVar);
		am.publicMethod();

//		System.out.println(am.protectedVar);
//		am.protectedMethod();
		
		//새로이 클래스의 이름으로 생성자를 만들어 출력할 수 있게 한다
		AccessTest at = new AccessTest();

		System.out.println(at.protectedVar);
		at.protectedMethod();
		
//		System.out.println(at.defaultVar);
//		at.defaultMethod();
	}
}
