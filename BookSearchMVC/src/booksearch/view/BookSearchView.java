//MVC는 애플리케이션의 사용자 인터페이스, 비즈니스 로직, 데이터의 세 가지 주요 구성 요소를 분리하여 
//각 요소가 서로에게 미치는 영향을 최소화하기 위한 목적을 가지는 소프트웨어 디자인 패턴이다.

//Model : 애플리케이션의 데이터와 비즈니스 로직을 포함한다. 데이터베이스와 상호 작용, 데이터 처리 및 검증과 같은 작업을 처리하게 된다.
//View : 사용자에게 정보를 표시하는 역할을 한다. 사용자 인터페이스와 데이터의 표현을 담당하며 사용자의 요청에 따라 정보를 갱신한다.
//Controller : 사용자의 입력을 받아 처리하고, 적절한 응답을 생성하기 위해 모델과 뷰를 조정한다.


//이 클래스는 View이다
package booksearch.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BookSearchView extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {

		Parent root = null; //FXMLLoader가 일반적으로 Parent 클래스 인스턴스를 반환

		FXMLLoader loader = new FXMLLoader( // fxml 파일을 불러들임
				getClass().getResource("JavaFXBookSearchTableView.fxml")
				);

		try {
			root = loader.load();
		}
		catch (Exception e){
			System.out.println("Main에서 bookfx.fxml 로딩에서 문제가 생겼어용");
		}


		Scene scene = new Scene(root); //Scene을 만들고

		primaryStage.setScene(scene); //Stage에 Scene을 붙여서

		primaryStage.show(); // show해서 올린다.
	}


	public static void main(String[] args) {
		launch(args); //JavaFX 애플리케이션을 시작하기 위해 launch()라는 static 메서드가 호출, main이 entry point가 아님.
					 //JavaFX 애플리케이션을 시작하는 데 필요한 초기화 작업을 수행하고, start() 메서드를 호출하여 UI를 설정	
	}
}


