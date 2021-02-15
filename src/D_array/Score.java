package D_array;


public class Score {

	public static void main(String[] args) {
		/*
		 * 반 모두의 국어, 영어, 수학, 사회, 과학, Oracle, Java 점수 0~100까지 랜덤 생성
		 */

		System.out.println("\t국어\t영어\t수학\t사회\t과학\tOracle\tJava\t합계\t평균\t석차");
		int x = 0;
		String[] name = { "김민지", "서주형", "최윤성", "변형균", "김두환",
				"현우진", "김현슬", "이광렬", "박예진", "강건우", "명민호", "박상영", "이휘로", "김현태",
				"최영준", "정영인", "정유진", "공슬기", "김이현", "전윤주", "전재수", "유은지" };
		String[] subject = new String[] { "국어", "영어", "수학", "사회", "과학",
				"Oracle", "Java" };
		int[][] scores = new int[name.length][subject.length];
		int[] stu_sum = new int[scores.length];
		double[] stu_avg = new double[scores.length];
		int[] rank = new int[scores.length];

		// 각 점수 표기 + 합계 + 평균
		for (int i = 0; i < scores.length; i++) {
			for (int j = 0; j < subject.length; j++) {
				scores[i][j] = (int) (Math.random() * 101);
				stu_sum[i] += scores[i][j];
			}
			stu_avg[i] = (double) (Math.round(stu_sum[i] * 10) / subject.length) / 10;
		}

		// 석차
		for (int i = 0; i < scores.length; i++) {
			rank[i] = 1;
			for (int j = 0; j < scores.length; j++) {
				if (stu_sum[i] < stu_sum[j]) {
					rank[i]++;
				}
			}
		}

		for (int i = 0; i < scores.length; i++) {
			System.out.print(i+1 + "." + name[i] + "\t");
			for (int j = 0; j < subject.length; j++) {
				System.out.print(scores[i][j] + "\t");
			}
			System.out.println(stu_sum[i] + "\t" + stu_avg[i] + "\t" + rank[i]);
		}

		// 과목 합계
		int[] cla_sum = new int[subject.length];
		double[] cla_avg = new double[subject.length];

		System.out.print("과목합계\t");
		for (int i = 0; i < subject.length; i++) {
			for (int j = 0; j < scores.length; j++) {
				cla_sum[i] += scores[j][i];
			}
			System.out.print(cla_sum[i] + "\t");
		}
		System.out.println();

		// 과목 평균
		System.out.print("과목평균\t");
		for (int i = 0; i < subject.length; i++) {
			cla_avg[i] = (double) (Math.round(cla_sum[i] * 10) / scores.length) / 10;
			System.out.print(cla_avg[i] + "\t");
		}

	}

}
