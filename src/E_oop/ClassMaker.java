package E_oop;

public class ClassMaker {
	//전역변수 하나 선언 및 초기화
	int x = 10;
	
	//리턴타입과 파라미터가 없는 메서드 하나
	//메서드 안에서 전역변수 출력
	void xmethod1(){
		System.out.println(x);
	}
	
	//전역변수와 동일한 타입의 리턴타입이 있고 파라미터는 없는 메서드
	//메서드 안에서 전역변수 리턴
	int xmethod2(){
		return x;
	}
	
	//리턴타입은 없고 파라미터가 있는 메서드
	//메서드 안에서 파라미터를 출력
	void xmethod3(int a){
		System.out.println(a);
	}
	
	//int타입의 리턴타입과 int타입의 파라미터 두개가 있는 메서드 하나
	//메서드 안에서 두 파라미터를 곱한 결과 리턴
	int xmethod4(int b, int c){
		return b*c;
	}
	//리턴 : 값을 넘겨주는 역할, 메서드를 종료시키는 역할
	
	
	
	
	
	
}




