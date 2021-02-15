package E_oop.scoresystem;

public class student {
	
	int kor, eng, math, stusum;
	double stuavg;
	String name;
	
	String name(int namenum){
		return name = namenum+1 + "번 학생";
	}
	
	int kor(){
		return kor = (int)(Math.random()*101);
	}
	
	int eng(){
		return eng = (int)(Math.random()*101);
	}
	
	int math(){
		return math = (int)(Math.random()*101);
	}
	
	int stusum( ){
		return stusum = kor + eng + math ;
	}
	
	double stuavg( ){
		return stuavg = Math.round((double)stusum/3*100)/100.0;
	}
}
