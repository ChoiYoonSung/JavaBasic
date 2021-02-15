package E_oop;

public class BluetoothSpeaker {

	static boolean power;
	boolean bluetooth;
	int code;
	int volume;
	boolean play;
	static String mode;
	String song;

	final int Volume_Min = 0;
	final int Volume_Max = 20;

	BluetoothSpeaker() {
		power = false;
		bluetooth = false;
		volume = 5;
		play = false;
		code = (int) (Math.random() * 101);
	}

	void Power() {
		power = !power;
		System.out.println(power ? "Power On" : "Power Off");
		if (power == true) {
			Bluetooth(code);
		} else if (power == false) {
			Bluetooth(code);
		}
	}

	void Bluetooth(int code) {
		bluetooth = !bluetooth;
		System.out.println(bluetooth ? "Bluetooth On" : "Bluetooth Off");

		if (bluetooth == true) {
			System.out.println("Pairing...");
			System.out.println("code : " + this.code);
			System.out.println("Enter Code");
			int phonecode = ScanUtil.nextInt();

			if (code == this.code) {
				System.out.println("Success");
			} else {
				System.out.println("Fail");
			}
		}
	}

	void VolumeUp() {
		if (power) {
			if (volume < Volume_Max) {
				volume++;
			}
			if (volume == Volume_Max) {
				System.out.println("Maximum Volume.");
			}
			VolumeSound();
		} else
			System.out.println("전원을 켜십시오.");
	}

	void VolumeDown() {
		if (power) {
			if (volume > Volume_Min) {
				volume--;
			}
			if (volume == Volume_Min) {
				System.out.println("Minimum Volume.");
			}
			VolumeSound();
		} else
			System.out.println("전원을 켜십시오.");
	}

	void VolumeSound() {
		System.out.print("음량. ");
		for (int i = Volume_Min + 1; i <= Volume_Max; i++) {
			if (i <= volume) {
				System.out.print("*");
			} else {
				System.out.print("-");
			}
		}
		System.out.println();
	}

	void Play() {
		if (power) {
			play = !play;
			if (play == true) {
				System.out.println("Play ▶");
			} else {
				System.out.println("Pause ||");
			}
		} else
			System.out.println("전원을 켜십시오.");

	}
	
	void Song(String song){
		System.out.println("원하는 노래를 입력하십시오.");
		song = ScanUtil.nextLine();
		this.song = song;
		System.out.println("♪song♬");
	}

	void Mode(String m) {
		if (power) {
			System.out.println("다음곡(>)");
			System.out.println("이전곡(<)");
			m = ScanUtil.nextLine();
			this.mode = m;

			if (m == ">" || m == ".") {
				System.out.println("다음곡을 재생합니다.");
				play = true;
			} else if (m == "<" || m == ",") {
				System.out.println("이전곡을 재생합니다.");
				play = false;
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		} else
			System.out.println("전원을 켜십시오.");

	}

	public static void main(String[] args) {
		BluetoothSpeaker BS = new BluetoothSpeaker();

		System.out.println("Bluetooth Speaker Simple Program");
		while (true) {
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			if (power == false) {
				System.out.println("■\tstatue : Power off\t■");
			} else if (power == true) {
				System.out.println("■\tstatue : Power on\t■");
			}
			System.out.println("■\t\t\t\t■");
			System.out.println("■\t①전원     ②볼륨↑  ③볼륨↓\t■");
			System.out.println("■\t④정지|일시정지  ⑤다음곡|이전곡\t■");
			System.out.println("■\t\t\t\t■");
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");

			System.out.println("Enter the number what you want");
			int input = ScanUtil.nextInt();

			switch (input) {
			case 1:
				BS.Power();
				break;
			case 2:
				BS.VolumeUp();
				break;
			case 3:
				BS.VolumeDown();
				break;
			case 4:
				BS.Play();
				break;
			case 5:
				BS.Mode(mode);
				break;

			default:
				System.out.println("System Off");
				System.exit(0);
				break;

			}

		}
	}

}
