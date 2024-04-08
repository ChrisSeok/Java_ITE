package thread;
//
//class MyThreadRunnable implements Runnable{
//
//}

public class DaemonThreadTest implements Runnable{

	static boolean autoSave = false; // 클래스 필드를 아래의 main 메서드에서 사용을 위해선 인스턴스 생성해야 함 or static 키워드
	
	
	//데몬스레드를 파생시키는 메인스레드
	public static void main(String[] args) {  // main 메서드는 main 스레드가 아니다. 
		//메인 스레드는 따로 생성돼서 main메서드를 콜 할 뿐임.
		Thread t = new Thread(new DaemonThreadTest());
		t.setDaemon(true); // false이면 일반스레드, true이면 데몬스레드.
		// setDaemon을 true로 설정 안하면, 메인스레드가 끝나도 자동저장하는 스레드가 안끝남.

		t.start(); // Runnable 상태로 가서 스케쥴러에 의해 언젠가는 동작된다. //아래의 run 메서드 실행
		
		//Daemon 스레드와 메인스레드가 동시에 수행됨, autoSave 변수를 공유.
		for(int i=0;i<10;i++) {
			try {
				Thread.sleep(1000); // main thread가 sleep
				// t로 인스턴스 지정해서 sleep x, "현재 수행되고 있는" 스레드를 재운다. 
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println("i의 값은:"+i);
			
			if(i==5) {
				autoSave = true;
			}
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) { // 무한루프, 데몬스레드기때문에 주 스레드가 종료되면 거기서 발생한 데몬스레드도 종료된다.

			try {
				
				Thread.sleep(3000); // 스레드를 3초간 재울게요. sleep은 예외발생 가능성이 있어서 예외처리 해줘야 함
				// 클래스 안에서 클래스명.메서드가 나오면 ..this를 왜 안쓰지?
				// 인스턴스 지정해서 sleep x, "현재 수행되고 있는" 스레드를 재운다. 
			}catch(Exception e) {
				System.out.println("오류");
			}
			
			if(autoSave){
				System.out.println("자동저장 되었어요!!!!");
			}
		}
	}
}
