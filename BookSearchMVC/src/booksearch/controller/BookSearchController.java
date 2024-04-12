package booksearch.controller;

import booksearch.service.BookSearchService;
import booksearch.vo.BookVO;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

public class BookSearchController implements Initializable {

	//.fxml 파일의 컴포넌트와 연결
	@FXML private TextField textField;
	@FXML private Button searchBtn;
	@FXML private Button deleteBtn;
	@FXML private TableView tableView;
	@FXML private TableColumn<BookVO,String> isbn;
	@FXML private TableColumn<BookVO,String> title;
	@FXML private TableColumn<BookVO,Integer> price;
	@FXML private TableColumn<BookVO, String> author;
	private String selectedisbn;
	private String searchterm;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		//이부분은 뭐지 ???
		isbn.setCellValueFactory(new PropertyValueFactory<>("bisbn"));
		title.setCellValueFactory(new PropertyValueFactory<>("btitle"));
		price.setCellValueFactory(new PropertyValueFactory<>("bprice"));
		author.setCellValueFactory(new PropertyValueFactory<>("bauthor"));
		
//검색 버튼
		searchBtn.setOnAction(actionEvent -> {

			BookSearchService service = new BookSearchService();
			String keyword = textField.getText();
			searchterm = keyword; // 얘를 delete에 전달해줄거임
			ObservableList<BookVO> data = service.searchBookByKeyword(keyword);

			tableView.setItems(data);

		});
		
//책 선택 
		
		tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
	        if (newSelection != null) {
	            // 선택된 항목을 String에 저장
	            selectedisbn = ((BookVO) newSelection).getBisbn(); //isbn도 String타입 입니다
	        }
	    });
		
//삭제버튼
		deleteBtn.setOnAction(actionEvent -> {
//			selectedtitle로 쿼리 작성, 실행 
			//버튼을 누르면 삭제하고 삭제 결과까지 보여줘야 함
			BookSearchService service = new BookSearchService();
			ObservableList<BookVO> afterdelete  = service.deleteBookByTitle(selectedisbn,searchterm);
			
			tableView.setItems(afterdelete);
		});
	}
}
