package another;
import test.*;

public class SecondClass {
	public static void main(String args[]) {
		
		MyTest a = new MyTest();	//풀패키지명으로 명시 or Import 구문 쓰기
		System.out.println(a.a); //100이라는 값 사용
		
	}

}
