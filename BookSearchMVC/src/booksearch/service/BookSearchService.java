package booksearch.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import booksearch.dao.BookDao;
import booksearch.vo.BookVO;
import javafx.collections.ObservableList;

//이 클래스가 아마도 MVC 중 Model

public class BookSearchService { //로직처리 객체 -> 로직별로 객체 새로 생성하나?
	//이 안에는 buisness(기능용) 객체가 존재!
//static block 
	static {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //"com.mysql.cj.jdbc.Driver" - MySQL JDBC 드라이버 클래스의 전체 이름
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		System.out.println("드라이버 로딩 성공");
		
	}
//생성자
	public BookSearchService() {
		
	}
	
	
//검색 메서드
	public ObservableList<BookVO> searchBookByKeyword(String keyword) { 
		// ObservableList는 JavaFX에서 제공하는 데이터 컬렉션. 
		// ObservableList는 Java의 List 인터페이스를 구현한 클래스로, 
		// 데이터를 저장하고 관리하는 데 사용됩니다. 그러나 ObservableList는 List와 다르게 
		// 데이터 변경 사항을 감지하고 관련된 UI를 자동으로 업데이트할 수 있습니다.
		
		// ObservableList<BookVO>"는 "BookVO" 객체를 저장하는 데 사용되는 JavaFX의 ObservableList이다.
		
		//이 안에서는 일반 로직처리 하면 되요!
		//그런데 우리는 지금 별다른 로직처리를 할게 없다. DB 처리만 하면 됨
		//만약 Database 처리를 하게 되면 DAO를 만들어서 (따로 빼서)사용해야 해요!
		
		// DAO(Data Access Object): 데이터베이스나 다른 영속 저장소와의 상호 작용을 추상화한 객체로, 
		// 데이터의 CRUD(Create, Read, Update, Delete) 작업을 수행하는 인터페이스 또는 클래스.

		BookDao dao = new BookDao();
		ObservableList<BookVO> result = dao.select(keyword); //select 쿼리의 결과를 가져온다.
		return result;
	}

//삭제 메서드
//dao 하나는 sql쿼리 하나만 처리하도록.(여러개의 쿼리 처리하는건 지양하자)
	public ObservableList<BookVO> deleteBookByTitle(String isbn, String search){ //초기에 검색한 검색어를 인자로 가지고 있어야 삭제 후 결과를 보여줄 수 있음.
		//책의 isbn으로 삭제
		String myID = "root";
		String myPW = "seok99";
		String myUrl = "jdbc:mysql://localhost:3306/library?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
		Connection con = null;
		try {
			con = DriverManager.getConnection(myUrl, myID, myPW);
			con.setAutoCommit(false); //transaction 시작!

		} catch (SQLException e) {
			e.printStackTrace();
		}
		//transaction 처리를 하기 위해서는 service 단에서 transavtion이 
		//설정된 connection 
		// insert, delete, select 세 작업이 하나의 커넥션을 공유해서 사용하도록 해야한다.
		BookDao dao = new BookDao(con);
		
		//교수님코드 
		dao.insert(deleteIsbn);
		int count = dao.delete(deleteIsbn);
		ObservableList<BookVO> result = dao.select(keyword);
		con.commit();
		con.rollback();
		
		
		//내코드
//		boolean success = dao.delete(isbn); //delete 쿼리 결과가 true이면 select로 이전의 키워드 검색 결과 다시 보여주기
		
		//삭제 성공했다면 삭제 후의 결과를 화면에 띄워주자
		// 위의 select메서드 사용해서.
		//근데,,,,데이터가 변경되면 ObservableList는 이를 감지하여 UI를 자동으로 업데이트 한다는데 select를 다시 안해줘도 되는걸까나
//		ObservableList<BookVO> result = dao.select(search); //select 쿼리의 결과를 가져온다.
		return result;
//	}

}
}
