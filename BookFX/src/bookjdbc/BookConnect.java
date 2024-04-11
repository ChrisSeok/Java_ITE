package bookjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookConnect {

	// 0. 프로젝트 Properties > build path에 드라이버 클래스를 포함시키기

	public static void main(String[] args) {

		try {
			//1. JDBC Driver를 프로그램 안으로 로딩해야 해용
			//드라이버 로딩...그냥 이렇게 합니다
			Class.forName("com.mysql.cj.jdbc.Driver");   // JDBC 드라이버 로딩. //눕는 글씨의 함수는 static함수이다.
			System.out.println("드라이버 로딩 성공성공!");

			//2. 드라이버 로딩이 성공하면 실제 데이터베이스에 접속한다.
			// 접속하려면 3가지 정보가 있어야 해요 - 데이터베이스 계정 ID, PW, 접속하려는 DB에 대한 URL(=JDBC URL).
			String myId = "root";
			String myPw = "seok99";
			String JDBC_URL = "jdbc:mysql://localhost:3306/library?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true"; //protocol은 jdbc:mysql이다.
			//DB가 있는 컴퓨터의 IP주소 : localhost
			// mysql db 기본 port번호 3306 (=mysql 서버 자체), /내가사용할 DB지정
			//그 뒤 ?부터는 노션 복붙

			Connection con = DriverManager.getConnection(JDBC_URL,myId,myPw);
			System.out.println("DB 접속 성공성공!");

			//3. Connection 객체를 얻었으면 이제 SQL 쿼리를 작성해서 전달해야 하는데, 이 SQL쿼리를 실어서 보낼 객체가 하나 필요.
			//이 중 우리는 PreparedStatement를 사용할거에용

			String sql = "SELECT * FROM book WHERE btitle LIKE '%여행%'";
			PreparedStatement pstmt = con.prepareStatement(sql); // 이미 statement가 쿼리를 가지고 있음 > 실행시 달랑 메서드(executeQuery)만 호출.

			ResultSet rs = pstmt.executeQuery(); //rs는 컬럼명을 포인트. 
			while(rs.next()) {
				System.out.println(rs.getString("btitle")+"\n");  // 현재 rs 위치에서 "first_name" 칼럼을 찾아, 그 안에 있는 내용을 문자열로 리턴.
			}
			
			rs.close();
			pstmt.close();
			con.close();
		} 

		catch (Exception e) {
			System.out.println("먼가 잘못됐어용~");
		}  

	}
}



