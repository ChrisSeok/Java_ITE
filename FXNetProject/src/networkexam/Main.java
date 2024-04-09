package networkexam;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafxexam.MyStage;

public class Main extends Application{

	@Override
	public void start(Stage arg0) throws Exception {
		ServStage stage = new ServStage();
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}


//server, client 따로 실행
//한 UI에 한명의 입력값만 - 채팅의 경우엔 한명의 입력값이 다른 client창에 뜨게 하기.