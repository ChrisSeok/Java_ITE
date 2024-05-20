package net.developia.oop5;

import java.io.FileInputStream;
import java.util.Properties;

public class TVTest {
	public static void main(String[] args) throws Exception{
		//여전히 구현체인 AppleTV에 의존적이다: 
		// AppleTV가 없으면 개발자는 코드를 작성할 수가 없다.
		// new Constructor;
		Properties props = new Properties();
		props.load(new FileInputStream("product.properties"));
		String speakerName = props.getProperty("speaker");
		Class speakerClass = Class.forName(speakerName);
		String tvName = props.getProperty("tv");
		Class clazz = Class.forName(tvName);
		Speaker speaker = (Speaker) speakerClass.getConstructor().newInstance(); // new MarshallSpeaker();
		TV tv = (TV) clazz.getConstructor().newInstance(); //new AppleTV();
		
//		tv.setSpeaker(speaker);
		
		tv.powerOn();
		tv.channelUp();
		tv.channelDown();
		tv.soundUp();
		tv.soundDown();
		tv.powerOff();

		
	}
	//AppleTV에서 MarshallSpeaker를 출력

}
