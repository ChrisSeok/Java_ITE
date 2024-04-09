package networkexam;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

//fxml의 컴포넌트를 가지고 무슨 일을 할지 정해주는 역할

public class Server implements Initializable{
	// 이벤트 처리코드를 작성하면 되요!
	// 버튼이 클릭됬을때 어떤일을 할지를 지정하면 되요!
	// 버튼에 대한 reference가 있어야 해요!

	//Annotation 필수 !!!
	@FXML private Button servstart;	
	@FXML private TextArea textarea;	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		servstart.setOnAction((e) -> {

			Platform.runLater(() -> {
				textarea.appendText("Server 객체가 생성되었어요!\n");
			});

			try { // 기존의 누군가가 포트번호를 쓰고있으면 오류발생의 여지가 있으므로 exception처리 필수!

				ServerSocket serversocket = new ServerSocket(5555); 
				Platform.runLater(() -> {
					textarea.appendText("Server 소켓이 생성되었어요\n");
				});
				Socket s = serversocket.accept(); //일단대기 (클라이언트가 접속할때까지)


				//일단 아래 코드는 실행 안됨...

				//							System.out.println("accept()가 풀렸어용");
				//			
				//							//이렇게 얻어진 socket에 대해서 Stream객체를 얻어냄
				//							PrintWriter out = new PrintWriter(s.getOutputStream());
				//							//이 통로를 통해 데이터를 쏴준다!
				//							out.println("이것은 소리없는 아우성 - 서버가 전달했어요!");
				//							//			PrintWriter는 효율을 위해서 내부 buffer를 가지고 있어용
				//							//			명시적으로 flush를 이용해 데이터를 전달해야 한다. 안그러면 buffer가 다 찰 때까지 전달 안됨.
				//							out.flush();

			} catch (Exception x) {
				System.out.println("Server 에러발생");
				System.out.println(x);
			}

		});
	}
}

//server, servercontroller 
//client, clientcontroller




