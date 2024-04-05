package thread;

//방법1 : Thread 클래스 상속 > run메서드 오버라이딩 > main에서 인스턴스(스레드!) 생성
class MyThread extends Thread{
	
	//내가 만든 스레드 실행 코드
	@Override
//	Thread의 run은 일반메서드.(추상x)
	public void run() { 	// thread의 실행코드를 담을 메서드!
		System.out.println("첫번째 스레드");
		super.run();
	}
}
// 방법2 : Runnable 인터페이스 구현 > run메서드 오버라이딩 > 
class MyRunnable implements Runnable{
	//인터페이스는 상수와 추상메서드 가짐 > 구현시 추상메서드 오버라이딩
	//Runnable이 가지는 run은 추상메서드이다!
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("두번째 스레드");
	}
}



public class ThreadTest {
	//main thread
	// 스레드 만들어짐 > main메서드 호출해서 실행
	public static void main(String[] args) {
//방법1
		// 스레드 생성
		MyThread t1 = new MyThread();
		// 스레드 실행
		t1.start();  // 실행코드는 run(), 실행은 start().
		// start()는 non-blocking 메서드이다 : 메서드의 리턴을 기다리지 않고, 아래 코드 계속 실행.
		// start()는 thread scheduler에게 thread를 실행시켜달라고 요청하는 method.
		// thread scheduler는 JVM이 가지고 있는 중재자.
		
		
//방법2
		MyRunnable r = new MyRunnable(); // Runnable 인터페이스를 구현한 객체. thread 아님.
		Thread t2 = new Thread(r); // thread 만들 때 Thread클래스가 등장하긴 해야 함.
		t2.start(); 
		
	} //main 스레드와 내가 만든 스레드가 같이 실행된다. 
	// t1, t2 중 어떤 스레드가 먼저 실행될 지 논리적으로 알 수 없음(start가 non-blocking이라서)
	
	
	
	
	//스레드별로 call stack(Stack)을 따로 가지고 있다. 
	//스레드라 메서드를 호출해서 실행할텐데, 그럼 stack이 별도로 필요하다. 
	// 스레드별로 스택을 별도로 가진다. 
	
	//스레드가 모두 종료돼야 전체 프로그램이 종료된다.
}
