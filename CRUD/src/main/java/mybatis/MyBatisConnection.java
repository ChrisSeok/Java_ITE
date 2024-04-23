package mybatis;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConnection {
	
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		try {
			String resource = "./SqlConfig.xml";
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

