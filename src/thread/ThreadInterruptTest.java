package thread;
import javax.swing.*; // java extension의 gui를 위한 swing 사용


class MyThread_d extends Thread{


	// 인터럽트 걸리지 않으면 숫자를 계속 찍는 스레드. 10~0까지.
	@Override
	public void run() {
		int i = 10;
		while(i != 0 && !isInterrupted()) {	// interrupt 호출됐으면 true > while탈출
						// this 생략된
			System.out.println(i--); 
			//			for(long k=0; k<25000000000L;k++) ; //busy waiting(시간끌기) 내용 없어서 {}도 없음
			//				
			//		}
			try {

				Thread.sleep(2000);  // 인터럽트 발생하면 sleep중에 exception발생 > catch간 후 while조건, 튕겨나가서 종료

			} catch(Exception e) { 
				interrupt(); // interrupted state 값이 false로 셋팅되므로 
							//다시 인터럽트 걸어서 true값으로 바꿔주고 조건 튕겨나가야 한다.
			}
		}
	}

//	System.out.println("카운트가 종료되었어요"); 
}


public class ThreadInterruptTest {
	public static void main(String[] args) {
		Thread t = new MyThread_d();
		t.start();

		//메인메서드 실행하고 바로 인터럽트 걸 수 없으니 약간의 시간지연을 위해 Swing을 이용해봐요!
		String input = JOptionPane.showInputDialog("값을 입력하세요!"); // blocking 메서드라서 메인이 여기서 멈춰있는다. 값 입력할 때 까지!
		System.out.println("입력된 값은 : " + input);

		t.interrupt();
		// 메인메서드를 실행하면 두 스레드가 동시에 실행하다가, 값을 입력하면 interrupt가 실행되고 t스레드가 종료된다.
	}
}









