package networkexam;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//fxml 파일을 로드해서 scene 생성하고 stage에 부착하는 역할

public class ServStage extends Stage{
	public ServStage() {
		// 당연히 여기에도 Pane이 있어야 해요!
		// Pane안에 여러개의 UI Component를 배치
		// 이건 FXML에서 가져올꺼예요.
		Parent root = null;
		FXMLLoader loader = new FXMLLoader(
				getClass().getResource("serverDisplay.fxml"));

		try {
			root = loader.load();			
		} catch (Exception e) {
			System.out.println("root load error에용");
			System.out.println(e);
		}

		// 이런 Pane을 가지고 Scene을 생성
		Scene scene = new Scene(root); //이 라인에서 오류...

		// 이 Scene을 Stage에 부착!
		this.setScene(scene);
	}
}
