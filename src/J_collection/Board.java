package J_collection;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import E_oop.ScanUtil;

public class Board {
	public static void main(String[] args) {
		/*
		 * ArrayList와 HashMap을 사용해 게시판 테이블을 만들고
		 * 조회, 등록, 수정, 삭제가 가능한 게시판을 만드시오
		 * 
		 * 번호(PK), 제목, 내용, 작성자, 작성일
		 * 
		 * ex
		 * ---------------------
		 * 번호    제목     작성자    작성일
		 * ---------------------
		 * 1    ㅇㅇㅇㅇ  작성자    2/9
		 * 2    ㄴㄴㄴㄴ  작성자    2/9
		 * ---------------------
		 * 1.조회   2.등록   3.종료
		 * 
		 * 조회 후 수정, 삭제 가능
		 * 1.수정    2.삭제
		 */
		
		ArrayList<HashMap<String, Object>> main = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/DD");
		
		int input = 0;
		int num = 0;
		while(true){
			System.out.println("----------------------------");
			System.out.println("번호\t제목\t작성자\t작성일");
			System.out.println("----------------------------");
			for (int i = main.size() - 1; i >= 0 ; i--) {
				System.out.print(main.get(i).get("num"));
				System.out.print("\t" + main.get(i).get("title"));
				System.out.print("\t" + main.get(i).get("user"));
				System.out.print("\t" + sdf.format(main.get(i).get("date")));
				System.out.println();
			}
			System.out.println("----------------------------");
			
			System.out.println("1.조회\t2.등록\t3.종료");
			input = ScanUtil.nextInt();
			switch(input){
			case 1:
				System.out.println("번호를 입력하십시오.");
				input = ScanUtil.nextInt();
				num = input;
				System.out.println("번호 : " + main.get(num-1).get("num"));
				System.out.println("제목 : " + main.get(num-1).get("title"));
				System.out.println("내용 : " + main.get(num-1).get("content"));
				System.out.println("작성자 : " + main.get(num-1).get("user"));
				System.out.println("작성일 : " + sdf.format(main.get(num-1).get("date")));
				System.out.println();
				
				System.out.println("----------------------------");
				System.out.println("1.수정\t2.삭제\t3.메인메뉴");
				input = ScanUtil.nextInt();
				switch(input){
				case 1:
					if (num != 0) {
						System.out.println("-----제  목-----");
						String title = ScanUtil.nextLine();
						System.out.println("-----내  용-----");
						String content = ScanUtil.nextLine();
						
						HashMap<String, Object> board = main.get(num-1);
						board.put("title", title);
						board.put("content", content);
						board.put("date", new Date());
						System.out.println(num + "번 글이 수정되었습니다");
					} else if (num == 0) {
						System.out.println("등록된 내용이 없습니다.");
					}
					break;
				case 2:
					System.out.println("번호를 입력하십시오.");
					input = ScanUtil.nextInt();

					HashMap<String, Object> board = main.get(num-1);
					System.out.println(board.get("num") + "번 글이 삭제되었습니다.");
					main.remove(num-1);
					break;
				case 3:
					break;
				}
				System.out.println("----------------------------");
				break;
			case 2:
				int max = 0;
				for (int i = 0; i < main.size(); i++) {
					if(max < (Integer)main.get(i).get("num")){
						max=  (Integer)main.get(i).get("num");
					}
				}
				
				num = max + 1;
				HashMap<String, Object> board = new HashMap<>();
				System.out.println("-----제  목-----");
				String title = ScanUtil.nextLine();
				System.out.println("-----내  용-----");
				String content = ScanUtil.nextLine();
				System.out.println("-----작성자-----");
				String user = ScanUtil.nextLine();
				
				board.put("num", num);
				board.put("title", title);
				board.put("content", content);
				board.put("user", user);
				board.put("date", new Date());
				main.add(board);
				
				System.out.println(num + "번 글이 등록되었습니다.");
				break;
			case 3:
				System.out.println("종료.");
				System.exit(0);
			default:
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
	
	
}
