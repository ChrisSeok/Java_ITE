package net.developia.spring01.di202;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value="tv")
public class SamsungTV implements TV{
	

	private Speaker speaker;

	//speaker bean 지정
	public SamsungTV(@Qualifier(value="harman")Speaker speaker) {
		this.speaker = speaker;
		System.out.println("SamsungTV : 제품이 생산되었습니다.");
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
