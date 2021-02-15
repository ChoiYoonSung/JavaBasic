package G_oop2;

public class Tour {

	public static void main(String[] args) {
		Desktop dt1 = new Desktop("삼성 컴퓨터",1000000);
		Desktop dt2 = new Desktop("LG 컴퓨터",1000000);
		
		AirConditional ac1 = new AirConditional( "삼성 에어컨", 1200000);
		AirConditional ac2 = new AirConditional( "LG 에어컨", 1200000);
		
		TV tv1 = new TV( "삼성 티비", 1200000);
		TV tv2 = new TV( "LG 티비", 1200000);
		
		Customer c = new Customer();
		
		System.out.println(dt1.getInfo());
		System.out.println(dt2.getInfo());
		c.buy (dt1);
		
		
		System.out.println(ac1.getInfo());
		System.out.println(ac2.getInfo());
		c.buy((Product) ac2);
		
		System.out.println(tv1.getInfo());
		System.out.println(tv2.getInfo());
		c.buy((Product) tv2);
				
		
	}

}

class Product{
	String name;
	int price;
	
	Product(String name, int price){
		this.name = name;
		this.price = price;
	}
	
	//상품 정보 반환 메서드
	String getInfo(){
		return name + "(" + price + "원)";
		
	}
	
}

class Desktop extends Product{
	Desktop(String name, int price){
		super(name, price);
	}
	void programming(){
		System.out.println("Programming");
	}	
}

class AirConditional extends Product{
	AirConditional(String name, int price){
		super(name, price);
	}
	void setTemp(){
		System.out.println("Set Tempreture");
	}
}

class TV extends Product{
	TV(String name, int price){
		super(name, price);
	}
	void setChannel(){
		System.out.println("set Channel");
	}
}

class Customer{
	int money = 10000000;
	
	Product[] item = new Product[100];
	
	void buy(Product p){
		if(money < p.price){
			System.out.println("잔액 부족");
			return;
		}
		money -= p.price;
		
		for(int i = 0; i < item.length;i++){
			if(item[i] == null){
				item[i] = p;
				break;
			}
		}
		System.out.println(p.getInfo() + "를 구매");
	}
	
	void showItem(){
		System.out.println("장바구니");
		for(int i = 0; i < item.length; i ++){
			if(item == null)
				break;
			else
				System.out.println(item[i].getInfo());
		}
		System.out.println("==");
	}
}



