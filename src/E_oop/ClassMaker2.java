package E_oop;

public class ClassMaker2 {
	//인스턴스변수 하나 선언, 명시적으로 초기화
	int x = 1;
	
	//위에서 선언한 인스턴스변수를 초기화 블럭을 사용해 초기화
	{
		x = 2;
	}
	
	//위에서 선언한 인스턴스변수를 생성자의 파라미터를 사용해 초기화
	ClassMaker2(int x){
		this.x = x;
	}
	
	//위에서 선언한 인스턴스변수를 생성자를 하나 더 만들어서 초기화
	ClassMaker2(){
		this(3);
	}
	
	//초기화 순서 : 명시적 초기화 -> 초기화 블럭 -> 생성자
	
	
	
	
	
	
}







