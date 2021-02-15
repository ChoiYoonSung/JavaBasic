package C_statement;


public class ConditionalStatement {

	public static void main(String[] args) {
		/*
		 * 조건문
		 * - if - else
		 * - switch
		 * 
		 * if문
		 * - if{} : 조건식의 결과가 true면 블럭 안의 문장을 수행
		 * - else if{} : 다수의 조건이 필요할 때 if 뒤에 추가
		 * - else{} : 결과가 true인 조건식이 하나도 없는 경우 추가
		 */
		
		int a = 1;
		if(a == 1){
			System.out.println("조건식의 연산결과가 true면 수행");
		}
		
		if(a==0){
			System.out.println("a==0");
		}
		else if (a==1){
			System.out.println("a==1");
		}
		else{
			System.out.println("그 이외");
		}
		
		//조건을 한묶음으로 사용하기 위해서는 반드리 else if를 사용해야 한다.
		if(a < 10){
			System.out.println("a < 10");
		}
		else if (a < 20){
			System.out.println("a < 20");
		}

		//--------------------------------------	
		//시험점수가 60점 이상이면 합격 그렇지 않으면 불합격
		int score = 70;
		
		if(score >= 60){
			System.out.println("합");
		}
		else{
			System.out.println("불합");
		}
		//--------------------------------------
		//성적에 등급을 부여하는 프로그램
		score = 67;
		String grade = null;
		
		if(90 <= score && score <= 100){
			grade = "A";
		} else if(80 <= score){
			grade = "B";
		} else if(70 <= score){
			grade = "C";
		} else if(60 <= score){
			grade = "D";
		} else if(0 <= score){
			grade = "F";
		} else {
			System.out.println("잘못된 성적");
		}
		
		System.out.println("등급 : " + grade);
		
		//--------------------------------------
		//성적 -> 등급 환산 프로그램
		
		score = 96;
		grade = null;
		
		if(90 <= score && score <= 100){
			grade = "A";
			if (97 <= score){					//97점 이상
				grade += "+";
			} else if (93 >= score){			//93점 이하
				grade += "-";
			} else grade += "0";
		} else if(80 <= score){
			grade = "B";
			if (87 <= score){					//87점 이상
				grade += "+";
			} else if (83 >= score){			//83점 이하
				grade += "-";
			} else grade += "0";
		}  else if(70 <= score){
			grade = "C";
			if (77 <= score){					//77점 이상
				grade = "+";
			} else if (73 >= score){			//73점 이하
				grade = "-";
			} else grade += "0";
		}  else if(60 <= score){
			grade = "0";
			if (67 <= score){					//67점 이상
				grade = "+";
			} else if (63 >= score){			//63점 이하
				grade = "-";
			}else grade += "0";
		} else if (0 <= score){					//나머지
			grade = "F";
		} else System.out.println("잘못된 점수");	//점수계산 실수
		
		System.out.println("등급 : " + grade);
		
		//--------------------------------------
		/*
		 * Switch문
		 * - switch(int){case 1: break;}
		 * - switch(string){case "a": break;}
		 * - 조건식의 결과는 정수와 문자열만(JDK 1.7부터 문자열 허용) 허용한다
		 * - 조건식과 일치하는 case문 이후의 문장을 수행한다.
		 */
		
		a = 1;
		switch(a){
		case 1:
			System.out.println("a = 1");
			break;
		case 2:
			System.out.println("a = 2");
			break;
		default:
			System.out.println("이외의 것");
		}
		
		String b = "b";
		switch(b){
		case "a":
			System.out.println(b + " = a");
			break;
		case "b":
			System.out.println(b + " = \"b\"");
			break;
		default:
			System.out.println("이외의 것");
		}
		
		//--------------------------------------
		//주어진 월에 해당하는 계절을 출력
		int month = 1;
		String season = null;
		
		switch(month){
		case 3:
		case 4:
		case 5:
			season = "Spring";
			break;
		case 6:
		case 7:
		case 8:
			season = "Summer";
			break;
		case 9:
		case 10:
		case 11:
			season = "Fall";
			break;
		case 12:
		case 1:
		case 2:
			season = "Winter";
			break;
		default:
			System.out.println("잘못된 입력");
		}
		
		System.out.println(month + "월의 계절은 \"" + season + "\"입니다.");
		
		//--------------------------------------
		//switch문 활용 성적 등급 환산 프로그램
		score = 100;
		grade = null;
		
		switch(score/10){
		case 10:
		case 9:
			grade = "A";
			if (score >= 97){
				grade += "+";
			}else if(score <= 90) {
				grade += "-";
			}else grade += "0";
			break;
		case 8:
			grade = "B";
			if (score >= 87){
				grade += "+";
			}else if(score <= 80) {
				grade += "-";
			}else grade += "0";
			break;
		case 7:
			grade = "C";
			if (score >= 77){
				grade += "+";
			}else if(score <= 70) {
				grade += "-";
			}else grade += "0";
			break;
		case 6:
			grade = "D";
			if (score >= 67){
				grade += "+";
			}else if(score <= 60) {
				grade += "-";
			}else grade += "0";
			break;
		case 0:
			grade = "F";
			break;
		default:
			System.out.println("F");
		}

		System.out.println("점수 : " + score + "\r학점 : \"" + grade + "\"");

		//--------------------------------------
		//Q. 숫자를 입력받아 그 숫자가 0인지 0이 아닌지 출력하시오.
		//Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요.>");
		//int x = Integer.parseInt(sc.nextLine());
		int x = 0;
		
		if(x == 0){
			System.out.println("입력받은 숫자는 " + x + "입니다.");
		} else System.out.println("입력받은 숫자는 0이 아닌 " + x + "입니다.");
		
		//--------------------------------------
		//Q. 숫자를 입력받아 그 숫자가 홀수인지 짝수인지 출력

		if (x%2 == 1){
			System.out.println(x + "는 홀수입니다.");
		}else if (x%2 == 0){
			System.out.println(x + "는 짝수입니다.");
		}else System.out.println(x + "는 마이너스값 혹은 소수점이 붙어있습니다.");
		
		switch(x %= 2){
		case 0:
			System.out.println(x + "는 짝수입니다.");
			break;
		case 1:
			System.out.println(x + "는 홀수입니다.");
			break;
		default:
			System.out.println(x + "는 마이너스값 혹은 소수점이 붙어있습니다.");
		}
		
		//--------------------------------------
		//정수 3개 입력받아 총점, 평균, 등급을 출력
		
		/*System.out.println("첫 번재 점수를 입력하십시오.");
		int a1 = Integer.parseInt(sc.nextLine());
		System.out.println("두 번재 점수를 입력하십시오.");
		int a2 = Integer.parseInt(sc.nextLine());
		System.out.println("세 번재 점수를 입력하십시오.");
		int a3 = Integer.parseInt(sc.nextLine());
		
		int total = a1 + a2 + a3;
		double avg = Math.round((a1 + a2 + a3) / 3.0 *10)/10.0;
		grade = null;
		
		if(90 <= avg && avg <= 100){
			grade = "A";
			if (97 <= avg){						//97점 이상
				grade += "+";
			} else if (93 >= avg){				//93점 이하
				grade += "-";
			} else grade += "0";
		} else if(80 <= avg){
			grade = "B";
			if (87 <= avg){						//87점 이상
				grade += "+";
			} else if (83 >= avg){				//83점 이하
				grade += "-";
			} else grade += "0";
		}  else if(70 <= avg){
			grade = "C";
			if (77 <= avg){						//77점 이상
				grade = "+";
			} else if (73 >= avg){				//73점 이하
				grade = "-";
			} else grade += "0";
		}  else if(60 <= avg){
			grade = "0";
			if (67 <= avg){						//67점 이상
				grade = "+";
			} else if (63 >= avg){				//63점 이하
				grade = "-";
			}else grade += "0";
		} else if (0 <= avg){					//나머지
			grade = "F";
		} else System.out.println("잘못된 점수");	
		
		System.out.println("당신의 총점은 " + total + "입니다.");
		System.out.println("당신의 평균은 " + avg + "입니다.");
		System.out.println("당신의 등급은 " + grade + "입니다.");
		*/
		
		//--------------------------------------
		//랜덤발생
		//Math.random() : 0.00 ~ 0.99 랜덤수 발생
		int random = (int) (Math.random() * 100) + 1;
		System.out.println(random);

		// 1 ~ 100 사이의 랜덤한 수를 3개 발생, 오름차순으로 출력
		int rand1 = (int) (Math.random() * 100) + 1;
		int rand2 = (int) (Math.random() * 100) + 1;
		int rand3 = (int) (Math.random() * 100) + 1;

		if (rand1 < rand2) {
			if (rand2 < rand3) {	// 1 2 3
				System.out.println(rand1 + " " + rand2 + " " + rand3);
			} else if (rand3 < rand2) {	// 1 3 2
				if (rand1 < rand3)
					System.out.println(rand1 + " " + rand3 + " " + rand2);
				else	// 3 1 2
					System.out.println(rand3 + " " + rand1 + " " + rand2);
			}
		} else if (rand1 > rand2) {
			if (rand3 > rand1) { // 2 1 3
				System.out.println(rand2 + " " + rand1 + " " + rand3);
			} else if (rand3 < rand1) { // 2 3 1
				if (rand2 < rand3)
					System.out.println(rand2 + " " + rand3 + " " + rand1);
				else	//3 2 1
					System.out.println(rand3 + " " + rand2 + " " + rand1);
			} else //1 = 2 = 3
				System.out.println(rand1 + " " + rand2 + " " + rand3);
		}
		
		if (rand1 > rand2){
			int temp = rand1;
			rand1 = rand2;
			rand2 = temp;
		}
		if (rand1 > rand3){
			int temp = rand1;
			rand1 = rand3;
			rand3 = temp;
		}
		if (rand2 > rand3){
			int temp = rand2;
			rand2 = rand3;
			rand3 = temp;
		}
		
		System.out.println(rand1 + "<" + rand2 + "<" + rand3);

	}
}





