package net.developia.spring01.di301e;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//PropertySource는 BeanInit에만 걸면 된다.
@Configuration
@PropertySource("net/developia/spring01/di301e/system.properties")
public class BeanInit {
	//기존의 xml에서 <bean>으로 선언한게 여기 @Bean 부분과 동일한 동작임!
	
	@Bean
	Outputter outputter(){		//메서드 이름이 요청하는 id가 된다.
//		return new OutputterImpl();
		OutputterImpl outputter = new OutputterImpl();
		outputter.setFileOutputter(fileOutputter());
		return outputter;

	}
	
	@Bean
	FileOutputter fileOutputter(){
		return new FileOutputterImpl();
	}
}
