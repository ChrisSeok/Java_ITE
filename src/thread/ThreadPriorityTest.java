package thread;
//우선순위 숫자 클수록 높음.
//setPriority로 우선순위를 설정한다 해서 생각대로 동작하지 않는다. 로직을 짜서 해결한다.
public class ThreadPriorityTest {
	public static void main(String[] args) {
		
		Thread t1 = new Thread(()->{      // thread 축약 생성
			for(int i=0; i<10;i++) {
				System.out.println(Thread.currentThread().getName());
			}
		});
		t1.setPriority(1);
		
		
		Thread t2 = new Thread(()->{      // thread 축약 생성
			for(int i=0; i<10;i++) {
				System.out.println(Thread.currentThread().getName());
			}
		});
		t2.setPriority(2); // 얘가 먼저 실행될것 같지만 아니다 ~~~~
		
		t1.start();
		t2.start(); // 두 스레드가 Runnable 상태가 됨, thread scheduler
	}
}
