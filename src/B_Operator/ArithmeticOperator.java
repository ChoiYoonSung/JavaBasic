package B_Operator;

public class ArithmeticOperator {

	public static void main(String[] args) {
		/*
		 * 산술연산자
		 * 사칙연산 (+ , - , * , / , %)
		 * 복합연산자 (+= , -= , *= , /= , %=)
		 * 증감연산자 (++ , --)
		 */
		int x = 1;
		System.out.println("x = " + x );
		
		int result = 1;
		//아래의 문장을 복합연산자를 사용한 문장으로 만드시오
		//result = result + 10;
		result += 10;
		//result = result - 2 * 3;
		result -= 2 * 3;
		//result = result %5
		result %= 5;
		
		/* 증감연산자
		- 증가연산자(++) 변수의 값을 1 증가시킨다
		- 감소연산자(--) 변수의 값을 1 감소시킨다 */
		int i = 0;
		
		++i; //전위형 : 변수의 값을 읽어오기 전에 1 증가
		i++; //후위형 : 변수의 값을 읽어온 후에 1 증가
		--i;
		i--;
		
		i = 0;
		System.out.println("++i = " + ++i);
		i = 0;
		System.out.println("i++ = " + i++);
		System.out.println(i);
		
		//피연산자의 타입이 서로 같아야만 연산이 가능하다.
		
		int _int = 10;
		double _double = 3.14;
		double result2 = _int + _double; //표현범위가 더 큰 타입으로 형변환된다. (int _int -> double _int)
		System.out.println(result2);
		
		long _long = 1000L;
		_long = _int + _long;
		_int = _int + (int)_long; //형변환을 해주어야 에러가 나지 않음
		
		byte _byte = 5;
		short _short = 10;
		int result3 = _byte + _short; //연산은 4byte 보다 작은 타입은 int로 형변환된다.
		System.out.println(result3);
		
		char _char = 'a';
		char _char2 = 'b';
		_int = _char + _char2; //ASCII CODE로 변환되어 특정 숫자로 변환된다.('a' -> 97 , 'b' -> 98) / char = 2byte, int = 4byte
		System.out.println(_int);
		
		//오버플로우, 언더플로우
		//표현범위를 벗어나는 값을 표현할 때 발생하는 현상
		byte b = 127;
		b++;
		System.out.println(b); //byte 범위 -128 ~ 127, 오버플로우 : 가장 큰 값을 넘어서는 경우 가장 작은값으로 넘어감
		b--;
		System.out.println(b); // 언더플로우 : 가장 작은 값을 넘어서는 경우 가장 큰 값으로 넘어감
		
		//한줄씩 계산, 최종 결과값을 출력
		//1. 12345 + 654321
		float a, sum1;
		a = 123456 + 654321;
		sum1 = a;
		System.out.println("1. sum : " + sum1);
		//2. 1번위 결과값 * 123456
		float sum2;
		sum2 = sum1 * 123456;
		System.out.println("2. sum : " + sum2);
		//3. 2번의 결과값 / 123456
		float sum3;
		sum3 = sum2 / 123456;
		System.out.println("3. sum : " + sum3);
		//4. 3번의 결과값 - 654321
		float sum4;
		sum4 = sum3 - 654321;
		System.out.println("4. sum : " + sum4);	
		//5. 4번의 결과값 % 123456
		float sum5;
		sum5 = sum4 % 123456;
		System.out.println("5. sum : " + sum5);
		
		//3개의 int형 변수를 선언 및 초기화 후 합계와 평균을 구하시오
		int x1,x2,x3;
		x1 = 32523;
		x2 = 72759;
		x3 = 7571;
		double res = (x1 + x2 + x3) / 3.0;
		System.out.println(res);
		
		//Math.round() -> 소수점 첫번째 자리에서 반올림
		res = Math.round(res * 10) / 10.0;
		System.out.println(res);
	}

}
