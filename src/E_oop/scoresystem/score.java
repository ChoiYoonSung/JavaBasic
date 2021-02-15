package E_oop.scoresystem;


public class score {

	public static void main(String[] args) {
		student[] students = new student[10];

		String[] name = new String[students.length];
		int[] kor = new int[students.length];
		int[] eng = new int[students.length];
		int[] math = new int[students.length];
		int[] stusum = new int[students.length];
		double[] stuavg = new double[students.length];

		//학생 이름, 과목 점수, 합계, 평균
		for (int i = 0; i < students.length; i++) {
			student st = new student();

			st.name(i);
			name[i] = st.name;
			st.kor();
			kor[i] = st.kor;
			st.eng();
			eng[i] = st.eng;
			st.math();
			math[i] = st.math;
			st.stusum();
			stusum[i] = st.stusum;
			st.stuavg();
			stuavg[i] = st.stuavg;

			students[i] = st; // 주소
		}
		
		// 과목별 합계 + 평균
		int korsum = 0;
		int engsum = 0;
		int mathsum = 0;

		for (int i = 0; i < students.length; i++) {
			korsum += students[i].kor;
			engsum += students[i].eng;
			mathsum += students[i].math;
		}

		double koravg = Math.round((double) korsum / students.length * 100) / 100.0;
		double engavg = Math.round((double) engsum / students.length * 100) / 100.0;
		double mathavg = Math.round((double) mathsum / students.length * 100) / 100.0;

		// 석차
		int[] rank = new int[students.length];
		for (int i = 0; i < students.length; i++) {
			rank[i] = 1;
			for (int j = 0; j < students.length; j++) {
				if (stusum[i] < stusum[j]) {
					rank[i]++;
				}
			}
		}

		// 정렬
		for (int i = 0; i < students.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < students.length; j++) {
				if (rank[j] < rank[min]) {
					min = j;
				}
			}
			student temp = students[i];
			students[i] = students[min];
			students[min] = temp;

			int temp2 = rank[i];
			rank[i] = rank[min];
			rank[min] = temp2;
		}

		// 출력
		System.out.println("\t국어\t영어\t수학\t합계\t평균\t석차");
		for (int i = 0; i < students.length; i++) {
			System.out.print(students[i].name + "\t");
			System.out.print(students[i].kor + "\t");
			System.out.print(students[i].eng + "\t");
			System.out.print(students[i].math + "\t");
			System.out.print(students[i].stusum + "\t");
			System.out.print(students[i].stuavg + "\t");
			System.out.println(rank[i]);
		}
		System.out.println("과목합계\t" + korsum + "\t" + engsum + "\t" + mathsum);
		System.out.println("과목평균\t" + koravg + "\t" + engavg + "\t" + mathavg);

	}

}
