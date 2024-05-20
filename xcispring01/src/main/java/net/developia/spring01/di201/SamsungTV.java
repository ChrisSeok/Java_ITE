package net.developia.spring01.di201;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value="tv")
public class SamsungTV implements TV{
	
	@Autowired
	//@Inject //이 방법도 있다.
	//Speaker 빈이 여러개일 경우 Qualifier로 명시적으로 하나를 지정해주기
	@Qualifier(value = "Orange")
	private Speaker speaker;
	

	public void setSpeaker2(Speaker speaker) {
		this.speaker = speaker;
	}
	
	
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
