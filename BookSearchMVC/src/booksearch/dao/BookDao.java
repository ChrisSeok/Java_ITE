package booksearch.dao;

import booksearch.vo.BookVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;

public class BookDao {

	private Connection con;

	public BookDao() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로딩 성공");
			String myID = "root";
			String myPW = "seok99";
			String myUrl = "jdbc:mysql://localhost:3306/library?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";

			try {
				con = DriverManager.getConnection(myUrl, myID, myPW);
				System.out.println("데이터베이스 접속 성공");

			} catch (SQLException e) {
				System.out.println("데이터베이스 접속 실패");
				throw new RuntimeException(e);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("오류");
			throw new RuntimeException(e);
		}
	}

//select 함수
	public ObservableList<BookVO> select(String keyword) {

		String sql = "SELECT bisbn, btitle, bprice, bauthor FROM book WHERE btitle LIKE ?";
		ObservableList<BookVO> data = FXCollections.observableArrayList();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				BookVO bookVO = new BookVO(
						rs.getString("bisbn"),
						rs.getString("btitle"),
						rs.getInt("bprice"),
						rs.getNString("bauthor")
						);
				data.add(bookVO);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return data;
	}
	
//delete 함수
	public boolean delete(String keyword) {

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
		}
		return success;
	}
	
}
