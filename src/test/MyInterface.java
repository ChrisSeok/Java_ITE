package test;

public interface MyInterface {
//필드
// 상수만 가능
// 추상 > 인스턴스를 생성할 수 없음 > Heap 할당 안됨, Method Area로 요소를 올려야 사용가능 > static으로만 선언.
	public static final int MY_NUM = 100; 
	// 'public static final' 키워드는 생략 가능 (항상 붙으니까)
	int MY_NUM1 = 200;
//메서드
	public abstract void myFunc(); // 인터페이스 안에는 추상메서드만 들어간다 !! 
	void myFunc1();  				//'public abstract' 키워드는 생략 가능.
}

//class MyClass implements MyInterface{ //클래스끼리 상속이 가능하듯이, 인터페이스끼리도 상속 가능하며, 이때도 extends 키워드를 쓴다. 
//// 인터페이스를 클래스로 구현할 때만 implements 사용(다를땐 implements로 생각)
//}