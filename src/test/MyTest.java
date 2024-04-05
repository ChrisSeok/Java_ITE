package test;
import java.util.*; // 외부 패키지의 클래스를 import, 이로써 클래스 사용시마다 풀 패키지명 없이 사용 가능.

public class MyTest {
	
//	static block
//	해당 클래스 사용 이전에 수행되야하는 코드. 라이브러리/데이터 로딩 등. 전처리적인 처리가 필요할 때.
	static {

	}
	
	
//	필드나 메서드를 사용하려면 인스턴스가 있어야 한다.
//	인스턴스가 만들어지기 전까지 메모리에 a라는 공간이 없다.
	
//	필드들 
	public int a = 100;  //인스턴스 변수. 인스턴스가 있어야 사용할 수 있는 변수.
					// 메모리의 Heap영역에 할당된다.
	static int b = 200; // static → Heap 아닌 Method Area에 생성됨. 
	
	private int c = 300; // private → 클래스 내부에서만 접근 가능.
	
//	생성자들
	public MyTest(){ // public으로 접근제어자 설정하면 다른 패키지에서도 사용할 수 있다. 접근제어자 없으면 default이고 외부사용 불가.
		
	}
	// 생성자 오버로딩 - 이름은 같고 인자 개수,타입 다르게.
	MyTest(int k){ 
		
	}
	
	
//	메서드들
	public static void main(String args[]) { // static이 붙어서 인스턴스 없이도 메서드를 call 할 수 있다!
		
		MyTest obj = new MyTest(); // 사실 obj는 레퍼런스 변수이고 우변이 객체이다. But 관용적으로 obj를 객체라고 부른다. 
//		obj라는 레퍼런스 변수를 이용해서 Heap 영역에 생성된 인스턴스를 사용할 수 있다.
//		레퍼런스 변수를 이용해 인스턴스를 사용할 때 dot operator (.)를 사용한다.
		System.out.println("a의 값은:" + obj.a); // a라는 필드를 사용하려면 인스턴스가 있어야 한다.
		
		int k = 200; //지역변수.  (메서드 안에 선언, stack 영역에 공간이 잡힘)(stack은 아래에서부터 쌓인다)
		
		
		
	} 
}
