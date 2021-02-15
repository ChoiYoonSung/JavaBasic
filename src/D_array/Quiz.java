package D_array;

import java.util.Arrays;

public class Quiz {

	public static void main(String[] args) {
		/*
		 * 1번 문제
		 * 거스름돈 동전 개수
		 * 
		 * 출력
		 * 거스름돈 : -원
		 * 500원 : -개
		 * 100원 : -개
		 * 50원 : -개
		 * 10원 : -개
		 */
	/*	int money = (int)(Math.random()*500)*10;
		int[] coin = {500, 100, 50, 10};
		
		System.out.println("거스름돈 : " + money);
		int _500 = 0;
		int _100 = 0;
		int _50 = 0;
		int _10 = 0;
		int rest = 0;

		if (money >= 500) {
			_500 = money / coin[0];
			rest = money % coin[0];
		}
		if (money >= 100) {
			_100 = rest / coin[1];
			rest = rest % coin[1];
		}
		if (money >= 50) {
			_50 = rest / coin[2];
			rest = rest % coin[2];
		}
		if (money >= 10) {
			_10 = rest / coin[3];
		}
		System.out.println("500원 : " + _500 + "개\t100원 : " + _100 + "개\t50원 : "
				+ _50 + "개\t10원 : " + _10 + "개");
		System.out.println("------------------------------");
		
		for(int i =0; i<coin.length; i++){
			int count = money / coin[i];
			money = money % coin[i];
			System.out.println(coin[i] + "원 : " + count +"개");
		}
		System.out.println("------------------------------");*/
		
		
		/*
		 *2번 문제
		 * 1 ~ 5의 숫자가 발생한 만큼 *을 사용해 그래프를 그리시오
		 */
	/*	
		int[] arr = new int[20];
		for(int i = 0; i < arr.length; i++){
			arr[i] = (int)(Math.random()*5)+1;
		}
		System.out.println(Arrays.toString(arr));
		
		for(int i = 1; i<6; i++){
			System.out.print(i + " : ");
			int count = 0;
			
			for(int j = 0; j < arr.length; j++){
				if(arr[j] == i){
					count++;
					System.out.print("*");
				}
			}
			System.out.println(" " + count);
		}
*/
/*		System.out.println("------------------------------");
		int[] arr = new int[20];
		for(int i = 0; i < arr.length; i++){
			arr[i] = (int)(Math.random()*5)+1;
		}
		System.out.println(Arrays.toString(arr));
		
		int[] count = new int[5];
		for(int i = 0; i < arr.length; i++){
			count[arr[i] -1 ]++;
		}
		
		for(int i = 0; i < count.length; i++){
			System.out.print(i+1 + " : ");
			for(int j = 0; j < count[i]; j++){
				System.out.print("*");
			}
			System.out.println(" " + count[i]);
		}

		System.out.println("------------------------------");*/
		
		/*
		 * 1 ~ 5 사이의 랜덤한 값이 10개 저장딘 배열에서 중복된 값이 제거된 배열을 생성
		 */
		//복습 최소 한번 더 볼 것
		
/*		int[] arr = new int[10];
		for(int i = 0; i < arr.length; i++){
			arr[i] = (int)(Math.random()*5)+1;
		}
		System.out.println(Arrays.toString(arr));
		//10개의 배열에 1~5를 랜덤으로 위치

		int[] temp = new int[5]; //정답배열이 아닌 임시배열
		int count = 0;
		for(int i = 0; i<arr.length ; i++){
			boolean flag = false; //기본 boolean의 값을 false로 설정
			for(int j = 0; j < temp.length; j++){ //temp의 값만큼 반복하여 중복된 값이 있는지 확인
				if(arr[i] == temp[j]){
					flag = true; // 같을시 boolean에서 true가 됨
				}
			}
			if(!flag){
				temp[count++] = arr[i]; //boolean의 기본값이 될시에는 temp 배열로 값이 들어감
			}
		}
		System.out.println(Arrays.toString(temp));
		
		int[] result = new int[count]; //위의 temp에 들어간 값의 개수만큼 count가 올라가고, 그 값의 크기인 배열을 생성
		for(int i = 0; i < result.length; i++){ //0 ~ count-1까지 증가 반복
			result[i] = temp[i]; //temp에 있는 값들을 result로 이식, temp의 0들은 카운트에 적용되지 않기 때문에 들어가지 않음
		}
		System.out.println(Arrays.toString(result)); //결과적으로 result에는 temp의 값들 중 0이 아닌 값들만 들어가게 됨
		*/
		
		/*
		 * 정수배열 numbers에서 서로 다른 인덱스에 있는 두 수를 뽑아 더해 만들 수 있는 모든 경우의 수를 오름차순으로
		 * numbers[2, 1, 3, 4, 1]
		 * result[2, 3, 4, 5, 6, 7]
		 * numbers의 개수 2~100개
		 * numbers의 숫자 0~100 사이
		 */

		int[] numbers = { 2, 1, 3, 4, 1, 3, 6, 1};

		int sum = 0;
		int nl = numbers.length;
		int count = 0;

		int[] arr1 = new int[nl * nl];
		for (int i = 0; i < nl; i++) {
			for (int j = i + 1; j < nl ; j++) {
				arr1[count++] = numbers[i] + numbers[j]; // arr1에 숫자 합 대입
			}
		}
		
		count = 0;
		int[] arr2 = new int[nl*nl];
		for(int i = 0; i <nl*nl-1; i++){
			boolean flag = false;
			for(int j = i+1; j<nl*nl; j++){
				if(arr1[i] == arr1[j]){
					flag = true;
				}
			}if(!flag){
				arr2[count++] = arr1[i];
			}
		}
		
	int[] answer = new int[count]; 
		for(int i = 0; i<answer.length; i++){
			answer[i] = arr2[i];
		}
		
		for(int i = 1; i < answer.length; i++){
			int temp = answer[i];
			int j = 0;
			for(j = i-1; j >= 0; j--){
				if(answer[j] > temp){
					answer[j+1] = answer[j];
				}else break;
			}
			answer[j+1] = temp;
		}
		
		System.out.println(Arrays.toString(answer));

	}
}









