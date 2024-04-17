package booksearch.controller;

import booksearch.service.BookSearchService;
import booksearch.vo.BookVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.ResourceBundle;

public class BookSearchController implements Initializable {

	//.fxml 파일의 컴포넌트와 연결
	@FXML private TextField textField;
	@FXML private Button searchBtn;
	@FXML private Button deleteBtn;
	@FXML private Button updateBtn;
	@FXML private TextField updateTextField;
	@FXML private TableView tableView;
	@FXML private TableColumn<BookVO,String> isbn; //VO는 하나의 형태로 만들어서 편하게 사용하려는건데, 여러개 만들면 관리가 힘들어짐 > 테이블 형태로 하나 define할게용
	@FXML private TableColumn<BookVO,String> title;
	@FXML private TableColumn<BookVO,Integer> price;
	@FXML private TableColumn<BookVO, String> author;
	private String selectedisbn;
	private String searchterm;
	//	private String deleteIsbn;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {

		isbn.setCellValueFactory(new PropertyValueFactory<>("bisbn")); //<>는 제네릭 타입 지정인데 자바의 타입추론 기능으로 자동으로 돼서 비어있는듯?
		title.setCellValueFactory(new PropertyValueFactory<>("btitle"));
		price.setCellValueFactory(new PropertyValueFactory<>("bprice"));
		author.setCellValueFactory(new PropertyValueFactory<>("bauthor"));

		//교수님 코드
		//책 선택
		tableView.setRowFactory(e -> {
			TableRow<BookVO> row = new TableRow<BookVO>();
			row.setOnMouseClicked(event->{
				if(event.getClickCount() == 1 && !row.isEmpty()) { //한번 클릭했고 해당 row가 빈게 아닐때 (실제 데이터가 있는row를 선택했을 때)
					BookVO book = row.getItem();
					selectedisbn = book.getBisbn();
				}
			});
			return row;
		});



		//검색 버튼
		searchBtn.setOnAction(actionEvent -> {

			BookSearchService service = new BookSearchService(); //버튼 누를때마다 객체를 만들어야 하나요? - 로직마다 객체를 만들 필요는 없다. 일단은 글케 할게요
			List<BookVO> data = service.selectLike(textField.getText()); //화면처리를 위해 ObservableList타입으로 받아온다.

			tableView.setItems(FXCollections.observableArrayList(data));

		});



		//책 선택 (내 코드)
		//		tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
		//			if (newSelection != null) {
		//				// 선택된 항목을 String에 저장
		//				selectedisbn = ((BookVO) newSelection).getBisbn(); //isbn도 String타입 입니다
		//			}
		//		});


		//선택된 책의 isbn으로 책을 삭제할게요
		//삭제버튼

		//		deleteBtn.setOnAction(actionEvent -> {
		//			BookSearchService service = new BookSearchService();
		//			List<BookVO> afterdelete  = service.deleteBook(selectedisbn);
		//			//선택한 책 삭제 후 searchterm으로 다시 select해서 DB에서 가져온 결과를 리턴한게 afterdelete에 담김
		//			tableView.setItems(afterdelete);
		//		});


		deleteBtn.setOnAction(e -> {
			TableViewSelectionModel<BookVO> selectionModel = tableView.getSelectionModel();
			BookVO selectedData = selectionModel.getSelectedItem();

			if (selectedData != null) {
				BookSearchService service = new BookSearchService();
				service.deleteBook(selectedData);
				tableView.getItems().remove(selectedData);
			}
		});


		// 선택된 책의 isbn으로 제목을 입력값으로 변경할게요
		//update 버튼		
//		updateBtn.setOnAction(actionEvent -> {
//
//			BookSearchService service = new BookSearchService(); 
//			String changeword = updateTextField.getText();
//			System.out.println("변경할 제목: "+ changeword);
//			//BookSearchService.java로 간다
//			List<BookVO> data = service.updateBook(textField.getText()); //화면처리를 위해 ObservableList타입으로 받아온다.
//
//			tableView.setItems(FXCollections.observableArrayList(data));
//
//		});
		
        
        tableView.setEditable(true);

        
        tableView.setOnMouseClicked(e -> {
        	TableViewSelectionModel<BookVO> selectionModel = tableView.getSelectionModel();
        	if (e.getClickCount() == 2 && !selectionModel.isEmpty()) {
            	BookVO selectedData = selectionModel.getSelectedItem();
                title.setCellFactory(TextFieldTableCell.forTableColumn());
        		title.setOnEditCommit(event -> {
        		    // 변경된 값 가져오기
        		    String newValue = event.getNewValue();
        		    selectedData.setBtitle(newValue);
        		    System.out.println(selectedData.getBtitle());
        		    BookSearchService service = new BookSearchService();
        		    BookVO updateBookVO = new BookVO(selectedData.getBisbn(), selectedData.getBtitle(), selectedData.getBprice(), selectedData.getBauthor());
        		    service.updateBook(updateBookVO);
        		    
        		    // 변경된 값으로 데이터 모델 업데이트
        		    event.getTableView().getItems().get(event.getTablePosition().getRow()).setBtitle(newValue);
        		});
        	}
        });
		

	}

}
