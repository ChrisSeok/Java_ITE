package example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import example.vo.BookVO;

public class BookDAO {
	//여기서 SqlSessionFactory를 직접 얻어내지 않아요! (생성자를 통해 인자로 주입받아서 처리)
	private SqlSessionFactory sqlSessionFactory;
	
	
	public BookDAO() {
	}
	
//생성자 주입(Constructor Injection)
	public BookDAO(SqlSessionFactory sqlSessionFactory) {
		super();
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	
	//1. ISBN번호를 입력으로 받아서 책 한권의 데이터를 Hashmap(key-value)으로 만들어서 리턴하는 메서드를 작성해보아요
	//book.xml을 이용하는 메서드를 만들거야
	public HashMap<String, Object> selectByISBNHashMap(String bisbn){ //헷갈리지 않으려고 book.xml의 select문 id랑 일치시킴. (같을필요x)
		 HashMap<String, Object> result = null;
		 SqlSession session = sqlSessionFactory.openSession();	
		 try {
			result = session.selectOne("example.mybook.selectByISBNHashMap",bisbn); // Book.xml 파일의 namespace.id, 두번째 인자명은 xml의 #{bisbn}얘랑 이름 같아야 함.
		} catch (Exception e) {
		}finally {
			session.close();
		}
		 return result; //sqlSessionFactory 리턴해서 줌
	}
	
	
	
	//2. 모든 책의 데이터를 HashMap의 List로 만들어서 리턴하는 메서드
	//list of hashmaps
	public List<HashMap<String, Object>> selectAllHashMap(){ //헷갈리지 않으려고 book.xml의 select문 id랑 일치시킴. (같을필요x)
		
		List<HashMap<String, Object>> result = null;
		 SqlSession session = sqlSessionFactory.openSession();	
		 try {
			 //이번에는 여러개를 들어오니까 selectOne 대신 selectList 메서드 사용.
			result = session.selectList("example.mybook.selectAllHashMap"); // Book.xml 파일의 namespace.id, 두번째 인자명은 xml의 #{bisbn}얘랑 이름 같아야 함.
		} catch (Exception e) {
		}finally {
			session.close();
		}
		 return result; //sqlSessionFactory 리턴해서 줌
	}
	
	//3. ISBN 버호를 입력으로 받아 책 1권의 데이터를 BookVO로 만들어서 리턴하는 메서드를 작성해보아요!
	
	
	public BookVO selectByISBNBookVO(String bisbn){ //헷갈리지 않으려고 book.xml의 select문 id랑 일치시킴. (같을필요x)
		
		BookVO result = null;
		 SqlSession session = sqlSessionFactory.openSession();	
		 try {
			result = session.selectOne("example.mybook.selectByISBNBookVO",bisbn); // Book.xml 파일의 namespace.id, 두번째 인자명은 xml의 #{bisbn}얘랑 이름 같아야 함.
		} catch (Exception e) {
		}finally {
			session.close();
		}
		 return result; //sqlSessionFactory 리턴해서 줌
	}
	
	
// 4. ISBN 번호를 이용해서 책 1권의 정보를 BookVO로 변환해서 가져오기
//그런데 table의 column명이 VO의 필드명과 다를경우 어떻게 하나요?
	
	
	public BookVO selectByISBNResultMap(String bisbn){ //헷갈리지 않으려고 book.xml의 select문 id랑 일치시킴. (같을필요x)
		
		BookVO result = null;
		 SqlSession session = sqlSessionFactory.openSession();	
		 try {
			result = session.update("example.mybook.selectByISBNResultMap",bisbn); // Book.xml 파일의 namespace.id, 두번째 인자명은 xml의 #{bisbn}얘랑 이름 같아야 함.
		} catch (Exception e) {
		}finally {
			session.close();
		}
		 return result; //sqlSessionFactory 리턴해서 줌
	}
	
// 5. ISBN 번호를 이용해서 책 1권의 정보를 변경하고 싶어요.
// 책의 제목을 바꿀꺼에요.
	public int titleUpdate(BookVO bookVO) {
		int result = 0;
		SqlSession session = sqlSessionFactory.openSession();	
		try {											// id
				result = session.update("example.mybook.titleUpdate",bookVO); // Book.xml 파일의 namespace.id, 두번째 인자명은 xml의 #{bisbn}얘랑 이름 같아야 함.
			} catch (Exception e) {
				System.out.println(e);
			}finally {
				// *** update 계열 쿼리는 반드시 commit 처리 해줘야 함!!(DB에 변화가 생기기 때문에)
				session.commit(); 
				session.close();
			}
			 return result; //정상 작동하면 1(=영향받은 row 수) 리턴
		}
		
}
	
	
