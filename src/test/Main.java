////프로그램 entry point 위한 더미 메소드
//
//
//package test;
//// Object 상속을 굳이 명시하지 않는 이유는, 상속이 없을 경우 Object 클래스 상속이 자동으로 들어가기 때문. 
//public class Main extends java.lang.Object{ // javac가 java.lang.은 자동으로 넣어준다
//	
//	public static void main(String[] args) {
//		// 인스턴스 생성
////		SubClass sub = new SubClass();
//		// Is-a 관계로 Subclass 대신 SuperClass 객체를 생성 > 변수 c는 이제 사용 못함.
//		SuperClass sub = new SubClass(); // Is - a 관계로 인해서 객체를 다양한 형태로 사용가능 = 다형성
////		System.out.println("c의 값은: " + sub.c);
//		
//		
//		
//		SuperClass sub1 = new SubClass();
//		System.out.println("a의 값은: " + sub1.a); // 필드는 SuperClass를 제대로 access되는데,
//		sub1.myFunc();  // 메서드는 오버라이드 된 경우 무조건 오버라이딩 된 메서드를 찾아간다. 
//		// 레퍼런스가 바뀌어도 오버라이딩 된 메서드를 찾아감  = 다이나믹 바인딩
//	}
//}
//
//
//
//
//
//
