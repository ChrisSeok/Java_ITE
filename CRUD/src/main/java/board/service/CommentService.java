package board.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import board.dao.BoardDao;
import board.dao.CommentDao;
import board.vo.BoardVO;
import board.vo.CommentVO;
import mybatis.MyBatisConnection;

public class CommentService {


//댓글 다 가져오기
	public ArrayList<CommentVO> BringAllComment(int post_id) {
		// DB 처리는 Dao한테 위임, SqlSession객체를 Dao에게 injection해서 사용.

		SqlSessionFactory factory = 
				MyBatisConnection.getSqlSessionFactory();

		SqlSession session = factory.openSession();

		ArrayList<CommentVO> result = null;

		//Dao를 이용해서 DB처리를 하면 되용.
		try {

			CommentDao dao = new CommentDao(session);
			result = dao.selectComment(post_id);


		} catch (Exception e) {
			System.out.println("Comment Service에서 오류 찍어용:"+ e);
		}finally {
			session.close();
		}

		return result;
	}
	
	
// 댓글 삭제
	public int deleteComment(int comm_id) {

		SqlSessionFactory factory = 
				MyBatisConnection.getSqlSessionFactory();

		SqlSession session = factory.openSession();
		int result = -1;

		try {
			CommentDao dao = new CommentDao(session);
			result = dao.deletcomment(comm_id);

			session.commit();
			
		} catch (Exception e) {
			System.out.println("Comment Service에서 오류 찍어용:"+ e);
		}finally {
			session.close();
		}

		return result;
	}
	
	
	public int updateComment(CommentVO vo) {

		SqlSessionFactory factory = 
				MyBatisConnection.getSqlSessionFactory();

		SqlSession session = factory.openSession();
		int result = -1;

		try {
			CommentDao dao = new CommentDao(session);
			result = dao.updatecomment(vo);

			session.commit();
			
		} catch (Exception e) {
			System.out.println("Comment Service에서 오류 찍어용:"+ e);
		}finally {
			session.close();
		}

		return result;
	}
	
//
//	//입력	
//		public int InsertPost(BoardVO postvo) {
//			SqlSessionFactory factory = 
//					MyBatisConnection.getSqlSessionFactory();
//
//			SqlSession session = factory.openSession();
//			
//			int result = 0;
//
//			try {
//				BoardDao dao = new BoardDao(session);
//				result = dao.insertpost(postvo);
//
//				session.commit();
//				
//			} catch (Exception e) {
//				System.out.println("Board Service에서 오류 찍어용:"+ e);
//			}finally {
//				session.close();
//			}
//
//			return result;
//		}
//		
//		
//
//	
//	
////게시글 수정
//	public int EditPost(BoardVO postvo) {
//		SqlSessionFactory factory = 
//				MyBatisConnection.getSqlSessionFactory();
//
//		SqlSession session = factory.openSession();
//		
//		int result = 0;
//
//		try {
//			BoardDao dao = new BoardDao(session);
//			result = dao.updatepost(postvo);
//
//			session.commit();
//			
//		} catch (Exception e) {
//			System.out.println("Board Service에서 오류 찍어용:"+ e);
//		}finally {
//			session.close();
//		}
//
//		return result;
//	}

	
	

}

