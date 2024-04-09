package javafxexam;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.event.*;
//ctrl shift +O : 자동 import
public class JavaFXExample extends Application{


	@Override
	public void start(Stage primaryStage) throws Exception { 
		// 화면구성		

		//1. Pane 이라고 표현되는 레이아웃을 만든다.
		// 여러 종류의 Pane이 있는데, 그 중 하나를 이용하면 된다.
		// Pane 종류마다 버튼같은 component를 배치시키는 방법이 다르다.
		StackPane root = new StackPane();

		//2. 화면에 보여줄 요소를 생성한다.
		Button btn = new Button();
		btn.setText("클릭하세용");



		//버튼이 클릭되면 무슨 일을 할지 코드로 작성해야 한다.
		//자바의 even model은 delegation model을 이용한다.
		//이벤트처리를 위임한다는 의미로 delegation표현.
		// 버튼을 클릭하면 버튼이 event source가 된다.
		// event source는 이벤트가 발생한 객체를 지칭한다 -> 버튼이 된다
		// 이벤트의 처리를 event source가 직접X, 별도의 객체 이용 = Listener 객체
		// Listener 객체 안에는 이벤트를 처리하는 메서드인 handler가 있다.
		// event source에 Listener를 부착시키는 과정이 필요 > Action이라는 event 사용
		// Action이라는 이벤트는 마우스클릭, 입력상자에서 enter키 입력을 저장한는 event.

		//버튼 (event source)에서 Action Event가 발생했을 때 처리하는 
		//Event handler객체를 만들어서 이벤트 처리를 할거에용
		//먼저 리스너 객체를 만든다 - 어떤 이벤트를 처리하냐에 따라 리스너 객체의 종류가 다르다.
		//Action이벤트를 처리하려면 ActionListener가 필요.

//		btn.setOnAction(new EventHandler<ActionEvent>() {  //EventHandler는 interface이다.
//														//객체를 만드려면 추상메서드를 오버라이드 해줘야 함.	
//			@Override
//			public void handle(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				System.out.println("힘드러용");
//			}
//		});

		//람다식으로 축약  
		
		// 오버라이딩 해야하는 메서드가 단 하나라서 이렇게 축약할 수 있는거
		btn.setOnAction((e)->{ 
			System.out.println("힘드러용");
		});


		//3. Pane위에 표현할 component를 위치시킨다.
		root.getChildren().add(btn);

		//4. Scene을 생성한다.  (Pane을 가지고)
		Scene scene = new Scene(root, 300, 250); // 창의 가로,세로 길이

		//5. Stage에 Scene을 설정하면 되용
		primaryStage.setTitle("첫 화면입니다");
		primaryStage.setScene(scene);
		//		stage > scene > pane

		primaryStage.show(); // 눈에 보이게
	}

	public static void main(String[] args) {
		launch(args); // 창을 띄우는 메서드
	}
}






