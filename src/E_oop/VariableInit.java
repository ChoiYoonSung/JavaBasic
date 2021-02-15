package E_oop;

public class VariableInit {
	//변수를 초기화하는 방법
	
	//명시적 초기화
	int var = 10;
	static int staticVar = 20;

	// 초기화블럭
	// 인스턴스변수를 초기화 할때
	{
		var = 10;
	}
	// 클래스변수를 초기화 할때
	static {
		staticVar = 20;
	}

	/*
	 * 생성자
	 * - 클래스와 같은 이름의 메서드
	 * - 인스턴스 변수를 초기화하기 위해 사용한다
	 * - 클래스에 생성자는 반드시 하나 이상 존재해야 한다
	 * - 직접 선언해주지 않으면 컴파일러가 기본 생성자를 만들어준다
	 * - 생성자는 객채생성을 위해 만들기 때문에 리턴타입이 없다
	 * 
	 * 생성자 사용 이유
	 * - 초기화에 여러줄의 코드가 필요할 때
	 * - 초기화에 파라미터가 필요할 때
	 */
	VariableInit() {
		var = 10;
	}

	public static void main(String[] args) {

		Init i = new Init();
		i.a = 1;
		i.b = 2;
		i.c = 3;

		Init i2 = new Init(4, 5, 6);
		
	}

}

class Init {
	int a, b, c;

	Init(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
		// this : 인스턴스 변수와 지역변수의 이름이 같을 때 둘을 구분하기 위해 사용한다
		// this.a(인스턴스변수) = a(지역변수)
	}
	
	//오버로딩 : 같은 이름의 메서드를 여러개 정의하는 것
	//메서드의 이름이 같더라도 파라미터의 내용이 다르면 다른 메서드로 취급한다
	Init() {
		this(1,2,3);
		//this() : 생성자에서 다른 생성자를 호출할 때 사용한다

	}

}

 
 