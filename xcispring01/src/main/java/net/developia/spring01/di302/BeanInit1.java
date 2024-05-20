package net.developia.spring01.di302;
//Constructor 주입
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//스프링 빈 configuration을 하는 자바 클래스가 됨
@Configuration
public class BeanInit1 {
	//기존의 xml에서 <bean>으로 선언한게 여기 @Bean 부분과 동일한 동작임!
	
	@Bean
	//upcasting해도 되고 원래 타입으로 줘도 된다.
	public TV tv(){		//메서드 이름이 요청하는 id가 된다.
		return new SamsungTV(speaker());
	}
	@Bean
	public Speaker speaker(){
		return new OrangeSpeaker();
	}
}
