package net.developia.spring01.di301e;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GreetingTest {
	public static void main(String[] args) {
		
	
	//ApplicationContext - 스프링 컨테이너 생성
			ApplicationContext context = 
					new AnnotationConfigApplicationContext(BeanInit.class); //Java class로 설정
			
			
			System.out.println("---------------------------");
			//getBean메소드는 Object타입으로 가져오기때문에 type casting을 해줘야 한다.
			Outputter output= (Outputter) context.getBean("outputter"); //Component 설정한 클래스명 소문자로. 아니면 value로 이름을 주거나!
			output.greeting();
	}	
}
