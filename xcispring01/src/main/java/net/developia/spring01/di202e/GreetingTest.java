package net.developia.spring01.di202e;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class GreetingTest {
	public static void main(String[] args) {
		
	
	//ApplicationContext - 스프링 컨테이너 생성
			ApplicationContext context = 
					new GenericXmlApplicationContext(GreetingTest.class, "beaninit.xml"); //경로지정
			//net/developia/spring01/di101/beaninit.xml 의 설정정보를 읽어서 bean을 생성한다.
			
			
			System.out.println("---------------------------");
			//getBean메소드는 Object타입으로 가져오기때문에 type casting을 해줘야 한다.
			Outputter output= (Outputter) context.getBean("outputterImpl"); //Component 설정한 클래스명 소문자로. 아니면 value로 이름을 주거나!
			output.greeting();
	}	
}
