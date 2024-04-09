package javafxexam;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	Button btn;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 여기부터 시작되요! 화면구성을 하면되요!
		// FXML을 이용하는게 아니라 코드로 화면을 구성할 꺼예요!
		// 1. Pane이 필요해요!
		//    이번에는 BorderPane을 이용해보아요!(화면을 5개의 영역으로 분할)
		//    동서남북중앙으로 분할(method를 통해서 UI의 위치를 지정해요!)
		BorderPane root = new BorderPane();
		root.setPrefSize(300, 300);		
		// 2. 이 Pane에 필요한 UI 요소들(버튼같은거)을 생성해서 배치시켜요
		btn = new Button("새로운 창을 띄워보아요!");
		btn.setPrefSize(300, 50);
		
		
		btn.setOnAction(e -> {
			// 버튼을 누르면 새창을 띄울꺼예요!
			// Stage객체를 만들어서 show하면 새로운 창이 떠요!
			// 이건 나중에 구현해요!
			MyStage stage = new MyStage();
			stage.show();
		});
		
		
		root.setBottom(btn);  // 버튼을 화면아래에 붙일 수 있어요!		
		
		// 3. 이렇게 만든 Pane을 이용해서 Scene을 생성
		Scene scene = new Scene(root);		
		// 4. Stage에 Scene을 부착
		primaryStage.setScene(scene);
		// 5. Stage를 show해요!
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}


