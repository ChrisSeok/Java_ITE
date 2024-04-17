package booksearch.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import booksearch.dao.BookDao;
import booksearch.vo.BookVO;
import booksearch.mybatis.MyBatisConnectionFactory;
import javafx.collections.ObservableList;
import java.sql.DriverManager;
//이 클래스가 아마도 MVC 중 Model
import booksearch.mybatis.MyBatisConnectionFactory;



public class BookSearchService { //로직처리 객체 
	
	
	SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory(); //factory 생성 > DAO에 넣어준다

	public List<BookVO> selectLike(String keyword) {
		List<BookVO> result = null;
		SqlSession session = factory.openSession();
		try {
			BookDao dao = new BookDao();
			result = dao.selectLike(keyword, session);
		} catch (Exception e) {
			
		}finally {
			session.close();
		}

		
		return result;

	}


	public void deleteBook(BookVO selectedData) {
		SqlSession session = factory.openSession();
		String deleteisbn = selectedData.getBisbn();
		try {
			BookDao dao = new BookDao();
			dao.deleteBook(deleteisbn, session);
			session.commit();
		}catch (Exception e) {
			session.rollback();
		}finally {
			session.close();
		}
		
	}
	
	public void updateBook(BookVO updateData) {
		SqlSession session = factory.openSession();
		try {
			BookDao dao = new BookDao();
			dao.titleUpdate(updateData, session);
			session.commit();
		}catch (Exception e) {
			session.rollback();
		}finally {
			session.close();
		}
		
	}
	

}

