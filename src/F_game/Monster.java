package F_game;

public class Monster {
	String name;	//이름
	int maxHp;		//최대 체력
	int maxMp;		//최대 마력
	int hp;			//체력
	int mp;			//마나
	int att;		//공
	int def;		//방
	Item[] items;	//템

	Monster(String name, int hp, int mp, int att, int def, Item[] items){
		this.name = name;
		this.maxHp = hp;
		this.maxMp = hp;
		this.hp = this.maxHp;
		this.mp = this.maxMp;
		this.att = att;
		this.def = def;
		this.items = items;
	}
	
	void attack(Character c){
		int damage = att - c.def;
		damage = damage <= 0 ? 1 : damage;
		c.hp = c.hp < damage ? c.hp - c.hp : c.hp - damage;
		System.out.println(name + "가 공격으로 " + c.name + "에게" + damage + "의 데미지를 입혔습니다.");
		System.out.println(c.name + "의 남은 hp : " + c.hp);
	}
	
	Item itemdrop(){
		return items[(int)(Math.random()*items.length)];
	}
	
}


