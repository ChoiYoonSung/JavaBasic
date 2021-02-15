package G_oop2;

public abstract class Animal {
	void run(){
		System.out.println("달려간다");
	}
	
	abstract void sound();
}

class Dog extends Animal{
	//상속받은 클래스가 추상메서드를 포함하고 있어서 상속받을 클래스의 추상메서드에 내용을 추가해줌
	@Override
	void sound() {
		System.out.println("멍멍");
	}
}

class Cat extends Animal{

	@Override
	void sound() {
		System.out.println("야옹");
	}
}
