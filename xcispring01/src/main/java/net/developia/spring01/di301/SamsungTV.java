package net.developia.spring01.di301;

import org.springframework.beans.factory.annotation.Autowired;

public class SamsungTV implements TV{
	
	@Autowired
	private Speaker speaker;
	
	public SamsungTV() {
		System.out.println("SamsungTV : 제품이 생산됨");
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
		if (speaker==null) {
			System.out.println("SamsungTV: 소리키워");
		}else {
			speaker.soundUp();
		}
	}
	public void soundDown() {
		if (speaker==null) {
			System.out.println("SamsungTV: 소리줄여");
		}else {
			speaker.soundDown();
		}
	}
}
