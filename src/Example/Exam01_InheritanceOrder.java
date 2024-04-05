package Example;

public class Exam01_InheritanceOrder extends SuperClass {
	int c = staticCall("6");
	static int d = staticCall("7");
	
	public Exam01_InheritanceOrder() {
		super(100); // super();자동으로 실행된다. 
		staticCall("8");
		super.myFunc();
	}
	public void myFunc() {
		System.out.println("9");
	}
	public static void main(String[] args) {
		System.out.println("10");
		//자식 or 부모 어떤 생성자 호출?
		SuperClass obj = new Exam01_InheritanceOrder(); // 객체는 outer(자식), 타입은 inner(부모) > outer에만 있는 요소는 사용x 
		obj.myFunc();
	}
}
