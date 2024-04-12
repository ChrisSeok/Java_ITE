package bookjdbc;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import book.vo.BookVO;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
//DB의 컬럼에 대한 레퍼런스가 있어야 사용할 수 있다.


public class BookSearchTableViewController implements Initializable{

	@FXML private Button searchBtn; //버튼
	@FXML private Button deleteBtn; //버튼
	@FXML private TextField textfield; //입력창
	@FXML private TableView tableView; //테이블 형식으로 데이터를 표시하는 컨트롤
	
	@FXML private TableColumn<BookVO, String> isbnCol;  //각 컬럼이 BookVO와 맵핑될것.
	@FXML private TableColumn<BookVO, String> titleCol; 
	@FXML private TableColumn<BookVO, Integer> priceCol; 
	@FXML private TableColumn<BookVO, String> authorCol; 

	private Connection con;

	//생성자
	// 드라이버 로딩, 데이터베이스 연결은 처음 한 번만 하면 된다 -> 생성자에서 해주자 !!!
	public BookSearchTableViewController() {

		System.out.println("여기는 BookController 생성자");

		// JDBC 드라이버 로딩
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  // JDBC 드라이버 로딩. //눕는 글씨의 함수는 static함수이다.
			String myId = "root";
			String myPw = "seok99";
			//protocol은 jdbc:mysql이다. library는 DB 이름임(테이블x)
			String JDBC_URL = "jdbc:mysql://localhost:3306/library?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true"; 

			try {
				con = DriverManager.getConnection(JDBC_URL,myId,myPw);
			} catch (SQLException e) {
				e.printStackTrace();
			}



		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}   
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		searchBtn.setOnAction((e)->{
			String keyword = textfield.getText();

			// IN Parameter를 이용해서 구현
			String sql = "SELECT bisbn, btitle, bprice, bauthor FROM book "
					+"WHERE btitle LIKE ?";
			try{
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1,"%"+keyword+"%");
				ResultSet rs = pstmt.executeQuery();
				// rs는 결과 레코드 집합의 포인터이다.

				ObservableList<BookVO> data = FXCollections.observableArrayList();

				//컬럼을 셋팅해준다.
				isbnCol.setCellValueFactory(new PropertyValueFactory<>("bisbn"));
				titleCol.setCellValueFactory(new PropertyValueFactory<>("btitle"));
				priceCol.setCellValueFactory(new PropertyValueFactory<>("bprice"));
				authorCol.setCellValueFactory(new PropertyValueFactory<>("bauthor"));

				while (rs.next()){
					BookVO book = new BookVO(rs.getString("bisbn"),
							rs.getString("btitle"),rs.getInt("bprice"),
							rs.getString("bauthor"));
					data.add(book);
				}

				tableView.setItems(data);
			}
			catch (Exception e1){

			}
			

			// 책 선택 > 버튼 > db에서 삭제 
			
				//BookObject클래스 대신 BookVO클래스 쓸 수 있나?
				BookVO selectedItem = (BookVO)tableView.getSelectionModel().getSelectedItem();
				  if (selectedItem != null) {
				        // 선택된 항목의 ISBN 가져오기
				        String isbn = selectedItem.getBisbn();

				        // ISBN을 사용하여 삭제 쿼리 작성
				        String deleteSQL = "DELETE FROM book WHERE bisbn = ?";

				        // PreparedStatement를 사용하여 삭제 쿼리 실행
				        PreparedStatement deleteStmt = con.prepareStatement(deleteSQL);
				        deleteStmt.setString(1, isbn);
				        int deletedRows = deleteStmt.executeUpdate();

				        // 삭제 후의 결과를 출력하거나 다른 작업을 수행할 수 있습니다.
				        if (deletedRows > 0) {
				            System.out.println("삭제된 책의 ISBN: " + isbn);

				            // 삭제된 책을 ObservableList에서 제거
				            ObservableList<BookVO> data = tableView.getItems();
				            data.remove(selectedItem);
				        } else {
				            System.out.println("삭제된 책 없음");
				        }
				if (selectedItem != null) {
					// 선택된 항목에 대한 작업을 수행합니다.
					String isbn = selectedItem.getBisbn();
				}

			} catch (Exception e2) {
			}
		});








	}
}


