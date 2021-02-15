package Casino;

import java.util.Scanner;

import E_oop.ScanUtil;

class BlackJack {
	
	/*
	 * 룰
	 * 딜러와 플레이어 모두 카드를 2장씩 받는다
	 * 딜러는 두장 중 한장만을 오픈한다
	 * A는 1 또는 11로 계산한다.
	 * K,Q,J는 10으로 계산한다.
	 * 
	 * 플레이어
	 * - 원하는 만큼 카드를 받거나 멈출 수 있다(Hit , Stay)
	 * - 딜러보다 카드의 합이 높거나 블랙잭인 경우 승리한다.
	 * - 블랙잭(A + K/Q/J)인 경우, 딜러가 블랙잭인 경우를 제외하고는 승리한다
	 * - 딜러와 합이 같을 경우 비긴다(Push)
	 * - 플레이어의 합이 21을 넘을 경우 패한다(Burst)
	 * 
	 * 딜러
	 * - 카드의 합이 16 이하일 경우 Hit, 17 이상인 경우 Stay한다.
	 */
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		boolean uCardSetFull = false; // 유저의 카드패 초기화
		boolean dCardSetFull = false; // 딜러의 카드패 초기화
		boolean gameWin = true; // 게임 결과 판단. 승리로 초기화
		int comCardSet[] = new int[52]; // 무작위로 결정된 숫자(52개)를 저장

		comCardSetInit(comCardSet); // 공용 카드set 생성 및 초기화

		// 유저, 딜러의 블랙잭 판단을 위한 저장 공간
		boolean uBlackjack[] = new boolean[2]; // 유저 블랙잭 판단
		boolean dBlackjack[] = new boolean[2]; // 딜러 블랙잭 판단
		boolean uBlackjackWin = false; // 유저의 블랙잭 상태 초기화
		boolean dBlackjackWin = false; // 딜러의 블랙잭 상태 초기화

		// 카드 기본 셋팅: 유저 2장, 딜러 2장 배분
		String uCardSet[] = new String[6]; // 유저의 카드set 준비
		String dCardSet[] = new String[6]; // 딜러의 카드set 준비
		cardSetInit(uCardSet, dCardSet); // 유저과 딜러의 카드set 생성
		basicCardSetInit(comCardSet, uCardSet, uBlackjack); // 유저의 기본 카드 2장 배분
		basicCardSetInit(comCardSet, dCardSet, dBlackjack); // 딜러의 기본 카드 2장 배분

		// 게임 진행 순서
		game(comCardSet, uCardSet, dCardSet, uCardSetFull, dCardSetFull,
				uBlackjack, dBlackjack, uBlackjackWin, dBlackjackWin, gameWin,
				scan);

		// 결과 출력
		Result(uCardSet, dCardSet, uBlackjackWin, dBlackjackWin, gameWin);

		scan.close();
	}

		//카드 52장 모두 셔플(동일한 카드 존재하지 않도록)
		//(스페이드, 다이아, 클로버, 하트 네 종류의 카드 각각 13개)
	public static void comCardSetInit(int comCardSet[]) {

		boolean noSame[] = new boolean[52];

		// 무작위 숫자 결정 시 중복 불가를 위한 준비
		for (int i = 0; i < noSame.length; i++) {
			noSame[i] = false;
		}

		// 총 결정될 개수만큼 중복없는 숫자가 나올 때까지 무작위 결정을 반복
		int randLoop = 0;
		int randTemp;
		while (randLoop < 52) {
			randTemp = (int) (Math.random() * 52);
			if (noSame[randTemp] == false) {
				noSame[randTemp] = true;
				comCardSet[randLoop] = randTemp + 1;
				randLoop++;
			}
		}
	}

	// 유저과 딜러의 카드set 초기화
	public static void cardSetInit(String uCardSet[], String dCardSet[]) {
		for (int i = 0; i < uCardSet.length; i++) {
			uCardSet[i] = "0";
		}
		for (int i = 0; i < dCardSet.length; i++) {
			dCardSet[i] = "0";
		}
	}

	// 공용 카드에서 초기 카드 2장 뽑기
	public static void basicCardSetInit(int comCardSet[], String cardSet[],
			boolean blackjack[]) {
		String drawCardStr = null;
		int drawCard = 0;
		int cardSetPos = 0;
		int drawLoop = 0;

		// 공용 카드set에서 뽑은 카드는 다시 뽑지 않음
		while (drawLoop < 2) {
			cardSetPos = (int) (Math.random() * 52);
			drawCard = comCardSet[cardSetPos];
			if (drawCard != 0) {
				drawCardStr = checkNum(drawCard, blackjack);
				cardSet[drawLoop] = drawCardStr;
				comCardSet[cardSetPos] = 0;
				drawLoop++;
			}
		}

	}

	// 카드번호 체크 및 변환 + 블랙잭 판단
	public static String checkNum(int cardNum, boolean blackjack[]) {
		String result = null;
		
		// 뽑은 카드의 번호가 '1'이면 'A'로 변환
		if (cardNum == 1 || cardNum % 13 == 1) {
			result = "A";
			blackjack[0] = true;
		} // 10 K Q J 모두 10으로 치환, 블랙잭 확인
		if (cardNum % 13 == 0) {
			cardNum = 13;
			blackjack[1] = true;
		} else if (cardNum == 12 || cardNum == 11 || cardNum == 10) {
			blackjack[1] = true;
		} else {
			cardNum = (cardNum % 13);
		}

		// 카드 번호가 '11' 이상이면 'J, Q, K'로 변환
		if (cardNum > 10) {
			switch (cardNum) {
			case 11:
				result = "J";
				break;
			case 12:
				result = "Q";
				break;
			case 13:
				result = "K";
				break;
			}
		} else {
			if (cardNum > 1 && cardNum <= 10) {
				result = Integer.toString(cardNum);
			}
		}

		return result;
	}

	// 카드번호 체크 및 변환
	public static String checkNum(int cardNum) {
		String result = null;

		// 실제 카드 숫자로 변환
		if (cardNum == 1 || cardNum % 13 == 1) {
			result = "A";
		} else if (cardNum % 13 == 0) {
			cardNum = 13;
		} else {
			cardNum = (cardNum % 13);
		}

		// 카드 번호가 '11' 이상이면 'J, Q, K'로 변환
		if (cardNum > 10) {
			switch (cardNum) {
			case 11:
				result = "J";
				break;
			case 12:
				result = "Q";
				break;
			case 13:
				result = "K";
				break;
			}
		} else {
			result = Integer.toString(cardNum);
		}
		return result;
	}	

	// 게임 진행
	public static void game(int comCardSet[], String uCardSet[],
			String dCardSet[], boolean uCardSetFull, boolean dCardSetFull,
			boolean uBlackjack[], boolean dBlackjack[], boolean uBlackjackWin,
			boolean dBlackjackWin, boolean gameWin, Scanner scan) {

		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("-----게임을 시작합니다.-----");
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println();

		// 최초에 배분된 기본 카드 2장을 각각 공개
		System.out.println("Player's Deck");
		cardSetNum(uCardSet, 1);

		System.out.println("Dealer's Deck");
		cardSetNum(dCardSet, 2);
		System.out.println();

		// 유저의 기본 카드 2장이 'A'와 '10'면 유저의 블랙잭
		if (uBlackjack[0] == true && uBlackjack[1] == true) {
			uBlackjackWin = true;
		}
		// 딜러의 기본 카드 2장이 'A'와 '10'면 딜러의 블랙잭
		if (dBlackjack[0] == true && dBlackjack[1] == true) {
			dBlackjackWin = true;
		}

		// 반복 시작
		while (true) {
			// 카드를 뽑은 후 유저의 점수가 '21'을 초과하면 즉시 게임 패배
			if (pointResult(uCardSet) > 21) {
				gameWin = false;
				break;
			}

			// 유저 or 딜러가 '블랙잭'이면 즉시 게임 종료
			if (uBlackjackWin || dBlackjackWin) {
				// 결과 메시지 - 블랙잭 유무
				if (uBlackjackWin && !dBlackjackWin) {
					System.out.println("Winner Winner Chicken Dinner!");
				} else if (!uBlackjackWin && dBlackjackWin) {
					System.out.println("Lose by BlackJack");
				} else if (uBlackjackWin && dBlackjackWin) {
					System.out.println("Draw by BlackJack");
				}
				break;
			} else if (!gameWin) {
				break;
			} else {
				// 유저에게 'Hit or Stay' 물어봄
				System.out.println("Hit or Stay?");
				System.out.print("① Hit | ② Stay");
				int decision = ScanUtil.nextInt();
				System.out.println();

				// 유저가 'Hit' 결정 시 추가 카드 1장 받음
				if (decision == 1) {
					// 딜러 : 딜러 자신의 패가 16이하일 경우 한 장 더 뽑으며, 17 이상일 경우 Stay한다.
					// 딜러의 패의 공간이 남아있는 경우여야 한다.(2장 이상)
					if (pointResult(dCardSet) < 17
							&& !cardFull(dCardSet, dCardSetFull)) {
						drawCardOne(comCardSet, dCardSet); // 카드 뽑기
					}
					// 카드 뽑기 조건: 대상의 카드set이 비어있는 상태이어야 함
					if (!cardFull(uCardSet, uCardSetFull)) {
						drawCardOne(comCardSet, uCardSet); // 카드 뽑기
					}
					// 카드가 꽉 찾을 경우 강제로 'Stay'로 판단
					else {
						System.out
								.println("더 이상 카드를 받을 수 없습니다.");
						decision = 2;
					}

					// 카드를 뽑은 후 유저의 점수가 '21'을 초과하면 즉시 게임 패배
					if (pointResult(uCardSet) > 21) {
						gameWin = false;
						break;
					}

					System.out.println("Player's Deck");
					cardSetNum(uCardSet, 1);

					System.out.println("Dealer's Deck");
					cardSetNum(dCardSet, 2);
					System.out.println();

				} else if (decision == 2) {
					// 딜러 : 딜러 자신의 패가 16이하일 경우 한 장 더 뽑으며, 17 이상일 경우 Stay한다.
					// 딜러의 패의 공간이 남아있는 경우여야 한다.(2장 이상)
					if (pointResult(dCardSet) < 17
							&& !cardFull(dCardSet, dCardSetFull)) {
						drawCardOne(comCardSet, dCardSet); // 카드 뽑기
					}
					break;
				} else {
					// 예외 처리
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
					System.out.println();
				}
			}
		}
	}

	// 전체 카드set에서 카드 1장 뽑기
	public static void drawCardOne(int comCardSet[], String cardSet[]) {
		int drawLoop = 0;
		int cardSetPos = 0;
		int drawCard = 0;
		String drawCardStr = null;
		while (drawLoop < 1) {
			cardSetPos = (int) (Math.random() * 52);
			drawCard = comCardSet[cardSetPos];

			if (drawCard != 0) {
				drawCardStr = checkNum(drawCard);
				for (int i = 0; i < cardSet.length; i++) {
					if (cardSet[i] == "0") {
						cardSet[i] = drawCardStr;
						comCardSet[cardSetPos] = 0;
						drawLoop++;
						break;
					}
				}
			}
		}
	}

	// 배분된 카드 출력
	public static void cardSetNum(String cardSet[], int index) {
		// 'index' 값이 1이면 카드set 공개
		// 'index' 값이 2면 카드set에서 카드 1개 숨김
		if (index == 1) {
			for (int i = 0; i < cardSet.length; i++) {
				if (cardSet[i] == "0") {
					System.out.print(" ");
				} else {
					System.out.print(cardSet[i] + " ");
				}
			}
			System.out.println();
		} else if (index == 2) {
			for (int i = 0; i < cardSet.length; i++) {
				if (i == 0) { // 첫 번째 자리의 카드 숨김
					System.out.print("? ");
				} else {
					if (cardSet[i] == "0") {
						System.out.print(" ");
					} else {
						System.out.print(cardSet[i] + " ");
					}
				}
			}
			System.out.println();
		} else {
			// 예외 처리
			System.out.println("디버그. 인덱스 값이 잘못되었습니다.");
		}
	}

	// 유저의 카드set이 꽉 찬 상태인지 체크
	public static boolean cardFull(String cardSet[], boolean cardSetFull) {
		int count = 0;
		for (int i = 0; i < cardSet.length; i++) {
			if (cardSet[i] == "0") {
				count++;
			}
		}
		// 비어있는 개수가 없으면 꽉 찬 상태
		if (count == 0) {
			cardSetFull = true;
		}
		return cardSetFull;
	}

	// 점수 구하기
	public static int pointResult(String cardSet[]) {
		int point = 0;

		// 1차 점수 합산: 알파벳 카드는 따라 점수를 다르게 합산
		for (int i = 0; i < cardSet.length; i++) {
			if (cardSet[i] == "A") {
				point += 1;
			} else if (cardSet[i] == "J") {
				point += 10;
			} else if (cardSet[i] == "Q") {
				point += 10;
			} else if (cardSet[i] == "K") {
				point += 10;
			} else if (Integer.parseInt(cardSet[i]) > 1
					&& Integer.parseInt(cardSet[i]) <= 10) {
				point += Integer.parseInt(cardSet[i]);
			} else {
				point += 0;
			}
		}
		// 점수 합산이 끝난 뒤 카드set에 'A'가 존재할 경우,
		// 10점을 추가한 점수가 '21점 이하'면 10점 추가(A = 1 or 11)
		for (int i = 0; i < cardSet.length; i++) {
			if (cardSet[i] == "A" && point + 10 <= 21) {
				point += 10;
			}
		}
		return point;
	}

	// 결과 출력
	public static void Result(String uCardSet[], String dCardSet[],
			boolean uBlackjackWin, boolean dBlackjackWin, boolean gameWin) {
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("카드 오픈.");
		System.out.println();

		// 유저에게 배분된 카드와 점수 출력
		System.out.print("User : ");
		cardSetNum(uCardSet, 1);

		System.out.println("User's Score = " + pointResult(uCardSet));
		System.out.println();

		// 딜러에게 배분된 카드와 점수 출력
		System.out.print("Dealer : ");
		cardSetNum(dCardSet, 1);

		System.out.println("Dealer's Score = " + pointResult(dCardSet));
		System.out.println();

		
		// 결과 메시지 - 점수 비교
		//조건
		//승리 + (유저>딜러) + (유저<=21)
		//승리 + (유저<딜러) + (딜러>21)
		
			if (gameWin && pointResult(uCardSet) > pointResult(dCardSet)
					&& pointResult(uCardSet) <= 21 || gameWin
					&& pointResult(uCardSet) < pointResult(dCardSet)
					&& pointResult(dCardSet) > 21) {
				System.out.println("Win");
			}
			//유저 = 딜러
			else if (gameWin
					&& pointResult(uCardSet) == pointResult(dCardSet)
					&& pointResult(uCardSet) <= 21) {
				System.out.println("Draw");
			}
			//나머지
			else {
				System.out.println("Lose");
			}
	}
}
