package booksearch.service;

import booksearch.dao.BookDao;
import booksearch.vo.BookVO;
import javafx.collections.ObservableList;

public class BookSearchService { //로직처리 객체 -> 로직별로 객체 새로 생성하나?
	//이 안에는 buisness 객체가 존재!

	public BookSearchService() {
	}

	public ObservableList<BookVO> searchBookByKeyword(String keyword) { // ObservableList는 JavaFX에서 제공하는 데이터 컬렉션입니다. 
		// 이는 기본적으로 Java의 List 인터페이스를 구현한 클래스로, 
		// 데이터를 저장하고 관리하는 데 사용됩니다. 그러나 ObservableList는 List와 다르게 
		// 데이터 변경 사항을 감지하고 관련된 UI를 자동으로 업데이트할 수 있습니다.
		//이 안에서는 일반 로직처리 하면 되요!
		//그런데 우리는 지금 별다른 로직처리를 할게 없다. DB 처리만 하면 됨
		//만약 Database 처리를 하게 되면 DAO를 만들어서 (따로 빼서)사용해야 해요!

		BookDao dao = new BookDao();
		ObservableList<BookVO> result = dao.select(keyword); //select 쿼리의 결과를 가져온다.
		return result;
	}

	public ObservableList<BookVO> deleteBookByTitle(String isbn, String search){
		//title로 삭제
		BookDao dao = new BookDao();
		boolean success = dao.delete(isbn); //delete 쿼리 결과가 true이면 select로 이전의 키워드 검색 결과 다시 보여주기
		//	if (success == true) {
		//삭제 성공했다면 삭제 후 결과를 화면에 띄워주자
		ObservableList<BookVO> result = dao.select(search); //select 쿼리의 결과를 가져온다.
		return result;
//	}

}
}
