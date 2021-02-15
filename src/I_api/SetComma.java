package I_api;

import E_oop.ScanUtil;

public class SetComma {

	public static void main(String[] args) {
		// 숫자를 입력받아 입력받은 숫자에 3자리 마다 콤마(,)를 붙여 출력
		System.out.println("숫자 입력");
		int x = ScanUtil.nextInt();
		System.out.println("단위 입력");
		String y = ScanUtil.nextLine();
		
		String str = String.valueOf(x);
		String sub1 = "";
		String sub2 = "";

		for (int i = str.length() - 1; i >= 0; i--) {
			sub1 += str.charAt(i);
		}

		for (int i = sub1.length() - 1; i >= 0; i--) {
			sub2 += sub1.charAt(i);
			if (i % 3 == 0 && i != 0) {
				sub2 += ",";
			}
		}
		System.out.println(sub2 + y);

	}
}
