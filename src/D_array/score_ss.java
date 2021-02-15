package D_array;


public class score_ss {

	public static void main(String[] args) {
		
		String[] name = {"김민지", "서주형", "최윤성", "변형균", "김두환",
				"현우진", "김현슬", "이광렬", "박예진", "강건우", "명민호", "박상영", "이휘로", "김현태",
				"최영준", "정영인", "정유진", "공슬기", "김이현", "전윤주", "전재수", "유은지"};
		String[] subject = {"국어", "영어", "수학", "사회", "과학", "Oracle", "Java"};
		int[][] score = new int[name.length][subject.length];
		
		for(int i = 0; i < score.length; i++){
			for(int j = 0; j < subject.length; j++){
				score[i][j] = (int)(Math.random()*101);
			}
		}
		
		int[] stu_sum = new int[score.length];
		double[] stu_avg = new double[score.length];
		for(int i = 0; i < score.length; i++){
			for(int j = 0; j < subject.length; j++){
				stu_sum[i] += score[i][j];
			}
			stu_avg[i] = Math.round((double)stu_sum[i]/subject.length*100)/100.0;
		}
		
		int[] sub_sum = new int[subject.length];
		double[] sub_avg = new double[subject.length];
		for(int i = 0; i < subject.length; i++){
			for(int j = 0; j < score.length; j++){
				sub_sum[i] += score[j][i];
			}
			sub_avg[i] = Math.round((double)sub_sum[i]/score.length*100)/100.0;
		}
		
		
		
	}

}
