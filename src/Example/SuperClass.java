package Example;

public class SuperClass {
	static int staticCall(String msg) {
		System.out.println(msg);
		return 0;
	}
	int a = staticCall("1");
	static int b = staticCall("2");
	
	public SuperClass() {
//		super(); 가 생략되어있음
		staticCall("3");
	}
	public SuperClass(int i) {
		this();
		staticCall("4");
	}
	public void myFunc() {
		System.out.println("5");
	}
}
