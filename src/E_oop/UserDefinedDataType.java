package E_oop;

// import : 다른 패키지에 있는 클래스를 사용하기 위해 그 위치를 알려주는 것 

public class UserDefinedDataType {

	public static void main(String[] args) {
		/*
		 * 사용자 정의 데이터 타입
		 * - 데이터의 최종 진화 형태 (기본형->배열->클래스)
		 * - 서로 다른 타입의 데이터를 묶어서 사용하는 것
		 * - 변수와 메서드로 구성할 수 있음 
		 */
		
		//기본형
		int kor, eng, math, sum;
		double avg;
		String name;
		
		//배열
		int[] score;
		int sum2;
		double avg2;
		String name2;
		
		//클래스
		Student student;
		student = new Student(); //객체 생성(인스턴스화) / 객체 : 클래스의 내용이 메모리에 올라간 것
		
		student.kor = 80;
		student.eng = 90;
		student.math = 95;
		student.sum = student.kor + student.eng + student.math;
		student.avg = student.sum / 3.0; //double형
		student.name = "A";
		
		System.out.println(student.name + "의 성적 ");
		System.out.println(student.avg);
		
		Student student2 = new Student();
		
		
		
		
		
	}

}

class Student {
	int kor, eng, math, sum;
	double avg;
	String name;
}



