package net.developia.spring01.di202;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVTest {
	public static void main(String[] args) throws Exception{

		ApplicationContext context = 
				new GenericXmlApplicationContext(TVTest.class, "beaninit.xml");
		
		
		System.out.println("---------------------------");
		
		//getBean메소드는 Object타입으로 가져오기때문에 type casting을 해줘야 한다.
		TV tv1 = (TV) context.getBean("tv");
		
		tv1.powerOn();
		tv1.channelUp();
		tv1.channelDown();
		tv1.soundUp();
		tv1.soundDown();
		tv1.powerOff();
		
	}

}
