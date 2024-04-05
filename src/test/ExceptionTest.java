package test;

public class ExceptionTest {
	public static void main(String[] args) {
		
		
		System.out.println("예외상황을 발생시켜 보아요.");
		
		// try- catch catch catch ...
		try {
			int result = 10/0; 
			ExceptionTest t = null; // 객체가 가리키는것 없음.
			System.out.println(t.toString()); // 런타임 오류 : null pointer exception 
												// (객체가 없는데 쓰고있는것)
		}
		//하위 Exception 클래스가 위로 오게 작성해야 위에서부터 구체적으로 걸러진다. 
		
		catch(ArithmeticException e){
			// 발생한 예외에 대한 처리코드가 나와요~
			System.out.println("처리완료!");
		}
		
		catch(NullPointerException e) {
			System.out.println("Nullpointer 처리완료!");
		}
		finally { // 무조건 실행이 된다. finally는 optional!
			
		}
		
		
		
		// Exception이 발생하면 해당 Exception에 대한 클래스를 찾아서 Exception 객체를 생성해요.
		// java.lang.ArithmeticExcpetion => 이 Exception 객체에 대한 처리를 해주지 않으면 프로그램이 
		// 비정상 종료된다. 
		// 만약 이 객체를 프로그램적으로 처리하면 Exception handling해서 강제종료를 하지 않는다.
		// 처리는 Try - Catch.
		System.out.println("수행 되나요?");
	}
}





