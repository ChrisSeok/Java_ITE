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

			try {
				
				MemberDao dao = new MemberDao(session);
				result = dao.insert(vo);
//				System.out.println("여기는 Service try: " + vo + "result:" + result); 

				
				session.commit();

			} catch (Exception e) {
				System.out.println("Service에서 오류 찍어요:"+ e);
			}finally {
				session.close();
			}
			
			
			return result;
		}
		
		
		
		
		public MemberVO Login(MemberVO vo) {
			// DB 처리는 Dao한테 위임, SqlSession객체를 Dao에게 injection해서 사용.

			SqlSessionFactory factory = 
					MyBatisConnection.getSqlSessionFactory();
			
			SqlSession session = factory.openSession();
		
			MemberVO result = null;

			//Dao를 이용해서 DB처리를 하면 되용.
			try {
				
				MemberDao dao = new MemberDao(session);
				result = dao.select(vo);
//				System.out.println("여기는 Service try: " + vo + "result:" + result); 
				
				session.commit();

			} catch (Exception e) {
				System.out.println("Service에서 오류 찍어용:"+ e);
			}finally {
				session.close();
			}
			
			return result;
		}
		
		
		
	}

