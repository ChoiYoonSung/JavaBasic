package H_exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class ExceptoinHandling {

	public static void main(String[] args) {
		/*
		 * 에러
		 * - 컴파일 에러 : 컴파일 시에 발생되는 에러(빨간줄)
		 * - 논리적 에러 : 실행은 되지만, 의도와 다르게 동작하는 것(버그)
		 * - 런타임 에러 : 실행 시 발생되는 에러
		 * 
		 * 런타임 에러
		 * - 런타임 에러 발생시 발생한 위치에서 프로그램이 비정상적으로 종료된다.
		 * - 에러 : 프로그램 코드에 의해 수습될 수 없는 심각한 오류(처리 불가)
		 * - 예외 : 프로그램 코드에 의해서 수습될 수 있는 다소 미약한 오류(처리 가능)
		 * 
		 * 예외
		 * - 모든 예외는 Exception 클래스의 자식 클래스이다.
		 * - RuntimeException 클래스와 그 자식들은 예외처리가 강제되지 않는다. (대부분 사용하지 않는다)
		 * - [RuntimeException 클래스와 그 자식들을 제외한] Exception 클래스의 자식들은 예외처리가 강제된다 / 예외처리를 해주지 않을 시 RuntimeError가 생성된다.
		 * 
		 * 예외처리(try-catch)
		 * - 예외처리를 통해 프로그램이 비정상적으로 종료되는 것을 방지할 수 있다.
		 * - try {} catch (Exception e){} / (Exception e) = 파라미터
		 * - try 블럭 안의 내용을 실행 중 예외가 발생하면 catch로 넘어간다.
		 * - catch() 안에는 처리할 예외를 지정해줄 수 있다.
		 * - 여러 종류의 예외를 처리할 수 있도록 catch는 하나 이상을 올 수 있다.
		 * - 발생한 예외와 일치하는 catch 블럭 안의 내용이 수행된 후 try-catch를 빠져나간다.
		 * - 발생한 예외와 일치하는 catch 가 없을 경우 예외는 처리되지 않는다 .
		 */
		//순서
		//try -> 괄호 안에 문장 실행 -> 예외 발생시 -> catch -> 파라미터 읽음 -> 예외시 설정된 문장 수행 -> 빠져나옴
		//예외의 종류를 늘리기 위해서 파라미터의 종류를 늘린다. ex) catch(ArithmeticExceptino | NullpointerException e){}
		//모든 예외의 종류를 넣기 위해선 catch(Exception e){}를 사용한다 (자주사용)

		try {
			int result = 10 / 0;
			System.out.println(result);
		} catch (ArithmeticException e) {
			e.printStackTrace();
		} catch (NullPointerException | IndexOutOfBoundsException e) { //가장 많이 볼 예외
			//IndexOutOfBoundsException 예
			//존재하지 않는 배열을 불러올 때
			int[] arr = new int [10];
			System.out.println(arr[10]);
			
			//NullPointerException 예
			// = 라인의 변수에 null이 존재할 때
			String str = null;
			System.out.println(str.equals(""));
			
		} catch (Exception e) {

		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		/*
		 * CallStack
		 * |			|
		 * |__test2()___|
		 * |__test1()___|
		 * |___main()___|
		 * 
		 * 위치상 맨 위의 메서드를 해결하지 못하면 맨 밑의 메서드를 제대로 실행하지 못한다.
		 * 한 에러가 여러 위치에서 발생했을 경우 맨 위의 위치에서 발생했을 확률이 높다.
		 * 기본으로 만들어진 클래스,메서드 등에서 에러가 발생할 경우, 직접 코딩한 부분의 맨 윗부분의 에러를 확인한다.
		 */
		
		test1();

	}
	
	private static void test1(){
		test2();
	}
	
	private static void test2(){
//		System.out.println(10/0);
		try {
			new FileInputStream("");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}	
	

}




