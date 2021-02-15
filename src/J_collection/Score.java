package J_collection;

import java.util.ArrayList;

public class Score {
	public static void main(String[] args) {
		//국 영 수 사 과 oracle java 합계 평균 석차
		ArrayList<String> name = new ArrayList<>();
		ArrayList<String> subject = new ArrayList<>();
		ArrayList<ArrayList<Integer>> score = new ArrayList<>();
		
		//이름
		String[] name1 = { "김민지", "서주형", "최윤성", "변형균", "김두환",
				"현우진", "김현슬", "이광렬", "박예진", "강건우", "명민호", "박상영", "이휘로", "김현태",
				"최영준", "정영인", "정유진", "공슬기", "김이현", "전윤주", "전재수", "유은지" };
		for(int i = 0; i < name1.length; i++){
			name.add(name1[i]);
		}
		//과목
		String[] subject1 = new String[] { "국어", "영어", "수학", "사회", "과학",
				"Oracle", "Java" };
		for (int i = 0; i < subject1.length; i++) {
			subject.add(subject1[i]);
		}
		//점수 삽입
		for (int i = 0; i < name.size(); i++) {
			ArrayList<Integer> list = new ArrayList<>();
			score.add(list);
			for (int j = 0; j < subject.size(); j++) {
				list.add((int) (Math.random()*101));
			}
		}
		
		//합계, 평균, 석차
		//학생
		ArrayList<Integer> stusum = new ArrayList<>();
		ArrayList<Double> stuavg = new ArrayList<>();
		for (int i = 0; i < score.size(); i++) {
			int sum = 0;
			for (int j = 0; j < subject.size(); j++) {
				sum += 	score.get(i).get(j);
			}
			double avg = (double)(Math.round(sum* 100) / subject.size()) / 100;
			stusum.add(sum);
			stuavg.add(avg);
		}
		//과목
		ArrayList<Integer> subsum = new ArrayList<>();
		ArrayList<Double> subavg = new ArrayList<>();
		for (int i = 0; i < subject.size(); i++) {
			int sum = 0;
			for (int j = 0; j < score.size(); j++) {
				sum += score.get(j).get(i);
			}
			double avg = (double)(Math.round(sum* 100) / score.size()) / 100;
			subsum.add(sum);
			subavg.add(avg);
		}
		
		ArrayList<Integer> rank = new ArrayList<>();
		for (int i = 0; i < score.size(); i++) {
			rank.add(1);
			for (int j = 0; j < score.size(); j++) {
				if(stusum.get(i) < stusum.get(j)){
					rank.set(i, rank.get(i) + 1);
				}
			}
		}
		
		//석차 정렬
		for(int i = 0; i < rank.size() - 1; i++){
			int min = i;
			for(int j = i + 1; j < rank.size(); j++){
				if(rank.get(j) < rank.get(min)){
					min = j;
				}
			}
			String temp = name.set(min, name.get(i));
			name.set(i, temp);
			
			ArrayList<Integer> temp1 = score.set(min, score.get(i));
			score.set(i, temp1);
			
			int temp2 = stusum.set(min, stusum.get(i));
			stusum.set(i, temp2);
			
			double temp3 = stuavg.set(min, stuavg.get(i));
			stuavg.set(i, temp3);
			
			int temp4 = rank.set(min, rank.get(i));
			rank.set(i, temp4);
		}
		
		//출력
		for (int i = 0; i < subject.size(); i++) {
			System.out.print("\t" + subject.get(i));	
		}
		System.out.println("\t합계\t평균\t석차");
		
		for (int i = 0; i < score.size(); i++) {
			System.out.print(name.get(i));
			for (int j = 0; j < score.get(i).size(); j++) {
				System.out.print("\t" + score.get(i).get(j));
			}
			System.out.print("\t" + stusum.get(i) + "\t" + stuavg.get(i) + "\t" + rank.get(i));
			System.out.println();
		}
		
		System.out.print("과목합계");
		for (int i = 0; i < subject.size(); i++) {
			System.out.print("\t" + subsum.get(i));
		}
		System.out.println();
		System.out.print("과목평균");
		for (int i = 0; i < subject.size(); i++) {
			System.out.print("\t" + subavg.get(i));
		}
	}
}



