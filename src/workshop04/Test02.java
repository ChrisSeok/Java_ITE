package workshop04;

import java.util.Scanner;

// 5~10까지의 정수형 데이터를 입력 받는다.
//입력 받은 정수 값을 Calc class의 calculate()함수를 이용하여 1부터 입력 받은 숫자까지
//짝수만 더하는 프로그램을 작성 한다
class Calc{
	Calc(){
		
	}
	public int calculate(int data){
		int sum = 0;
		if (data<2){
			System.out.println("2 이상의 수를 입력해야 합니다!");
		}
		else {
			for (int i=1;i<=data;i++) {
				if(i%2 == 0){
					sum+=i;
				}
			}
		}
		return sum;
	}
}



public class Test02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int input= scanner.nextInt();
		Calc c = new Calc();
		System.out.println(c.calculate(input));
	}
}










