package net.developia.spring01.di301;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TVTest {
	public static void main(String[] args) throws Exception{

		ApplicationContext context = 
				new AnnotationConfigApplicationContext(BeanInit1.class);
		
		
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
