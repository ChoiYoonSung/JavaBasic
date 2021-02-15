package E_oop;

public class JVM {

	public static void main(String[] args) {
		/*
		 * JVM(Java Virtual Machine)
		 * - 자바로 만들어진 프로그램이 실행되는 컴퓨터 안의 가상 컴퓨터
		 * - 운영체제 -> JVM -> 자바 프로그램
		 * - 장점 : 운영체제에 상관없이 실행할 수 있음
		 * - 단점 : 속도가 느림
		 * 
		 * JVM 메모리 구조
		 * - Method Area(메서드 영역) : 클래스 멤버가 저장된다
		 * - Call Stack(호출 스택) : 현재 호출되어 있는 메서드가 저장된다
		 * - Heap : 객체가 저장된다
		 */
		
		/*
		 * 마지막 GarbageCollector에 의해 삭제된 후 메모리에 남은 것들
		 * Method Area : main(), classVar, classMethod(), System.out 
		 * Heap : 
		 * Call Stack :
		 */
		
		System.out.println(classVar);
		
		classMethod();
		
		JVM jvm = new JVM();
		
		System.out.println(jvm.instanceVar);
		
		jvm.instanceMethod();
		
		jvm = null; //GarbageCollector에 의해 필요없어진 것은 삭제가 됨
		
	}

	int instanceVar;
	static int classVar;
	
	void instanceMethod(){
		System.out.println(instanceVar);
		System.out.println(classVar);
	}
	
	static void classMethod(){
//		System.out.println(instanceVar); //아직 메모리에 올라가지 않음
		System.out.println(classVar);
	}
}
