package E_oop.restaurant;

import java.util.Arrays;

public class Boss {

	public static void main(String[] args) {
		//알바 고용 alba(알바, 23세)
		Alba alba = new Alba();
		
		String[] order = alba.order();
		System.out.println(Arrays.toString(order));
		
		System.out.println("요리중...완성");
		String[] food = {"완성된 수비드 안심 스테이크","완성된 쉬림프 로제 파스타","완성된 바질페스토를 곁들인 파스타"};
		System.out.println(Arrays.toString(food));
		
		alba.serve(food);
		
		alba.pay(order);
	}

}
