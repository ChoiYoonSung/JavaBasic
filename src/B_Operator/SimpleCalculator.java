package B_Operator;

import java.util.Scanner;

public class SimpleCalculator {

	public static void main(String[] args) {
		// 두 개의 숫자와 연산자를 입력받아 연산결과를 알려주는 프로그램
		// 숫자 2개 , 문자 1개. 산술연산자
		Scanner sc = new Scanner(System.in); //입력하기 위해선 1번 입력하여야 한다.

		System.out.println("간단한 계산만 가능합니다.");
		System.out.println("첫 번째 숫자를 입력하십시오.> ");
		int x = Integer.parseInt(sc.nextLine());
		
		System.out.println("어떤 연산을 하시겠습니까?");
		System.out.println("(더하기(+)/빼기(-)/곱하기(*)/나누기(/)/나머지(%))");
		String cal = sc.nextLine();
		
		System.out.println("두 번째 숫자를 입력하십시오. > ");
		int y = Integer.parseInt(sc.nextLine());
		
		Object result= cal.equals("더하기")||cal.equals("+")? x + y
				: cal.equals("빼기")||cal.equals("-")? x - y : cal.equals("곱하기")||cal.equals("*")? x * y
				: cal.equals("나누기")||cal.equals("/")? x / y : cal.equals("나머지")||cal.equals("%")? x % y : "연산불가";
		
		System.out.println(x + cal + y + "의 결과 값은 " + result + "입니다.");

	}

}
