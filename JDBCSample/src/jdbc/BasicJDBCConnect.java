package jdbc;
//1. 프로젝트 Properties > build path에 드라이버 클래스를 포함시키기

import java.sql.DriverManager;

public class BasicJDBCConnect {

	public static void main(String[] args) {
		
		try {
			//2. JDBC Driver를 프로그램 안으로 로딩해야 해용
			//드라이버 로딩...그냥 이렇게 합니다
			Class.forName("com.mysql.cj.jdbc.Driver");   // JDBC 드라이버 로딩. //눕는 글씨의 함수는 static함수이다.
			System.out.println("드라이버 로딩 성공성공!");
			
			//3. 드라이버 로딩이 성공하면 실제 데이터베이스에 접속한다.
			// 접속하려면 3가지 정보가 있어야 해요 - 데이터베이스 계정 ID, PW, 접속하려는 DB에 대한 URL(=JDBC URL).
			String myId = "root";
			String myPw = "seok99";
			String JDBC_URL = "jdbc:mysql://localhost:3306/employees?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true"; //protocol은 jdbc:mysql이다.
														    //DB가 있는 컴퓨터의 IP주소 : localhost
														   // mysql db 기본 port번호 3306 (=mysql 서버 자체), /내가사용할 DB지정
														  //그 뒤 ?부터는 노션 복붙
			DriverManager.getConnection(JDBC_URL,myId,myPw);
			System.out.println("DB 접속 성공성공!");
		
		} 
		catch (Exception e) {
			System.out.println("먼가 잘못됐어용~");
		}  

	}
}
