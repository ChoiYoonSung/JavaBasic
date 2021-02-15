package D_array;

import java.util.Arrays;

public class Array {

	public static void main(String[] args) {
		/*
		 * 배열
		 * - 여러개의 값을 하나의 변수에 저장해서 사용하는 것
		 * - 데이터의 묶음
		 * - 참조형 타입
		 * - 인덱스로 값을 구분
		 * - 길이를 변경할 수 없음
		 */
		
		int[] array; //배열의 주소를 저장할 공간이 만들어짐
		array = new int[5]; //배열이 생성되고 그 주소가 저장됨
		//배열 초기화시 기본값이 저장됨
		/*
		 * 기본값 : default값 / 저장하지 않았을 때 저장되어 있는 값
		 * 대부분의 기본갑은 0으로 설정되어 있다
		 * byte, short, int, long : 0
		 * float, double = 0.0
		 * char : ' '(0)
		 * boolean : false
		 * 참조형 : null
		 */
		
		/*
		 * 변수 = 주소
		 * 주소{0,0,0,0,0}
		 */
		
		array = new int[]{1,2,3,4,5};
		
		// array = {1,2,3,4,5}; 
		int[] array2 = {1,2,3,4,5}; //선언과 초기화를 동시에
		
		System.out.println(array[0]); //출력에서의 숫자를 인덱스라 부름
		System.out.println(array[1]); //배열의 n번째 숫자를 출력하기 위해선 인덱스를 n-1로 사용
		System.out.println(array[2]);
		System.out.println(array[3]);
		System.out.println(array[4]);
		
		System.out.println("-------------------");

		
		array[0] = 10;
		array[1] = 20;
		array[2] = 30;
		array[3] = 40;
		array[4] = 50;
		
		System.out.println(array[0]);
		System.out.println(array[1]);
		System.out.println(array[2]);
		System.out.println(array[3]);
		System.out.println(array[4]);
		
		for(int i = 0; i < array.length; i++){ //array.length = 배열의 길이
			System.out.println(array[i]);
		}

		System.out.println("-------------------");
		
		for(int i = 0; i < array.length; i++){
			array[i] = (i+1)*10;
		
			System.out.println(array[i]);
		}
		
		System.out.println("-------------------");
		
		//10개의 정수를 저장할 수 있는 배열을 선언 및 초기화
		
		int[] arr1 = new int[10];
		
		for(int i = 0; i < arr1.length; i++){
			arr1[i] = (int)(Math.random()*100)+1;
		}

		System.out.println(Arrays.toString(arr1)); //Arrays.tostring(배열) : 배열에 저장되어 있는 값을 나열하여 나타낼 수 있음
		
		//배열에 저장된 모든 값의 합계와 평균을 구하시오
		int sum = 0;
		
		for(int i = 0; i < arr1.length; i++){
			 sum += arr1[i];
		}
		double avg = (double)sum/arr1.length;
		System.out.println("합계 : " + sum + "\t/ 평균 : " + avg);
				
		//배열에 저장된 값들 중 최솟값과 최대값을 출력해주세요.
		int min = arr1[0];
		int max = arr1[0];
		
		for(int i = 0; i < arr1.length; i++){
			if(min > arr1[i]){
				min = arr1[i];
			}
			if(max < arr1[i]){
				max = arr1[i];
			}
		}
		System.out.println("최소값 : " + min + " \t/ 최대값 : " + max);
		
		System.out.println("-------------------");

		//
		int [] shuffle = new int[10];
		for(int i = 0; i < shuffle.length; i++){
			shuffle[i] = i + 1;
		}
		System.out.println(Arrays.toString(shuffle));
		
		for(int i = 0; i < shuffle.length; i++){
			int randomx = (int)(Math.random()*shuffle.length); //0 ~ 9 랜덤값 생성
			int temp = shuffle[randomx];
			shuffle[randomx] = shuffle[i];
			shuffle[i] = temp;
		}
		System.out.println(Arrays.toString(shuffle));
		
		System.out.println("-------------------");

		//1-10 사이의 랜덤값을 500번 생성, 각 숫자가 생성된 횟수를 출력
		int[] arr2 = new int[500];
		int[] num = new int [10];
		
		for(int i = 0; i < arr2.length; i++){
			int random = (int)(Math.random()*10)+1;
			arr2[i] = random;
			num[arr2[i]-1]++;
		}
		System.out.println("[1 / 2 / 3 / 4 / 5 / 6 / 7 / 8 / 9 / 10]");
		System.out.println(Arrays.toString(num));
		
		
	}

}








