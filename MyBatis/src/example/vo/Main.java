package example.vo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;

import example.dao.BookDAO;
import example.mybatis.MyBatisConnectionFactory;

public class Main {
	public static void main(String[] args) {
		//바로 db 처리
		// SqlSessionFactory가 있어야 주입해서 만든다
		//DAO를 만들려면 SqlSessionFactory를 먼저 확보해야 얘를 주입해서 DAO를 만들 수 있다.

		SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory(); //factory 생성 > DAO에 넣어준다
		BookDAO dao = new BookDAO(factory);
		//		1. 
		//		HashMap<String,Object> result = dao.selectByISBNHashMap("89-7914-206-4");
		//
		//		for(String key : result.keySet()) {
		//			System.out.println(key+ ":" +result.get(key));
		//		}


//		//		2. 모든 책의 정보를 hashmap으로 변환해서 가져올거에용
//		List<HashMap<String, Object>> result = dao.selectAllHashMap();
//		for(HashMap<String, Object> map : result) {
//			for(String key : map.keySet()) {
//				System.out.println(key+ ":" +map.get(key));
//			}
//			System.out.println();
//		}

		//	3. 모든 책의 정보를 BookVO로 변환해서 가져올거에용
//		BookVO result = dao.selectByISBNBookVO("89-7914-288-9");
//		System.out.println(result);

//		4. ISBN 번호를 이용해서 책 1권의 정보를 BookVO로 변환해서 가져오기
		//디버깅 하기
//		BookVO result = dao.selectByISBNResultMap("89-7914-288-9");
//		System.out.println(result);
//
//	}
//		5. ISBN번호로 특정책의 번호를 내가 원하는 번호로 Update
		BookVO bookVO = new BookVO("89-7914-206-4", "소리없는 아우성!!!!",0,null);
		int result = dao.titleUpdate(bookVO);
		System.out.println("영향을 받은 행의 개수는: "+result);
	
	}
}

