package javanetworkexam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

//클라이언트

public class SimpleClient {
	public static void main(String[] args) {


		//클라이언트는 능동적으로 서버 프로세서(ServerSocket)에 접속 시도. 
		//IP와 Port 번호를 알려줘야 한다.
		//IP는 당연히 목적지의 IP주소를 넣어야 한다.
		//지금은 서버가 같은 컴퓨터에 있기때문에, IP주소를 현재 사용하고 있는 컴퓨터를 지칭하는 특별한 IP주소를 사용한다.
		// = 127.0.0.1 
		//혹은 이 IP에 할당된 'localhost' 라는 문자열을 사용할 수 있다.
		//접속을 시도해서 만약 접속이 성공하면 진짜 객체가 생성된다.

		try {
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
