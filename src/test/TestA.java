package test;

public abstract class TestA { // 추상클래스: 이름, 인자만 선언 (define은 안함)
//필드
	private int age;
	private String name;
	
//생성자
	public TestA() { // 아무 일도 안하고 인스턴스를 만드는 역할만 한다. 	
	}

	public TestA(int age, String name) {
		super(); // 생성자는 상위클래스의 생성자 콜 필수! 안적어도 자동으로 삽입됨.
		this.age = age;
		this.name = name;
	}
	
//메서드
	public void myFunc() { 
		//메서드 정의
		
	}
	public abstract void sayHello(); // 메서드 선언만, 어떻게 동작할지 몰라도 이런게 있다라는~ = 추상메서드
}

//원래는 한 파일당 클래스 하나, But 연습용이기 땜에 한 파일에 여러 클래스 정의ㅎㅎ (일반적이진 않음)

class MySubClass extends TestA{	  //상속만 받을 경우 얘도 추상클래스이므로 abstract 키워드 붙여야 함.

	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		
	} 
	
}
