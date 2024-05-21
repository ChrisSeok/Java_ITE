package net.developia.xcispring01;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.extern.log4j.Log4j;

@WebAppConfiguration //test에는 왠만하면 붙이자!
@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration("file:**/*-context.xml")
@Log4j
public class JDBCTest {
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testConnection() {
		try(Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521/xepdb1",
				"SCOTT", 
				"TIGER"
				)){
			//log4j의 모드는 이렇게 5가지가 있다: 
//			log.debug(con);
//			log.info(con);
//			log.warn(con);
			log.error(con);
//			log.fatal(con);
			
		}catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
