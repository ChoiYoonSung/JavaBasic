package E_oop;

public class OOP {

	public static void main(String[] args) {
		/*
		 * 객체지향 프로그래밍(Object Oriented Programming)
		 * - 프로그래밍을 단순히 코드의 연속으로 보는 것이 아니라 객체간의 상호작용으로 보는 것
		 * - 코드의 재사용성이 높고 유지보수가 용이 
		 */
		
		SampleClass sc = new SampleClass();
		
		System.out.println(sc.bool);
		System.out.println(sc.field);
		
		sc.method1();
		
		String returnValue = sc.method2(10);
		System.out.println(returnValue);
		
		sc.flowTest1();
		
		//방금 만든 클래스의 객채를 생성, 변수에 저장
		//객체가 저장된 변수를 통해 메서드를 호출
		//파라미터가 있는 메서드는 타입에 맞는 값을 넘기고
		//리턴타입이 있는 메서드를 리턴받은 값을 출력
		
		ClassMaker cm = new ClassMaker();
		
		cm.xmethod1(); //리턴x 파라미터x
		
		System.out.println(cm.xmethod2()); //리턴o 파라미터x
		
		cm.xmethod3(30); //리턴x 파라미터o
		
		int returnValue2 = cm.xmethod4(20,50);  //리턴o 파라미터o
		System.out.println(returnValue2);
		
		System.out.println("------------------------------");
		
		Calculator cal = new Calculator();
		
		double result_plus = cal.plus(123456, 654321);
		System.out.println("1. " + result_plus);
		
		double result_mul = cal.mul(result_plus, 123456);
		System.out.println("2. " + result_mul);
		
		double result_div = cal.div(result_mul, 123456);
		System.out.println("3. " + result_div);
		
		double result_minus = cal.minus(result_div, 654321);
		System.out.println("4. " + result_minus);
		
		double result__else = cal._else(result_minus, 123456);
		System.out.println("5. " + result__else);
		
		
		
		
	}
}






