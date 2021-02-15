package E_oop;

public class Static {
	/*
	 * - static을 붙이면 프로그램 실행시 메모리에 올라간다
	 * - 객체생성을 하지 않아도 사용할 수 있다
	 * - static을 붙인 변수는 객체간에 변수의 값을 공유한다
	 * - static이 붙은 멤버의 명칭 : 클래스 변수, 클래스 메서드
	 * - static이 붙지 않은 멤버의 명칭 : 인스턴스 변수, 인스턴스 메서드
	 * 
	 * 변수에 붙일 때 : 변수의 값을 공유하기 위해
	 * 메서드 : 객체생성을 하지 않고 사용하기 위해
	 */
	
	//변수의 값을 공유하기 위해 static을 붙임
	//전역변수에만 static을 붙일 수 있다.(지역변수x)
	static int var;
	
	
	public static void main(String[] args) {
		Human 철수 = new Human();
		Human 영희 = new Human();
		
		철수.saveMoney(1000000);
		영희.saveMoney(2000000);
		
		철수.saveDateMoney(200000);
		영희.saveDateMoney(200000);
		
		System.out.println();
		
		System.out.println(Math.random());
		
		System.out.println("문자열 입력");
		String str = ScanUtil.nextLine();
		System.out.println("입력한 문자 : " + str);
		
		System.out.println("숫자 입력");
		int x = ScanUtil.nextInt();
		System.out.println("숫자 입력 : " + x);
	}

}

class Human{
	int account; //계좌, 통
	
	void saveMoney(int money){
		account += money;
		System.out.println("통장잔고 : "+account);
	}
	
	static int dateaccount;
	
	void saveDateMoney(int money){
		dateaccount += money;
		System.out.println("데이트 통장 잔고 : " + dateaccount);
	}
}



