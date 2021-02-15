package I_api;

import E_oop.ScanUtil;

public class SetComma_beta {
	public static void main(String[] args) {
		System.out.println("숫자입력");
		String number = ScanUtil.nextLine();
		String number2 = "";
		
		int count = 0;
		for (int i = number.length(); i >= 0; i--) {
			number2 = number.charAt(i) + number2;
			count++;
			if(count % 3 == 0 && count != number.length())
				number2 = "," + number2;
		}
	}
}
