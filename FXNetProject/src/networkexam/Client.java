package networkexam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {

		try {
			System.out.println();
			Socket s = new Socket("localhost",5555); //얘도 예외처리 해줘야 한다.
			//접속 성공하면 진짜 객체가 만들어지고, 실패하면 null이 들어간다.
			//socket만 있으면 데이터통신 할 수 있어!
			
			System.out.println("접속 성공성공!");
			
			//데이터를 받기 위한 InputStream 필요.
			InputStreamReader isr = new InputStreamReader(s.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			String msg = br.readLine();		
			System.out.println(msg);
			
			
		} catch (Exception e) {
		}//IP, port번호 인자로.
	}

}
