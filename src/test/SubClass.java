package test;

public class SubClass extends SuperClass{ 	// SuperClass의 자식클래스
	//추가적인 필드와 메서드를 정의하면 된다.
	
	int a = 5000; // SuperClass의 a와 영역이 다르기 때문에 conflict 일어나지 x. (필드 재정의=Shadow)
	int c = 500;
	
	public SubClass() {
		this(10);
	}
	public SubClass(int k) {
		//현재 클래스가 최상위 클래스인지 확인 후, 아니라면
		//상위클래스의 인스턴스를 만드는 코드가 들어가야 한다.
//		SuperClass();
		super(); // 상위 클래스를 찾아서 인자가 없는 생성자를 실행하세요. 이것도 javac가 자동으로 넣어준다.
		
	}
		
	//annotation - 알림
	public void myFunc(){
		System.out.println("여기는 subclass");
	}
	
	
}
