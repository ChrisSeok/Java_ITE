package member.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import member.dao.MemberDao;
import member.vo.MemberVO;
import mybatis.MyBatisConnection;

public class MemberService {
		//회원가입 Service
		public int Register(MemberVO vo) {
			// DB 처리는 Dao한테 위임, SqlSession객체를 Dao에게 injection해서 사용.

			SqlSessionFactory factory = 
					MyBatisConnection.getSqlSessionFactory();
			
			SqlSession session = factory.openSession();
			int result = -1;
//			System.out.println("여기는 Service, session:"+ session); //출력됨
			//Dao를 이용해서 DB처리를 하면 되용.
//			System.out.println("여기는 Service, vo: " + vo );

			try {
				
				MemberDao dao = new MemberDao(session);
				result = dao.insert(vo);
				System.out.println("여기는 Service try: " + vo + "result:" + result); //출력안됨

				
				session.commit();

			} catch (Exception e) {
				System.out.println("Service:"+ e);
			}finally {
				session.close();
			}
			
			
			return result;
		}
		
		
		
//		public List<MemberVO> Login(MemberVO vo) {
//			// 로직처리와 DB 처리를 하면 되는데
//			// DB 처리는 Dao한테 위임해야 하고, transaction 때문에 
//			// SqlSession객체를 Dao에게 injection해서 사용해야 해요!
//
//			SqlSessionFactory factory = 
//					MyBatisConnectionFactory2.getSqlSessionFactory();
////			System.out.println("factory:"+factory);
//			
//			SqlSession session = factory.openSession();
//			List<BookVO> result = null;
//			
//			//Dao를 이용해서 DB처리를 하면 되용.
//			//Database의 트랜잭션(commit, rollback)도 처리해야 해요!
//			try {
//				BookDao dao = new BookDao(session);
//				result = dao.select(vo);
//			} catch (Exception e) {
//			}finally {
//				session.close();
//			}
//			
//			return result;
//		}
//		
		
		
	}

