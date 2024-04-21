package booksearch.dao;
//DAO(Data Access Object): 데이터베이스나 다른 저장소와의 상호 작용을 추상화한 객체로, 
// 데이터의 CRUD(Create, Read, Update, Delete) 작업을 수행하는 인터페이스 또는 클래스.
import booksearch.vo.BookVO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class BookDao {
	private SqlSessionFactory sqlSessionFactory;
	
	public BookDao() {
	}
	
//생성자 주입(Constructor Injection)
	public BookDao(SqlSessionFactory sqlSessionFactory) {
		super();
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	
// 1. 검색어가 포함된 책 조회

	public List<BookVO> selectLike(String keyword, SqlSession session) {  //alias를 잡아줬기 때문에 BookVO를 그냥 씀
		List<BookVO> result = null;
		 try {
			 // SqlSession 클래스에서는 CRUD를 위한 다양한 메서드를 제공, selectList는 select 실행 결과 레코드를 list로 바꿔준다. 
			//SqlSession의 selectList() 메서드를 사용하여 delete 쿼리를 실행하면 오류가 발생합니다. 
			// 이는 selectList() 메서드가 데이터를 조회하는 용도로 설계되어 있기 때문입니다.
			 result = session.selectList("booksearch.mybook.selectLike",keyword); // Book.xml 파일의 namespace.id, 두번째 인자명은 xml의 #{keyword}얘랑 이름 같아야 함.
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			session.close();
		}
		 return result; //List<BookVO> 형태
		}
	
	
// 2. 조회된 책 중 선택한 책 삭제
	public void deleteBook(String deleteisbn, SqlSession session) {
		try {
			session.delete("booksearch.mybook.deleteBook", deleteisbn);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	

	
// 3. ISBN 번호를 이용해서 책 1권의 제목을 변경
	public void titleUpdate(BookVO bookvo, SqlSession session) {
		try {
			session.update("booksearch.mybook.titleUpdate", bookvo);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}


}
