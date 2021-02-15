package F_game;

import E_oop.ScanUtil;

public class MyGame {

	Character c;
	Item[] items;

	MyGame(){
		c = new Character("솔도로스", 100, 80, 20, 10);
		
		items = new Item[10];
		items[0] = new Item("[데우스 이미저리]",0,0,10,0);
		items[1] = new Item("[대자연의 숨결]",0,0,0,5);
		items[2] = new Item("[개악 지옥의 길]",-5,0,3,3);
		items[3] = new Item("[별의 바다 : 바드나후]",0,0,7,0);
	}

	public static void main(String[] args) {
		new MyGame().start();
	}

	void start() {
		int input = 0;
		while (true) {
			System.out.println("1.내정보\t2.사냥\t3.종료");
			input = ScanUtil.nextInt();

			switch (input) {
			case 1:
				c.showinfo();
				break;

			case 2:
				hunt();
				break;

			case 3:
				System.out.println("종료");
				System.exit(0);
			}
		}
	}

	void hunt() {
		Monster m = new Monster("무형의 시로코", 60, 10, 15, 10, new Item[]{items[0],items[1],items[2],items[3]});
		System.out.println(m.name + "와 마주하였습니다. 전투를 시작합니다.");
		
		int input = 0;
		int input2 = 0;
		battle: while(true){
			System.out.println("1.공격\t2.후퇴");
			input = ScanUtil.nextInt();
			switch(input){
			case 1:
				System.out.println("[1.평타]\t[2.무형참]");
				input2 = ScanUtil.nextInt();
				switch(input2){
				case 1:
					c.attack(m);										//평타
					break;
				case 2:
					c.skill(m, c);										//스킬
					break;
				}
				if(m.hp <= 0){
					System.out.println(m.name + "을 처치하였습니다.");
					c.getExp(80);
					int x = (int)(Math.random()*9)+1;
					if(x >= 3){ 										//드랍률
						c.getItem(m.itemdrop());	
					}
					break battle;
				}
				m.attack(c);
				break;
			case 2:
				break battle;
			}
		}
	}
	
	//추가사항
	//상점
	//강화
	//몬스터 - 공격 - 패턴?

}
