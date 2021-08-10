package z_homework;

import java.util.Scanner;

public class TV {
	boolean power; // 전원
	int channel; // 채널
	int volume; // 음량

	final int MIN_CHANNEL = 1;
	final int MAX_CHANNEL = 100;
	final int MIN_VOLUME = 0;
	final int MAX_VOLUME = 10;

	TV() {
		power = false;
		channel = 1;
		volume = 5;
	}

	public static void main(String[] args) {
		System.out.println("1. TV라는 클래스를 만들어주세요.");
		System.out.println("2. TV의 채널과 볼륨을 변수로 만들어주세요.");
		System.out.println("3. 채널 및 볼륨과 관계된 동작들을 메서드로 만들어주세요.");
		System.out.println("");
		System.out.println("");
		
		TV tv = new TV();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("---------------------------------------------");
			System.out.println("1.전원  2.채널변경  3.채널업  4.채널다운");
			System.out.println("5.볼륨업  6.볼륨다운  7.현재정보  0.종료");
			System.out.println("---------------------------------------------");
			System.out.print("번호 입력 >> ");
			int input = sc.nextInt();

			switch (input) {
			case 1:
				tv.power();
				break;

			case 2:
				System.out.print("변경할 채널 입력 >> ");
				int ch = sc.nextInt();
				tv.changeChannel(ch);
				break;

			case 3:
				tv.channelUp();
				break;
			case 4:
				tv.channelDown();
				break;
			case 5:
				tv.volumeUp();
				break;
			case 6:
				tv.volumeDown();
				break;
			case 7:
				tv.info();
				break;

			default:
				System.out.println("종료되었습니다.");
				sc.close();
				System.exit(0);
				break;
			}
		}
	}
	void power() {
		power = !power;
		System.out.println(power ? "TV 켜짐" : "TV 꺼짐");
	}

	void changeChannel(int channel) {
		if (power) {
			if (MIN_CHANNEL <= channel && channel <= MAX_CHANNEL) {
				this.channel = channel;
			}
			System.out.println("채널. " + this.channel);
		} else {
			System.out.println("전원이 꺼져있습니다.");
		}
	}

	void channelUp() {
		if (power) {
			changeChannel(channel + 1);
		} else {
			System.out.println("전원이 꺼져있습니다.");
		}
	}

	void channelDown() {
		if (power) {
			changeChannel(channel - 1);
		} else {
			System.out.println("전원이 꺼져있습니다.");
		}
	}

	void volumeUp() {
		if (power) {
			if (volume < MAX_VOLUME) {
				volume++;
			}
			showVolume();
		} else {
			System.out.println("전원이 꺼져있습니다.");
		}

	}

	void volumeDown() {
		if (power) {
			if (MIN_VOLUME < volume) {
				volume--;
			}
			showVolume();
		} else {
			System.out.println("전원이 꺼져있습니다.");
		}

	}

	void showVolume() {
		System.out.print("음량. ");
		for (int i = MIN_VOLUME + 1; i <= MAX_VOLUME; i++) {
			if (i <= volume) {
				System.out.print("■");
			} else {
				System.out.print("□");
			}
		}
		System.out.println();
	}

	void info() {
		System.out.println("현재 채널 : " + channel + " / 현재 볼륨 : " + volume);
	}
}
