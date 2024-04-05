package thread;

class Sleep_1 extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			
			Thread.sleep(2000);
			
		} catch(Exception e) { }

		for(int i=0;i<300;i++) {
			System.out.println("-");
		}
		System.out.println("<<Thread 1 종료>>");
	}
}

class Sleep_2 extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<300;i++) {
			System.out.println("|");
		}
		System.out.println("<<Thread 2 종료>>");
	}
	
}


public class ThreadSleepTest {
	public static void main(String[] args) {
		Thread t1 = new Sleep_1();
		Thread t2 = new Sleep_2();
		
		t1.start();
		t2.start();
		//메인스레드, t1,t2 세개의 스레드가 돈다.
		try {
			
			t1.sleep(2000); // 이 코드를 수행하는, 현재 수행중인 메인스레드가 sleep. 그 사이에 t1과 t2가 수행중.
							// t1을 재우고싶으면 여기 쓰는거 아님!!!
							// 이렇게 객체 지정해서 sleep 시킬 수 없다. 
							// t1을 재우고싶으면 t1의 run 메서드에 sleep을 넣어야 한다.
		} catch(Exception e) { }

		System.out.println("<<<<main thread 종료>>>>");
		
	}

}
