package B_Operator;

public class LocalOperator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 논리연산자
		 * &&(AND), ||(OR), !(NOT)
		 * 피연산자로 boolean만 허용한다.
		 */
		
		int x = 10;
		int y = 20;
		boolean b = 0 < x && x < 10 || x < y;  // &&와 ||가 같이 쓰이는 경우, &&의 우선순위가 높다
		System.out.println(b);
		
		b = !(x < y); //조건식 결과의 반대로 저장, 숫자를 비교할 경우 변수가 아닌 전체 비교연산의 앞에 !를 쓴다.
		System.out.println(b);
		
		//효율적 연산
		b = true && true; //t
		b = true && false; //f
		b = false && true; //f
		b = false && false; //f (and)
		
		b = true || true; //t
		b = true || false; //t
		b = false || true; //t
		b = false || false; //f
		//왼쪽의 피연산자에서 결과가 정해지면 오른쪽은 수행하지 않는다. (or)
		
		int a = 10;
		b = a < 5 && 0 < a++; //왼쪽에서 a<5가 false가 되면서 오른쪽의 0<a++가 수행하지 않게되엇다.
		System.out.println(a);
		
		//1. x가 y보다 크고, x가 10보다 작다.
		b = x > y && x < 10;
		
		
		//2. x가 짝수이고, x가 y의 배수이다.
		b = x%2 == 0 && y%x == 0;
		
		//3. x가 3의 배수이거나, x가 5의 배수이다.
		b = x%3==0 || x%5==0;
	}

}


