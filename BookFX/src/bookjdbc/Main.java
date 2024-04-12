//검색어를 입력하면, 해당 검색어가 포함된 책 제목을 띄워주는 프로그램을 javafx와 mysql을 사용해서 만들어보아용

//properties>build path > module에 mysql jar(Driver)파일, javafx lib 내 파일들 추가.
package bookjdbc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	    @Override
	    public void start(Stage primaryStage) throws Exception {
	        // 화면 구성 역할
	        // fxml 파일을 이용해서 Pane을 가져와서 Scene을 만들고 Stage에 붙여서 사용
	        
	    	//이 부분은 항상 똑같다
	    	Parent root = null;
	        
	        FXMLLoader loader = new FXMLLoader( // fxml 파일을 불러들임
	                getClass().getResource("JavaFXBookSearchTableView.fxml")
	        );
	        
	        try {
	            root = loader.load();
	        }
	        catch (Exception e){
	        	System.out.println("Main에서 bookfx.fxml 로딩에서 문제가 생겼어용");
//	            System.err.println(e);
	        }
	        
	        
	        Scene scene = new Scene(root); //Scene을 만들고

	        primaryStage.setScene(scene); //Stage에 Scene을 붙여서
	        
	        primaryStage.show(); // show해서 올린다.
	    }
	    
	    
	    public static void main(String[] args) {
	        launch(args);
	    }
	}

