package J_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArrayListClass {
	public static void main(String[] args) {
		//List, Map, Set
		
		/*
		 *boolean add(Object obj) : 마지막 위치에 객체를 추가 후 성공여부를 반환한다
		 *void add(int index, Object obj) : 지정된 위치에 객체를 추가한다
		 *Object set(int index, Object obj) : 지정된 위치에 객체를 저장 후 기존 객체를 반환한다
		 *Object get(int index) : 지정된 위치의 객체를 반환한다
		 *int size() : 저장된 객체의 수를 반환한다
		 *boolean remove(int index) : 저장된 위치의 객체를 제거한다
		 */
		
		ArrayList sample = new ArrayList();
		sample.add("");
		sample.add(100);
		sample.add(new Scanner(System.in));
		
		//제네릭을 지정하지 않으면 넣을때는 편하나 꺼낼때는 타입을 예측하기 힘들다
		//따라서 제네릭의 사용이 권장된다
		//지정된 타입의 값만 입/출력이 가능하다
		ArrayList<Integer> list = new ArrayList<>();
		list.add(100);
		list.add(20);
		System.out.println(list.add(30));
		System.out.println(list);
		
		list.add(1,40);
		System.out.println(list);
		
		Integer before = list.set(2,50); //2번 인덱스에 값을 저장하고 기존 값을 반환
		System.out.println("before : " + before);
		System.out.println("after : " + list.get(2));
		System.out.println(list);
		
		Integer integer = list.get(2);
		System.out.println(integer);
		
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(i + " : " + list.get(i));
//			list.remove(i);
//		}
//		System.out.println(list);
		//for문을 이용해 값을 제거하기 위해서는 뒤에서부터 제거해야 한다.
		
		for (int i = list.size()-1; i >= 0; i--) {
			System.out.println(i + " : " + list.get(i));
			list.remove(i);
		}
		System.out.println(list);
		
		//list에 1 ~ 100 랜덤한 값 10개 저장
		for (int i = 0; i < 10; i++) {
			int random = (int)(Math.random()*100)+1;
			list.add(random);
		}
		System.out.println(list);
		
		//list에저장된 값을 합계와 평균을 구하시오
		int sum = 0;
		for(int i = 0; i < list.size(); i++){
			sum += list.get(i);
		}
		double avg = (double)(Math.round(sum*10)/list.size())/10;
		System.out.println(sum + " / " + avg);
		
		//list에서 최소값과 최대값을 구하시오
		int max = list.get(0);
		int min = list.get(0);
		
		for(int i = 0; i < list.size(); i ++){
			for(int j = 0; j < list.size(); j++){
				if(max < list.get(j)){
					max = list.get(j);
				}else if (min > list.get(j)){
					min = list.get(j);
				}
			}
		}
		System.out.println("max : " + max + " / min : " + min);
		
		//list를 오름차순으로 정렬
		for (int i = 0; i < list.size()-1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if(list.get(i) < list.get(j)){
					int temp = list.set(i,list.get(j));
					list.set(j,temp);
				}
			}
			
		}
		System.out.println(list);
		
		//ArrayList 기본 오름차순 정렬
		Collections.sort(list);
		System.out.println(list);
		
		//2차원 ArrayList
		//ArrayList 안에 ArrayList가 존재하는 형태. 2차원 배열 형태
		ArrayList<ArrayList<Integer>> list2 = new ArrayList<>();
		
		list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		list2.add(list);
		
		list = new ArrayList<>();
		list2.add(list);
		list.add(40);
		list.add(50);
		
		System.out.println(list2);
		
		for (int i = 0; i < list2.size(); i++) {
			ArrayList<Integer> li = list2.get(i);
			for (int j = 0; j < li.size(); j++) {
				System.out.print(li.get(j) + "\t");
			}
			System.out.println();
		}
		
		for (int i = 0; i < list2.size(); i++) {
			for (int j = 0; j < list2.get(i).size(); j++) {
				System.out.print(list2.get(i).get(j) + "\t");
			}
			System.out.println();
		}
		//대량의 데이터 사용시 ArrayList를 변수로 만들어 저장하여 사용하는 것이 시간이 빠르다.
		
	}
}






