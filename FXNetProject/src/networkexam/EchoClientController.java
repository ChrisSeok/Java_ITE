package networkexam;
//공용객체를 만들어서 스레드를 몰아넣는다. 스레드끼리 존재를 알아야(via 공용객체) 메세지를 다른 창에 띄울 수 있다.


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;



public class EchoClientController implements Initializable{
	@FXML private TextField userID;
	@FXML private TextField userMsg;
	@FXML private Button sendMsg;
	@FXML private Button closeBtn;
	@FXML private TextArea messageBox;

	private Socket s;
	//통로 
	private BufferedReader br;
	private PrintWriter pw;
	String receiveMsg = null;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		//시작할 떄 서버 접속하는 코드
		try {

			s = new Socket("localhost",4444);
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			pw = new PrintWriter(s.getOutputStream());


		}catch (Exception e) {
			// TODO: handle exception
		}

		//버튼 누르면
		sendMsg.setOnAction(e->{
			String msg = userID.getText() + " > "+ userID.getText();
			pw.println(msg);
			pw.flush(); 	// PrintWriter 내부 버퍼가 가지고 있기때문에 flush 해줘야 함
			try {
				receiveMsg = br.readLine();   // blocking 메서드 : 입력을 받을 때까지 멈춰있음
			} catch (IOException e1) {
				e1.printStackTrace();
			} 

			Platform.runLater(() -> {
				messageBox.appendText(receiveMsg);

			});
		});
	}
}











