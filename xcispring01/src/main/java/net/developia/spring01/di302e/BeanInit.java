package net.developia.spring01.di302e;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource("net/developia/spring01/di302e/system.properties")
public class BeanInit {
	//여기서 property의 변수를 읽어온다 or OutputImpl에서 읽어도 된다.
	
	@Value("${name}") private String name;
	@Value("${greeting}") private String greeting;
	@Value("${filename}") private String filename;

	@Bean
	Outputter outputter(){		//메서드 이름이 요청하는 id가 된다.
		return new OutputterImpl(name, greeting, fileOutputter());

	}
	
	@Bean
	FileOutputter fileOutputter(){
		return new FileOutputterImpl(filename);
	}
}
