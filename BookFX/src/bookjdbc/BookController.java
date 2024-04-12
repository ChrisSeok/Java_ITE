package bookjdbc;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import book.vo.BookVO;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

//이벤트 처리
public class BookController implements Initializable{
	//.fxml 파일로 가서 controller와 id를 설정해준다. 
	//	@FXML 어노테이션: FXML 파일에서 정의된 요소들을 컨트롤러 클래스의 필드에 자동으로 주입해줍니다.
	@FXML private TextArea display; //출력
	@FXML private Button searchBtn; //버튼
	@FXML private TextField searchword; //입력
	private Connection con;

//생성자
	// 드라이버 로딩, 데이터베이스 연결은 처음 한 번만 하면 된다 -> 생성자에서 해주자 !!!
	public BookController() {
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

			printMsg("DB 접속 성공성공!\n");


		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}   
	}

	
	
//TextArea에 출력
	private void printMsg(String msg) { 
		Platform.runLater(()-> { //바로바로 실행이 안되기 때문에 원하는 시점에 내용을 출력하려면 스레드를 별도로 만든다.
								// Runnable 객체 축약
			display.appendText(msg + "\n"); //TextArea인 display에 출력할게
		});
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
//		searchBtn.setOnAction(e ->{
//			display.clear(); // 검색버튼 누르면 일단 textArea 깨끗하게 지우기
//			
//			//입력값을 string으로 받기 > 쿼리에 넣고 쿼리 send > 결과 받아와서 textarea에 출력.
//			
//			String searchText = searchword.getText();
//
//			try {
//				// IN Parameter '?'를 사용해서 PreparedStatement를 생성한다. 
//				// 값을 나중에 변화시켜줘야 하는 경우 IN Parameter를 사용한다. (여러개 가능) 
//				// +로 문자열 concat해서 써도 되지만 코드가 지저분하고 유지보수 어려워짐.
//				
//				String sql = "SELECT * FROM book WHERE btitle like \"%여행%\";"; //여기서 애초에 btitle만 가져오면 ?
////				String sql = "SELECT * FROM book WHERE btitle LIKE ?"; //여기서 애초에 btitle만 가져오면 ?
//
//				PreparedStatement pstmt = con.prepareStatement(sql);  //prepared 와 prepare 관계는?
//				pstmt.setString(1, "%" + searchText + "%"); //1번째(인덱스 1부터 시작!!) 물음표를 두번째 인자로 채우겠다
//
//				ResultSet rs = pstmt.executeQuery(); //rs는 결과 레코드 집합의 포인터이다.  //여기서 오류
//				System.out.println(rs);
//				// 결과 출력
////				if (rs.next()) {
////					while (rs.next()) { //포인터 내릴 수 있으면 true, 아니면 false.
////						BookVO book = new BookVO(rs.getString("bisbn"), rs.getString("btitle"),rs.getInt("bprice"), rs.getString("bauthor")); // 현재 rs 위치에서 "" 칼럼을 찾아, 그 안에 있는 내용을 문자열로 리턴.
//						
//						//객체 하나로 관리하겠다
////						printMsg(bisbn+btitle+bprice+bauthor);
//					}
////				}
////				else {
////					printMsg("검색어가 포함된 책 이름이 없습니다.");
////				}
//
//				//자원 release
//				rs.close();
//				pstmt.close();
//				con.close();
//			} 
//윗부분은 오류..어디가 다른건지 찾기
		  System.out.println("여기는 초기화");
	        searchBtn.setOnAction((e)->{
	            String keyword = searchword.getText();

	            // IN Parameter를 이용해서 구현
	            String sql = "SELECT bisbn, btitle, bprice, bauthor FROM book "
	                    +"WHERE btitle LIKE ?";
	            try{
	                PreparedStatement pstmt = con.prepareStatement(sql);
	                pstmt.setString(1,"%"+keyword+"%");
	                ResultSet rs = pstmt.executeQuery();
	                // rs는 결과 레코드 집합의 포인터이다.

	                display.clear();
	                while (rs.next()){
	                    BookVO book = new BookVO(rs.getString("bisbn"),rs.getString("btitle"),rs.getInt("bprice"),rs.getString("bauthor"));
	                    // 결과를 TextArea에 추가
	                    
	                    Platform.runLater(()->{
	                    	display.appendText(book.toString()+"\n");
	                    });
	                    
	                }
	            }catch (Exception e1){
	                
	            }
	        });


		}
	}


