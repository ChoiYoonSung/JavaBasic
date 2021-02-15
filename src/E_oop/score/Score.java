package E_oop.score;


public class Score {

	public static void main(String[] args) {
		Student[] students = new Student[10];

		for (int i = 0; i < students.length; i++) {
			Student student = new Student(); //for문을 돌리면서 객체를 students의 길이(10)만큼 생성 / Student() : 메서드 / 생성자?

			student.name = "학생" + (i + 1);
			student.rank = 1;
			student.kor = (int) (Math.random() * 101);
			student.eng = (int) (Math.random() * 101);
			student.math = (int) (Math.random() * 101);

			students[i] = student;
		}

		String[] subject = { "국어", "영어", "수학" };

		int[] stu_sum = new int[students.length];
		double[] stu_avg = new double[students.length];

		for (int i = 0; i < students.length; i++) {
			for (int j = 0; j < subject.length; j++) {
				stu_sum[i] = students[i].kor + students[i].eng
						+ students[i].math;
			}
			stu_avg[i] = Math.round((double) stu_sum[i] / subject.length * 100) / 100.0;
		}

		for (int i = 0; i < students.length; i++) {
			for (int j = 0; j < students.length; j++) {
				if (stu_sum[i] < stu_sum[j]) {
					students[i].rank++;
				}
			}
		}

		// 정렬
		for (int i = 0; i < stu_sum.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < stu_sum.length; j++) {
				if (stu_sum[j] > stu_sum[min]) {
					min = j;
				}
			}
			Student temp = students[i];
			students[i] = students[min];
			students[min] = temp;

			int temp2 = stu_sum[i];
			stu_sum[i] = stu_sum[min];
			stu_sum[min] = temp2;

			double temp3 = stu_avg[i];
			stu_avg[i] = stu_avg[min];
			stu_avg[min] = temp3;

		}

		int sub_sum_kor = 0;
		int sub_sum_eng = 0;
		int sub_sum_math = 0;

		for (int i = 0; i < students.length; i++) {
			sub_sum_kor += students[i].kor;
			sub_sum_eng += students[i].eng;
			sub_sum_math += students[i].math;
		}
		double sub_avg_kor = Math.round((double) sub_sum_kor / students.length
				* 100) / 100.0;
		double sub_avg_eng = Math.round((double) sub_sum_eng / students.length
				* 100) / 100.0;
		double sub_avg_math = Math.round((double) sub_sum_math
				/ students.length * 100) / 100.0;

		for (int i = 0; i < subject.length; i++) {
			System.out.print("\t" + subject[i]);
		}
		System.out.println("\t합계\t평균\t석차");

		for (int i = 0; i < students.length; i++) {
			System.out.print(students[i].name + "\t");
			System.out.print(students[i].kor + "\t" + students[i].eng + "\t"
					+ students[i].math + "\t");
			System.out.println(stu_sum[i] + "\t" + stu_avg[i] + "\t"
					+ students[i].rank);
		}

		System.out.println("과목합계\t" + sub_sum_kor + "\t" + sub_sum_eng + "\t"
				+ sub_sum_math + "\t");
		System.out.println("과목평균\t" + sub_avg_kor + "\t" + sub_avg_eng + "\t"
				+ sub_avg_math + "\t");

	}
}
