package net.developia.spring01.di101;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVTest {
	public static void main(String[] args) throws Exception{
		//ApplicationContext - 스프링 컨테이너 생성
		ApplicationContext context = 
				new GenericXmlApplicationContext("net/developia/spring01/di101/beaninit.xml");
		//net/developia/spring01/di101/beaninit.xml 의 설정정보를 읽어서 bean을 생성한다.
		
		
		System.out.println("---------------------------");
		//getBean메소드는 Object타입으로 가져오기때문에 type casting을 해줘야 한다.
		TV tv1 = (TV) context.getBean("tv");
		
		tv1.powerOn();
		tv1.channelUp();
		tv1.channelDown();
		tv1.soundUp();
		tv1.soundDown();
		tv1.powerOff();
		
		System.out.println("---------------------------");
		TV tv2 = (TV) context.getBean("tv");

		tv2.powerOn();
		tv2.channelUp();
		tv2.channelDown();
		tv2.soundUp();
		tv2.soundDown();
		tv2.powerOff();
		System.out.println();
		// hashcode : 객체의 주소값을 Integer로 반환.
		System.out.println(tv1.hashCode() + ","+tv2.hashCode()); //Spring Bean은 생성자 한번만 실행되는 singleton임을 확인할 수 있다. 
	}

}
