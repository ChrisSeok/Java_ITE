package jdbc;

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
				//이것은 SQL Query를 가지고있는 statement
				String sql = "select * from employees where gender = 'F'";
				PreparedStatement pstmt = con.prepareStatement(sql); // 이미 statement가 쿼리를 가지고 있음 > 실행시 달랑 메서드(executeQuery)만 호출.
				
				//4. 이렇게 전달할 Statement를 만들었으면, 이제 실행하면 되용 -> sql query를 실행할 수 있어요!
				//그런데 실행하려는 SQL이 만약 select 계열이면 => (결과 레코드 집합을 가져오는거면) 
				
				//pstmt.execute();
				
				//execute()는 SQL 문을 실행하고 실행 결과를 반환하지 않는 반면, executeQuery()는 SELECT 문을 실행하고 ResultSet 객체를 반환합니다.
				
				ResultSet rs = pstmt.executeQuery(); //rs는 컬럼명을 포인트. 
				
				//5. ResultSet을 이용해서 데이터 추출(로직처리)
					//next() 메서드로 결과집합의 row를 한 칸 내려감, 
					//get()으로 칼럼 선정
				rs.next();
				String firstName = rs.getString("first_name"); // 현재 rs 위치에서 "first_name" 칼럼을 찾아, 그 안에 있는 내용을 문자열로 리턴.
				System.out.println(firstName);
				
				
				//6. 사용한 자원의 반납
				//사용한 여러 자원들을 close시켜서 정상종료를 해줘야 해요! (리소스 해제)
			    // 생성과 반대순서로 close
				rs.close();
				pstmt.close();
				con.close();
			} 
			
			catch (Exception e) {
				System.out.println("먼가 잘못됐어용~");
			}  

		}
	}

