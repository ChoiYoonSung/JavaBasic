package B_Operator;

import java.util.Scanner;

public class Etc {

	public static void main(String[] args) {
		/*
		 * 비트연산자
		 * |(OR), &(AND), ^, ~, <<, >>
		 * 비트단위로 연산
		 * 사용률이 떨어짐
		 * 
		 * 기타연산자
		 * .(참조연산자) : 특정 범위 내에 속해 있는 멤버를 지정할 때 사용한다
		 * (type) : 형변환
		 * ?:(삼항연산자) : 조건식 ? 조건식이 참일 경우 수행할 문장: 조건식이 거짓일 경우 수행할 문장
		 */
		//1byte : 01010101
		//비트 : 1byte 중 단위 하나 (0 or 1)
		
		System.out.println(10|15); // |: 둘다 0인 경우 0 그외 1
		//10 : 00001010
		//15 : 00001111
		//     00001111
		
		int x = 10;
		int y = 20;
		int result = 10 < y ? x : y; // 10<y? true면 x, false면 y -> int result = x;
		System.out.println(result);
		
		//주만등록번호 뒷자리의 첫번째 숫자가 1이면 남자 2이면 여자
		int regNo = 4;
		String gender = regNo == 1? "Male" : "Female";
		System.out.println("성별 : " + gender);
		
		gender = regNo == 1? "Male" : (regNo==2? "Female" : "확인불가");
		System.out.println("성별  : " +gender);
		
		//Q. 2개의 숫자를 입력받고, 둘 중 더 큰 숫자를 출력하시오
		int x1, x2;
		
		Scanner sc = new Scanner(System.in); //입력하기 위해선 1번 입력하여야 한다.
		System.out.println("숫자 2개를 입력하시오.");
		System.out.println("첫 번째 숫자 > ");
		x1 = Integer.parseInt(sc.nextLine());
		System.out.println("두 번째 숫자 > ");
		x2 = Integer.parseInt(sc.nextLine());
		
		int cpr = x1 > x2? x1 : x2;
		System.out.println("두 숫자 중 더 큰 숫자는 " + cpr + "");
		
		//Q. 숫자를 입력받고, 그 숫자가 1이나 3이면 남자를, 2나 4면 여자를 출력.
		//그 외의 숫자를 입력하면 확인불가
		
		int num1;

		System.out.println("1~4 중 숫자를 입력하시오 >");
		num1 = Integer.parseInt(sc.nextLine());
		
		System.out.println(gender = (num1==1 || num1==3) ? "Male"
				:(num1==2 || num1==4) ? "Female" : "확인불가");
	}

}





