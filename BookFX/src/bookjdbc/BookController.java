package bookjdbc;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
//import networkexam.MyRunnable;

public class BookController implements Initializable{

	@FXML private TextArea display; //출력
	@FXML private Button searchBtn; //버튼
	@FXML private TextField searchword; //입력

	private void printMsg(String msg) { 
		Platform.runLater(()-> { //바로바로 실행이 안되기 때문에 원하는 시점에 내용을 출력하려면 스레드를 별도로 만든다.
			// Runnable 객체 축약
			display.appendText(msg + "\n");
		});
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		searchBtn.setOnAction(e ->{
//			printMsg("입력시작");
			//입력값을 string > 쿼리에 넣고 쿼리 send > 결과 받아와서 textarea에 출력.
			String searchText = searchword.getText();
			
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");   // JDBC 드라이버 로딩. //눕는 글씨의 함수는 static함수이다.
//				System.out.println("드라이버 로딩 성공성공!");

				String myId = "root";
				String myPw = "seok99";
				String JDBC_URL = "jdbc:mysql://localhost:3306/library?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true"; //protocol은 jdbc:mysql이다.

				Connection con = DriverManager.getConnection(JDBC_URL,myId,myPw);
				printMsg("DB 접속 성공성공!\n");
				
				
		        String sql = "SELECT * FROM book WHERE btitle LIKE ?"; //여기서 애초에 btitle만 가져오면 ?
	            PreparedStatement pstmt = con.prepareStatement(sql);  //prepared 와 prepare 관계는?
	            pstmt.setString(1, "%" + searchText + "%");
	            ResultSet rs = pstmt.executeQuery();

	            // 결과 출력
	           if (rs.next()) {
	        	   while (rs.next()) {
		            	String title = rs.getString("btitle"); // 현재 rs 위치에서 "first_name" 칼럼을 찾아, 그 안에 있는 내용을 문자열로 리턴.
		            	printMsg(title);
		            }
	           }
	           else {
	        	   printMsg("검색어가 포함된 책 이름이 없습니다.");
	           }
				
				//자원 release
				rs.close();
				pstmt.close();
				con.close();
			} 

			catch (Exception e1) {
				System.out.println("먼가 잘못됐어용~");
			}  
			
			
			
			

		});
	}
}

