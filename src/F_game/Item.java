package F_game;

public class Item {
	String name; //이름
	int hp; //체력
	int mp; //마나
	int att; //공
	int def; //방
	
	
	Item(String name, int hp, int mp, int att, int def){
		this.name = name;
		this.hp = hp;
		this.mp = hp;
		this.att = att;
		this.def = def;
	}
	
	String itemInfo(){
		String info = name + " :";
		if(0 < hp) info += " 체력 +" + hp;
		if(0 < mp) info += " 마나 +" + mp;
		if(0 < att) info += " 공격력 +" + att;
		if(0 < def) info += " 방어력 +" + def;
		return info;
	}
}




