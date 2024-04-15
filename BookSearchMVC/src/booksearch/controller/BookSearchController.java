package booksearch.controller;

import booksearch.service.BookSearchService;
import booksearch.vo.BookVO;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
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
	@FXML private TableColumn<BookVO,String> isbn; //VO는 하나의 형태로 만들어서 편하게 사용하려는건데, 여러개 만들면 관리가 힘들어짐 > 테이블 형태로 하나 define할게용
	@FXML private TableColumn<BookVO,String> title;
	@FXML private TableColumn<BookVO,Integer> price;
	@FXML private TableColumn<BookVO, String> author;
	private String selectedisbn;
	private String searchterm;
	
	private String deleteIsbn;
	
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		//setCellValueFactory 메서드는 각 TableColumn에 대해 데이터를 어떻게 표시할지 설정하는 데 사용됩니다. 
		//PropertyValueFactory 클래스는 TableColumn이 해당 데이터 필드의 값을 가져오는 데 사용되는 클래스입니다. 
		//생성자에는 해당 데이터 필드의 이름을 전달합니다.
		//따라서 위의 코드에서 isbn, title, price, author 각각의 TableColumn에 대해 각각의 BookVO 객체의 
		//bisbn, btitle, bprice, bauthor 필드 값을 가져와 표시하도록 설정되어 있습니다. 이를 통해 TableView에 책 정보를 표시할 준비가 되었습니다.
		
		//VO의 어떤 필드가 tableView의 어떤 column에 매핑되는지를 설정
		isbn.setCellValueFactory(new PropertyValueFactory<>("bisbn")); //<>는 제네릭 타입 지정인데 자바의 타입추론 기능으로 자동으로 돼서 비어있는듯?
		title.setCellValueFactory(new PropertyValueFactory<>("btitle"));
		price.setCellValueFactory(new PropertyValueFactory<>("bprice"));
		author.setCellValueFactory(new PropertyValueFactory<>("bauthor"));
		
//교수님 코드
//		tableView.setRowFactory(e -> {
//			TableRow<BookVO> row = new TableRow<BookVO>();
//			row.setOnMouseClicked(event->{
//				if(event.getClickCount() == 1 && !row.isEmpty()) { //한번 클릭했고 해당 row가 빈게 아닐때 (실제 데이터가 있는row를 선택했을 때)
//					BookVO book = row.getItem();
//					deleteIsbn = book.getBisbn();
//				}
//			});
//		});
		
//검색 버튼
		searchBtn.setOnAction(actionEvent -> {

			BookSearchService service = new BookSearchService(); //버튼 누를때마다 객체를 만들어야 하나요? - 로직마다 객체를 만들 필요는 없다. 일단은 글케 할게요
			String keyword = textField.getText();
			searchterm = keyword; // 인스턴스 필드 searchterm에 대입 후 얘를 delete에 전달해줄거임, 밑에서 쓰이실게요
			ObservableList<BookVO> data = service.searchBookByKeyword(keyword); //화면처리를 위해 ObservableList타입으로 받아온다.

			tableView.setItems(data);

		});
		
//책 선택 
		
		tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
	        if (newSelection != null) {
	            // 선택된 항목을 String에 저장
	            selectedisbn = ((BookVO) newSelection).getBisbn(); //isbn도 String타입 입니다
	        }
	    });
		
		
//선택된 책의 isbn으로 책을 삭제할게요
//삭제버튼
		
		deleteBtn.setOnAction(actionEvent -> {
			//selectedisbn으로 delete 쿼리 작성, 실행 
			//버튼을 누르면 삭제하고 삭제 결과까지 보여줘야 함
			BookSearchService service = new BookSearchService();
			ObservableList<BookVO> afterdelete  = service.deleteBookByTitle(selectedisbn,searchterm);
			//선택한 책 삭제 후 searchterm으로 다시 select해서 DB에서 가져온 결과를 리턴한게 afterdelete에 담김
			tableView.setItems(afterdelete);
		});
	}
}
