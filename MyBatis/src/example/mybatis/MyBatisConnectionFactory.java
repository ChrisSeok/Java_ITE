package example.mybatis;


import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConnectionFactory { //sql session을 만들어주는 팩토리 객체를 리턴. 한번만 만들어놓고 주구장창 쓰면 된다
	// 실제 프로그램(DAO)에서 사용하는 데이터베이스 연결 객체는 
	// 기존(JDBC)일 떄는 connection객체를 이용했어요!
	// MyBatis에서는 SqlSession 객체를 이용해요!
	private static SqlSessionFactory sqlSessionFactory;

	//이 factory객체는 해당 클래스로부터 객체가 1개만 만들어져서 사용되도록 처리할거에요
	//= Singleton(클래스로부터 객체가 하나만 만들어지는 경우) 비스무리하게 동작하게끔.

	//static bn.block사용
	static {
		try {
			String resource = "./SqlMapConfig.xml";
			Reader reader = Resources.getResourceAsReader(resource); //지정한 xml 파일을 Reader를 이용해서 데이터를 들고온다.
			if(sqlSessionFactory == null) {
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader); //sessionfactory는 이렇게 만드는구나~
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	//MyBatisConnectionFactory얘를 통해서 sqlSessionFactory를 get하는 목적.
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

}
