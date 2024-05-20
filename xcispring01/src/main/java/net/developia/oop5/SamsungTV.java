package net.developia.oop5;

public class SamsungTV {
	private Speaker speaker;
	
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	
	public void powerOn() {
		System.out.println("SamsungTV: TV를 켭니다");
	}
	public void powerOff() {
		System.out.println("SamsungTV: TV를 끕니다");
	}
	public void channelUp() {
		System.out.println("SamsungTV: 채널올려");
	}
	public void channelDown() {
		System.out.println("SamsungTV: 채널내려");
	}
	public void soundUp() {
		System.out.println("SamsungTV: 소리키워");
	}
	public void soundDown() {
		System.out.println("SamsungTV: 소리줄여");
	}
}
