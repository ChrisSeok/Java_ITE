//package는 관련있는 클래스들을 하나로 묶는 논리적인 단위. 물리적으로는 폴더로 표현된다.
// 하나의 자바파일 안에 public이 붙은 class는 하나만 존재 할 수 있다.
//만약 public class가 존재하면, 파일명은 반드시 public class의 이름으로 설정해야 한다.

package test;

public class HelloWorld {
// 필드들
	int age;

//	생성자들 (필수!!!) 
//	생성자의 이름은 클래스 이름과 같다. 모양은 메서드와 유사하지만 리턴타입 존재X.
//	만약 생성자를 직접적으로 명시 X → javac compiler가 소스코드를 byte code로 컴파일할 때 
//	default constructor를 자동으로 삽입한다.
//	default constructor는 인자도 없고 하는일도 없는 생성자.
//	생성자는 반드시 작성해주세요!

	public HelloWorld() {
//		주로 인스턴스의 초기화를 담당.
	}

//	메서드들
	public void sayHello() {

	}

//	프로그램의 entry point가 필요	
	
//	class Loader가 얘를 호출해서 main부터 실행되게 한다.
	public static void main(String args[]) {
		System.out.println("Hello World!");
		// 인스턴스를 만들어 보아요 (Heap 영역에 만들어짐)
		// new 생성자
		// a는 Reference Variable이다. Heap영역의 인스턴스 시작주소를 가지고 있기 때문.
		
		HelloWorld a = new HelloWorld();
	}

}
