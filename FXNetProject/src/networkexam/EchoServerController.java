package networkexam;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class EchoServerController implements Initializable{
	@FXML private Button startBtn;
	@FXML private TextArea messageBox;
	
	private void printMsg(String msg) { 
		Platform.runLater(()-> { //바로바로 실행이 안되기 때문에 원하는 시점에 내용을 출력하려면 스레드를 별도로 만든다.
								// Runnable 객체 축약
			messageBox.appendText(msg + "\n");
		});
	}
		
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//이벤트 처리코드
		startBtn.setOnAction(e ->{
			printMsg("서버가 시작되었어요");
			
			try {
				//포트(자원)을 사용중 > 종료시 포트를 release 해줘야 함. GC에게 맡기면 좀 그래;
				ServerSocket server = new ServerSocket(4444); 
				Socket s = server.accept(); //지금 실행되고 있는 스레드가 멈춘다. (버튼에 대한 처리를 가지고 있는 화면.)
				//server.accept()에 의해 thread가 block된다!
				//이 경우 화면 UI thread가 block > 화면을 사용할 수 없어용
				// -> accept 부분을 별도의 스레드로 만들어서 맡긴다!!
				
			} catch (IOException e1) {
				e1.printStackTrace();
			} 
			
			});
			
		//이제 서버를 기동시키는 코드가 나와야 해요!
		
		//서버는 제일 먼저 서버 Socket을 생성해야 한다. 
		
	
		
		
	}
}













