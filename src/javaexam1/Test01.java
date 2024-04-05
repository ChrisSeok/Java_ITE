package javaexam1;
import java.util.*;

public class Test01 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int number = scanner.nextInt(); // Scanner클래스의 nextInt 메서드로 정수 입력받기.
		
		if (number%2 == 0){
			System.out.println("2의 배수입니다.");
		}
		else {
			System.out.println("2의 배수가 아닙니다.");
		}
				
		scanner.close();
	}
}
