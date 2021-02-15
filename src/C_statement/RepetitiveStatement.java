package C_statement;


public class RepetitiveStatement {

	public static void main(String[] args) {
		/*
		 * 반복문
		 * - for문
		 * - while문
		 * - do-while문
		 * 
		 * for문
		 * - for(초기화; 조건식; 증감식){}
		 * - 포함하고 있는 문장들을 정해진 횟수만큼 반복하는 문장
		 * 규칙이 있는 문장들을 효율적으로 작성하기 위해 사용
		 */
		
		for(int i = 1; i <= 10; i++){
			//초기화 : 조건식의 증감식에 사용할 변수 초기화
			//조건식 : 연산결과가 true면 블럭안의 내용을 수행
			//증감식 : 변수를 증가/감소시켜 반복문을 제어
			System.out.println(i + "번째");
			//초기화한 변수를 블럭 안에서 사용할 수 있음
		}
		
		int sum = 0;
		
		for(int i = 1; i <= 10; i++){
			sum += i;
		}
		
		System.out.println(sum);
		//
		sum = 0;
		for(int i = 10; i == 0; i--){
			sum -= i;
		}
		
		System.out.println(sum);
		
		//1부터 100까지 짝수의 합
		sum = 0;
		for(int i = 0; i <= 100; i++){
			if (i%2 == 0){
				sum += i;
			}
		}
		System.out.println(sum);
		
		sum=0;
		for(int i=2; i<=100; i+=2){
			sum += i;
		}
		System.out.println(sum);
		
		//1부터 100까지 홀수의 합을 출력해주세요
		sum=0;
		for(int i=1; i<=100; i+=2){
			sum += i;
		}
		System.out.println(sum);
		
		sum = 0;
		for(int i = 0; i <= 100; i++){
			if (i%2 == 1){
				sum += i;
			}
		}
		System.out.println(sum);
		
		//for문 활용 구구단
		/*
		 * 2 * 1 = 2
		 * 2 * 2 = 4
		 * ...
		 */
				
		
		///
		for(int i = 1; i<=9; i++){
			System.out.println("7 * " + i + " = " + i*7);
		}
		
		//구구단 전체
		sum = 0;
		
		for(int i = 2; i<=9; i++){
			System.out.println(i + "단");
			for(int j=1; j<=9; j++){
				sum =i*j;
				System.out.println(i + " * " + j + " = " + sum);
			}
		}
		
		//구구단 전체 가로
		for(int i = 1; i<=9; i++){
			for(int j=2; j<=9; j++){
				System.out.print(j + " * " + i + " = " + j*i + "\t"); // \t : tab
			}
			System.out.println("");
		}
		
		
		System.out.println("-------------------------");		
		/*
		 * while문
		 * - while(조건문){}
		 * - 포함하고 있는 문장들을 조건식이 만족하는 동안 반복하는 문장
		 * - 반복횟수가 정확하지 않은 경우에 주로 사용한다
		 */
		
		int a = 1;
		int count = 0;
		
		while(a < 1000){
			a *= 2;
			count++;
		}
		System.out.println("횟수 : " + count + " / 수 : " + a);
		
		/*
		 * do-while문
		 * - do()while(조건식);
		 * - while문의 변형식
		 * - 최소한 한번의 수행을 보장
		 */
		
		//숫자 맞추기 게임
		/*
		Scanner sc = new Scanner(System.in);
		
		int answer = (int)(Math.random() * 100) + 1;
		int x = 0;
		do{
				System.out.println("수 입력");
				x = Integer.parseInt(sc.nextLine());
		
				if (answer < x){
					System.out.println("답 보다 큽니다.");
				}else if(answer > x){
					System.out.println("답보다 작습니다.");
				}else if(answer == x){
					System.out.println("정답입니다.");
				}
		} while(x != answer );
		*/
		
		//이름 붙은 반복문 (반복문에만 사용이 가능)
		outer : for(int i = 2; i <= 9; i++){
			for(int j = 1; j <= 9; j++){
				if (j == 5){
//					break; // 가장 가까운 반복문 하나를 빠져나간다
//					break outer; // outer라는 이름의 반복문을 빠져나간다
//					continue; //가장 가까운 반복문의 현재 반복회차를 빠져나간다
//					continue outer; // outer라는 이름의 현재 반복회차를 빠져나간다
				}
				System.out.print(i + "*" + j + "=" + i*j + "\t");
			}
			System.out.println();
		}
		
		//별 모양 출력하기
		for(int i = 1; i <= 3; i++){
			for(int j = 1; j <= 5; j++){
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		//삼각형 별 모양 출력
		for (int i = 1; i <= 5; i++){
			for(int j = 1; j <= 6; j++){
				if(j > i){
					break;
				}
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println( "삼각형--------------");
		for (int i = 1; i <= 5; i++){
			for(int j = 1; j <= i; j++){
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println( "삼각형--------------");
		
		//
		for(int i = 1; i <= 5; i++){
			for(int j = 1; j <= 5; j++){
				if(j < i){
					continue;
				}
				System.out.print("*");
			}
			System.out.println();
		}
		
		for (int i = 5; i >= 1; i--){
			for(int j = 1; j <= i; j++){
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		System.out.println( "역삼각형--------------");

		//
		
		for (int i = 5; i >= 1; i--){
			for(int j = 1; j <= 5; j++){
				if(i > j){
					System.out.print(" ");
					continue;
				}
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println( "삼각형 반대--------------");

		
	}

}



