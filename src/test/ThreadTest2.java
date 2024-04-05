package test;

public class ThreadTest2 {
// annotation으로 동시성 제어
// synchronized 키워드 함수 앞에 붙여서 동시성 제어.
	
	public static void main(String[] args) {
	//아래의 3가지 다 같은 표현이다 !! 축약되는 과정.
		
		// Runnable 구현 클래스 따로 만드는 대신 Thread 생성자 안에 Runnable 객체 바로 넣음
		Thread t = new Thread(new Runnable() { //인터페이스는 인스턴스 생성이 안됨(추상메서드 포함하니까), 근데 이렇게 오버라이딩 해주면 됨!
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("오버라이딩 해서 이제 실행 가능!");
			}
		});
		
		
		new Thread(new Runnable() { //인터페이스는 인스턴스 생성이 안됨(추상메서드 포함하니까), 근데 이렇게 오버라이딩 해주면 됨!
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("오버라이딩 해서 이제 실행 가능!"); //스레드 생성시 이 내용만 바뀜(오버라이딩 할게 run뿐임) > 축약함
			}
		}).start(); // 레퍼런스 만들지 말고 객체 바로 start로 실행 
		
		
		//축약형
		new Thread(()->{
			System.out.println("실행내용");
		}).start();
		
	}
}
