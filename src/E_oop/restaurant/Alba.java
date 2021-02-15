package E_oop.restaurant;

public class Alba {
	//매서드 : 알바가 할 일(보스가 알바에게 시킨 일)
	//파라미터 : 일을 하기 위해 필요한 것(보스가 알바에게 부는 것)
	//리턴타입 : 일을 하고 난 후 돌려주는 것(알바가 보스에게 주는 것)
	
	//주문받기 위해 필요한 것?(파라미터) x
	//주문받은 후 보스에게 줄 것?(주문서) 주문서
	String[] order(){
		System.out.println("주문하시겠습니까?");
		return new String[]{"수비드 안심 스테이크", "쉬림프 로제 파스타","바질페스토를 곁들인 파스타"};
	}
	
	//서빙을 하기 위해 필요한 것?음식
	//서빙 후 보스에게 줄 것? x
	void serve(String[] food){
		System.out.println("맛있게 드세요.");
	}
	
	//계산? 계산서
	//계산 후 보스에게 줄 것? x
	void pay(String[] bill){
		System.out.println("12만원 입니다. 감사합니다.");
	}
	
	
	
	
}






