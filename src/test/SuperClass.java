package test;

public class SuperClass {
	//필드
	int a = 100;

	// 생성자		
	public SuperClass() {
		// 여기서도 마찬가지로 상위클래스인 Object의 인스턴스가 필요.
		super(); //인자가 안들어간 기본 생성자를 만들어야 자동화된 코드에서 문제가 안생긴다. 
		
	}
	//메서드
	public void myFunc() {
		System.out.println("super");
	}
}
