package test;

class MyException extends Exception{

}
public class MyExceptionTest {

	public static void main(String[] args) {
		
		
		try {
			throw new MyException(); // exception객체 생성, 생성 후 실제로 발생시키기 위해 던지기.
// (자바가 제공하exeption의 경우 javac가 자동으로 던져줌
			
		}catch(Exception e) {
			System.out.println("사용자 정의 오류 발생!");
		}
	}
}
