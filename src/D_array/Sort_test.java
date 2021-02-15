package D_array;

import java.util.Arrays;

public class Sort_test {

	public static void main(String[] args) {
		
		//인덱스 10의 배열에 랜덤한 값 부여
		int[] arr = new int[10];
		for(int i = 0; i < arr.length; i++){
			arr[i] = (int)(Math.random()*100)+1;
		}
		System.out.println(Arrays.toString(arr));
		
		
		//선택 정렬
	/*	for(int i = 0; i < arr.length - 1; i++){ // 0~8 마지막 회차때 맞춰지기 때문에 1 뺀만큼만 작동한다
			int min = i;
			for(int j = i+1; j < arr.length; j++){ //앞의 배열들은 이미 최소값으로 나열되어 있기 때문
				if(arr[min] > arr[j]){ //최소값 비교 및 교환
					min = j;
				}
			}
			int temp = arr[i]; //위치 교환
			arr[i] = arr[min];
			arr[min] = temp;
		}
		System.out.println(Arrays.toString(arr));
		*/
		
		//버블 정렬
	/*	int temp = 0;
		bubble: for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					if (temp == 0) {
						break bubble;
					}
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		*/
		
/*		for(int i = 0; i < arr.length -1; i++){ //전체길이의 1을 뺀 만큼 반복하는 이유는 마지막 이전회차때 정렬이 완성되기 때문
			for(int j = 0; j < arr.length -1 -i; j++){ //전체길이에서 1과 i만큼 빼는 이유는 회차를 거듭할수록 뒤쪽 정렬이 누적되기 때문
				if(arr[j] > arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	*/	
		
		//삽입정렬
		//초기 상태의 배열에서 1번째 인덱스와 이전 인덱스를 비교, 위치를 조정한다
		//그 후 n번째 인덱스와 이전 인덱스들을 차례로 비교,위치를 조정한다.
		
		for(int i = 1; i < arr.length; i++){ //1 ~ 9
			int temp = arr[i];
			int j = 0;
			for(j = i-1; j >= 0; j--){
				if(arr[j] > temp){
					arr[j + 1] = arr[j];
				}else break;
			}
			arr[j+1] = temp;
		}
		System.out.println(Arrays.toString(arr));
		
		
		
	}

}






