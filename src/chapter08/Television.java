package chapter08;

public class Television implements RemoteControl {
// remoteControl 인터페이스를 구현한 Television 클래스

	private int volume;

	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다.");
	}

	@Override
	public void setVolume(int vloume) {
		if (volume > MAX_VOLUME) {
			this.volume = MAX_VOLUME;
		} else if (volume < MIN_VOLUME) {
			this.volume = MIN_VOLUME;
		} else {
			this.volume = vloume;
		}
		System.out.println("현재 TV 볼륨: " + this.volume);
	}
	
	
}
