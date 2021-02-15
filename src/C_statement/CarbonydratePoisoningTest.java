package C_statement;

import java.util.Scanner;

public class CarbonydratePoisoningTest {

	public static void main(String[] args) {
		//탄수화물 중독 자가진단 테스트
		Scanner sc = new Scanner(System.in);
		
		int count = 0;
		
		System.out.println("탄수화물 중독 자가진단 테스트를 시작합니다.");
		System.out.println("질문에 해당되는 경우 1을, 해당되지 않는 경우 2를 입력해 주세요. (1/2)\r");
		System.out.println("아침을 배불리 먹은 후 점심시간 전에 배가 고프다.");
		int ans1 = Integer.parseInt(sc.nextLine());
		if (ans1 == 1) count += 1;
		System.out.println("밥, 빵, 과자 등 음식을 먹기 시작하면 끝이 없다.");
		int  ans2 = Integer.parseInt(sc.nextLine());
		if (ans2 == 1) count += 1;
		System.out.println("음식을 금방 먹은 후에도 만족스럽지 못하고 더 먹는다.");
		int ans3 = Integer.parseInt(sc.nextLine());
		if (ans3 == 1) count += 1;
		System.out.println("정말 배고프지 않더라도 먹을 때가 있다.");
		int ans4 = Integer.parseInt(sc.nextLine());
		if (ans4 == 1) count += 1;
		System.out.println("저녁을 먹고 간식을 먹지 않으면 잠이 오지 않는다.");
		int ans5 = Integer.parseInt(sc.nextLine());
		if (ans5 == 1) count += 1;
		System.out.println("스트레스를 받으면 자꾸 먹고 싶어진.다");
		int ans6 = Integer.parseInt(sc.nextLine());
		if (ans6 == 1) count += 1;
		System.out.println("책상이나 식탁 위에[ 항상 과자,초콜릿 등이 놓여있다.");
		int ans7 = Integer.parseInt(sc.nextLine());
		if (ans7 == 1) count += 1;
		System.out.println("오후 5시가 되면 피곤함과 배고픔을 느끼고 일이 손에 안 잡힌다.");
		int ans8 = Integer.parseInt(sc.nextLine());
		if (ans8 == 1) count += 1;
		System.out.println("과자, 초콜릿 등 단 음식은 상상만 해도 먹고 싶어진다.");
		int ans9 = Integer.parseInt(sc.nextLine());
		if (ans9 == 1) count += 1;
		System.out.println("다이어트를 위해 식이조절을 하는데 3일도 못 간다.");
		int ans10 = Integer.parseInt(sc.nextLine());
		if (ans10 == 1) count += 1;

		switch(count){
		case 0:
		case 1:
		case 2:
			System.out.println("현재 " + count + "개 해당됩니다.");
			System.out.println("안전!");
			break;
		case 3:
			System.out.println("현재 " + count + "개 해당됩니다.");
			System.out.println("주의! 위험한 수준은 아니지만 관리 필요");
			break;
		case 4:
		case 5:
		case 6:
			System.out.println("현재 " + count + "개 해당됩니다.");
			System.out.println("위험! 탄수화물 섭취 줄이기 위한 식습관 개선이 필요함");
			break;
		default:
			System.out.println("현재 " + count + "개 해당됩니다.");
			System.out.println("중독! 전문의 상담이 필요함");
			break;
		}

	}

}
