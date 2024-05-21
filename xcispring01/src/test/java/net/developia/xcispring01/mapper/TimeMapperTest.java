package net.developia.xcispring01.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import lombok.extern.log4j.Log4j;

@WebAppConfiguration //test에는 왠만하면 붙이자!
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:**/*-context.xml") //알아서 root-context를 읽는다
@Log4j
public class TimeMapperTest {
	//어노테이션 사용
	@Autowired
	private TimeMapper timeMapper;
	
	@Test
	public void testGetTime() {
		assertNotNull((timeMapper.getClass().getName()));
		
		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//
//		log.info(timeMapper.getClass().getName());
//		log.info(timeMapper.getTime());
		
		// jUnit4 메소드
		// assertEquals(a,b) - 객체 a와 b의 값이 같은지 확인
		assertEquals(timeMapper.getTime(),today.format(formatter));
		
	}
	
	@Test(timeout=3000)
	public void testGetTime2() {
		//XML과 Mapper 인터페이스 사용
		assertNotNull((timeMapper.getClass().getName()));
		
		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//
//		log.info(timeMapper.getClass().getName());
//		log.info(timeMapper.getTime());
		
		// jUnit4 메소드
		// assertEquals(a,b) - 객체 a와 b의 값이 같은지 확인
		assertEquals(timeMapper.getTime2(),today.format(formatter));
		
	}
	
}


