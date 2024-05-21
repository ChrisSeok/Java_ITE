package net.developia.xcispring01;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
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
public class DataSourceTests {
	@Autowired
	private DataSource dataSource;
	@Autowired
	private SqlSessionFactory sqlSessionFactory; //자동으로 주입이 된다. root-context.xml에 만든 sqlSessionFactory Bean
	@Test
	public void testMyBatis() {
		try(SqlSession session = sqlSessionFactory.openSession();
					Connection con = session.getConnection()){
			log.info(session);
			log.info(con);
		}catch (Exception e){
			fail(e.getMessage());
		}
	}
	@Test
	public void testConnection() {
		try(Connection con = dataSource.getConnection()){
			log.info(con);
		}catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
