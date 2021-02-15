package E_oop;

public class StaticTest {
	
	static int classVar; //클래스 변수
	int instanceVar; //인스턴스변수
		
	public static void main(String[] args){
		System.out.println(classVar);
		
		System.out.println(new StaticTest().instanceVar);
		//main 메소드는 이미 메모리에 올라가있지만 인스턴스변수는 메모리에 올라가있지 않아
		//상위 클래스의 객체를 생성해야 사용할 수 있음
		StaticTest st = new StaticTest();
		System.out.println(st.instanceVar);
		//위의 두 코드의 내용은 같다
		
	}
	
	void instanceMethod(){
		System.out.println(classVar);
		System.out.println(instanceVar);
	}
}
