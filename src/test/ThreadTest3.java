//package test;
//
////방법①①
//class MyThread1 extends Thread{ // Thread클래스가 private필드로 name을 가지고 있다. 
//								// Thread의 생성자의 인자로 name을 주면 name을 설정할 수 있다.
//	
//	public MyThread1(String name) {
//		super(name);
//	}
//	
//	@Override
//	public void run() {
//		for(int i=0;i<10;i++) {
//			System.out.println(this.getName()); // this : Thread객체
//		}
//	}
//}
//
//
////방법②②
//class MyRunnable implements Runnable{
//	
//	@Override
//	public void run() {
//		for(int i=0;i<10;i++) {
//			// 이부분 복습 !!!
//			System.out.println(Thread.currentThread().getName()); //이클립스의 누운글자 = static
//		}
//}
//
//
//public class ThreadTest3 {
//	
//	public static void main(String[] args) {
//		//객체들 먼저 만들고 start 해보면 t2먼저 실행될 수 있다 (실행 할 때마다 달라짐) > 순서 알 수 없음
//		MyThread1 t1 = new MyThread1("홍길동");
//		t1.start();
//		
//		MyRunnable r = new MyRunnable();
//		Thread t2 = new Thread("신사임당")
//		t2.start();
//		// 상태전이
//		// start() > Runnable 상태로 객체들이 들어옴 > Thread scheduler가 하나 선택 
//		// > 실행을 위해 core를 붙임 > Running 상태 > run이 끝나면 Dead상태 > 스레드 종료, 한 번 종료된 스레드는 다시 살릴 수 없다.
//		// 순서, 실행걸리는 시간 등을 알기 어려움 > 메서드로 제어해줘야 한다.
//	}
//}
