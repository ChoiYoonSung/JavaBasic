package C_statement;

import java.util.Scanner;

public class Baseball {

	public static void main(String[] args) {
		/*
		 * 숫자야구
		 * 1~9 숫자 3개 / S B O
		 */
		System.out.println("숫자야구를 시작하겠습니다.");
		System.out.println("======Rule======");
		System.out.println("임의의 숫자 3개가 생성되며.");
		System.out.println("숫자의 위치를 맞추면 됩니다.");
		System.out.println("같은 숫자는 없습니다.");
		System.out.println("================\r");
		
		Scanner sc = new Scanner(System.in);
		
		//랜덤 수 ran1, ran2, ran3 선언
		
		int ran1 = (int) (Math.random() * 9) + 1;
		int ran2 = (int) (Math.random() * 9) + 1;
		int ran3 = (int) (Math.random() * 9) + 1;
		
		while(ran1 == ran2 || ran2 == ran3 || ran1 == ran3){
			ran1 = (int) (Math.random() * 9) + 1;
			ran2 = (int) (Math.random() * 9) + 1;
			ran3 = (int) (Math.random() * 9) + 1;
		}
		//랜덤 수 3개 발생
		
		int ans1, ans2, ans3;
		int scount, bcount, ocount;

		do {
			System.out.println("서로 다른 숫자 3개를 입력하십시오. (ex. 123)");
			int ans = Integer.parseInt(sc.nextLine());
			
			ans1 = ans/100;
			ans2 = (ans - (ans/100)*100)/10;
			ans3 = ans - ((ans/100)*100) - ((ans-(ans/100)*100)/10)*10 ;
			//숫자 세개 입력
			
			scount = 0;
			bcount = 0;
			ocount = 0; 
			//카운트 초기화
			
			if(ans1 == ran1){
				scount++;
			}else if (ans1 == ran2 || ans1 == ran3){
				bcount++;
			}else ocount++;
			
			if(ans2 == ran2){
				scount++;
			}else if(ans2 == ran1||ans2 == ran3){
				bcount++;
			}else ocount++;
			
			if(ans3 == ran3){
				scount++;
			}else if(ans3 == ran1||ans3 == ran2){
				bcount++;
			}else ocount++;
			
			System.out.println(scount + "S " + bcount + "B " + ocount + "O\r");
			
		} while (ans1 != ran1 || ans2 != ran2 || ans3 != ran3);
		
		if(scount == 3){
			System.out.println("정답! 숫자는 \"" + ran1 + "" + ran2 + "" + ran3 + "\"이었습니다.");
		}
		
	}

}




