package board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import board.dao.BoardDao;
import board.vo.BoardVO;
import mybatis.MyBatisConnection;

public class BoardService {


	//게시글 리스트 다 가져오는 Service
	public List<BoardVO> BringAllPost() {
		// DB 처리는 Dao한테 위임, SqlSession객체를 Dao에게 injection해서 사용.

		SqlSessionFactory factory = 
				MyBatisConnection.getSqlSessionFactory();

		SqlSession session = factory.openSession();

		List<BoardVO> result = null;

		//Dao를 이용해서 DB처리를 하면 되용.
		try {

			BoardDao dao = new BoardDao(session);
			result = dao.select();

			//				System.out.println("여기는 Service, dao result:" + result); 



		} catch (Exception e) {
			System.out.println("Board Service에서 오류 찍어용:"+ e);
		}finally {
			session.close();
		}

		return result;
	}

	
	public List<BoardVO> BringMyPost(int user_id) {

		SqlSessionFactory factory = 
				MyBatisConnection.getSqlSessionFactory();

		SqlSession session = factory.openSession();
		List<BoardVO> result = null;

		try {
			BoardDao dao = new BoardDao(session);
			result = dao.selectMyPost(user_id);


		} catch (Exception e) {
			System.out.println("Board Service에서 오류 찍어용:"+ e);
		}finally {
			session.close();
		}


		return result;
	}
	
	
	//특정 게시글 하나 가져오는 Service
	public BoardVO ShowPost(int post_id) {

		SqlSessionFactory factory = 
				MyBatisConnection.getSqlSessionFactory();

		SqlSession session = factory.openSession();
		BoardVO result = null;

		try {
			BoardDao dao = new BoardDao(session);
			result = dao.selectOnePost(post_id);


		} catch (Exception e) {
			System.out.println("Board Service에서 오류 찍어용:"+ e);
		}finally {
			session.close();
		}


		return result;
	}
	
	// 게시글 삭제
	public int deletePost(int post_id) {

		SqlSessionFactory factory = 
				MyBatisConnection.getSqlSessionFactory();

		SqlSession session = factory.openSession();
		int result = -1;

		try {
			BoardDao dao = new BoardDao(session);
			result = dao.deletpost(post_id);

			session.commit();
			
		} catch (Exception e) {
			System.out.println("Board Service에서 오류 찍어용:"+ e);
		}finally {
			session.close();
		}

		return result;
	}

	//게시글 수정
	public int EditPost(BoardVO postvo) {
		SqlSessionFactory factory = 
				MyBatisConnection.getSqlSessionFactory();

		SqlSession session = factory.openSession();
		
		int result = 0;

		try {
			BoardDao dao = new BoardDao(session);
			result = dao.updatepost(postvo);

			session.commit();
			
		} catch (Exception e) {
			System.out.println("Board Service에서 오류 찍어용:"+ e);
		}finally {
			session.close();
		}

		return result;
	}
	
	
	
	
	public int InsertPost(BoardVO postvo) {
		SqlSessionFactory factory = 
				MyBatisConnection.getSqlSessionFactory();

		SqlSession session = factory.openSession();
		
		int result = 0;

		try {
			BoardDao dao = new BoardDao(session);
			result = dao.insertpost(postvo);

			session.commit();
			
		} catch (Exception e) {
			System.out.println("Board Service에서 오류 찍어용:"+ e);
		}finally {
			session.close();
		}

		return result;
	}
	
	

}

