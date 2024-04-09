package javafxexam;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

// 이 class는 FXML파일에 대한 Event처리를 하는
// 코드가 담긴 class예요!
// 그래서 일반적인 형태의 class가 아니라
// 특별한 interface를 반드시 구현해야 해요!

public class MyController implements Initializable {

	@FXML 
	private Button firstBtn;		
	@FXML 
	private Button secondBtn;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// 여기에 event처리코드가 나와요!
		// 이 객체가 생성되면 자동으로 initialize()가 호출되요!
		System.out.println("Controller 객체가 생성되었어요!");

		// 이벤트 처리코드를 작성하면 되요!
		// 버튼이 클릭됬을때 어떤일을 할지를 지정하면 되요!
		// 버튼에 대한 reference가 있어야 해요!

//		System.out.println(first);
		
		firstBtn.setOnAction((e) -> {
			System.out.println("첫번째 버튼이 클릭클릭!!");
		});

		secondBtn.setOnAction((e) -> {
			System.out.println("두번째 버튼이 클릭클릭!!");
		});
		//		
	}
}
