package booksearch.dao;
//DAO(Data Access Object): 데이터베이스나 다른 저장소와의 상호 작용을 추상화한 객체로, 
// 데이터의 CRUD(Create, Read, Update, Delete) 작업을 수행하는 인터페이스 또는 클래스.
import booksearch.vo.BookVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;

public class BookDao {
//	1. Driver Loading(1번만 하면 되요 -> 생성자에 넣으면 좋아요)
//	2. Connection 획득
//	3. Statement 생성(SQL 쿼리 작성)
//	4. 실행 후 결과 가져오기
//	5. 결과 처리
//	6. 자원 반납(close 처리)
	private Connection con;

	public BookDao(Connection con) { //커넥션을 직접 만드는게 아니라 줏어온다
		this.con = con;
	}
	
	public BookDao() {
		try {
			// MySQL JDBC 드라이버 클래스를 로드

			try {
				
				//커넥션 되자마자
//				con.setAutoCommit(false); //여기부터 트랜잭션 시작! //실행은 되지만 결과가 실제 DB에 적용되진 않게.
//				
//				con.commit();
//				con.rollback();
				
				System.out.println("데이터베이스 접속 성공");

			} catch (SQLException e) {
				System.out.println("데이터베이스 접속 실패");
				throw new RuntimeException(e);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 오류");
			throw new RuntimeException(e);
		}
	}

//select 쿼리 처리 함수
	public ObservableList<BookVO> select(String keyword) {
		ResultSet rs = null;
		String sql = "SELECT bisbn, btitle, bprice, bauthor FROM book WHERE btitle LIKE ?";
		ObservableList<BookVO> data = FXCollections.observableArrayList(); // 우변은 비어 있는 ObservableList를 생성
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BookVO bookVO = new BookVO(
						rs.getString("bisbn"),
						rs.getString("btitle"),
						rs.getInt("bprice"),
						rs.getNString("bauthor")
						);
				data.add(bookVO);
			}
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			//자원반납은 무조건 해야하니까 finally 구문에 넣는다. or else...자원 leak됨.
			try {
				rs.close(); //여기서 rs 쓰기 위해 rs를 try문 안이 아닌 메서드 변수로 올려야 한다.
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		return data;
	}
	
//delete 쿼리 처리 함수
	public boolean delete(String keyword) {
		//connection은 service에서 만들어야 한다.
		String sql = "Delete FROM book WHERE bisbn = ?";
		boolean success = false;
//		ObservableList<BookVO> data = FXCollections.observableArrayList();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, keyword);
			success = pstmt.execute();
			System.out.println("데이터 삭제 성공!");

		} catch (SQLException e) {
//			throw new RuntimeException(e);
			System.out.println("BookDao.java의 deleted메서드 오류");
		}finally {
			//자원반납은 무조건 해야하니까 finally 구문에 넣는다. or else...자원 leak됨.
			try {
//				pstmt.close(); // service에서 닫아줘야 한다.
//				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		return success;
	}
	
}
