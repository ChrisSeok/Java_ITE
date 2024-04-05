package javaexam1;

import java.util.Scanner;

public class Test02 {
//	두 수의 곱이 한자리 수 인지 두자리
//	수 인지를 출력
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	int number1 = scanner.nextInt();
	int number2 = scanner.nextInt();
	int result = number1 * number2;
	String sresult = Integer.toString(result);
	
	// sresult의 length 가 1인지 2인지
	if (sresult != null) {
		int len = sresult.length();
		
		if (len==1) {
			System.out.println("한자리 수 입니다.");
		}
		else if(len ==2){
			System.out.println("두자리 수 입니다.");
		}
	
}
}
}



