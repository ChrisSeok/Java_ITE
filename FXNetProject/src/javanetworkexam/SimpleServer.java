package javanetworkexam;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//서버

public class SimpleServer {

	public static void main(String[] args) {

		// 1. ServerSocket 객체를 생성한다. (서버가 하는 일: 클라이언트의 접속을 기다림)
		// ServerSocket 생성시 client가 접속해서 들어옴
		//Port번호를 명시해야 해요
		//0~65535의 값을 사용해야 해요
		//0~1023까지는 well known port라고 해서 이미 용도가 정해져있음 - 그 이후의 값을 써야행
		//하나의 컴퓨터에서 동작하는 프로그램이 사용하는 Port번호는 Unique해야 한다!
		try {
			ServerSocket serversocket = new ServerSocket(5555); 
			// 기존의 누군가가 포트번호를 쓰고있으면 오류발생의 여지가 있으므로 exception처리 필수!

			System.out.println("서버소켓 객체 생성");

			Socket s = serversocket.accept(); //일단대기 (클라이언트가 접속할때까지)
			//일단 아래 코드는 실행 안됨...
			System.out.println("accept()가 풀렸어용");

			//이렇게 얻어진 socket에 대해서 Stream객체를 얻어냄
			PrintWriter out = new PrintWriter(s.getOutputStream());
			//이 통로를 통해 데이터를 쏴준다!
			out.println("이것은 소리없는 아우성 - 서버가 전달했어요!");
//			PrintWriter는 효율을 위해서 내부 buffer를 가지고 있어용
//			명시적으로 flush를 이용해 데이터를 전달해야 한다. 안그러면 buffer가 다 찰 때까지 전달 안됨.
			out.flush();
		} catch (Exception e) {
		}

	}
}

//textarea component > 서버가 보내주는 데이터 위에서부터 한줄씩 찍기
//스레드 사용
//button > 서버소켓 시작
//서버가 보내준 메세지 출력

//클라이언트 버튼 > 서버로 갔다가 클라이언트로 돌아와 뜨게(에코 프로그램)
//끝 버튼 누를때까지 계속 돌게 (끝 - 네트워크 끊음)






