package javaexam1;
import java.util.*;
//argument로 1자리 정수형(1~9)값을 2개 입력 받아 4칙 연산 결과를 출력 한다.
//입력 값은 모두 int 형으로 처리 한다.
public class Calc {

	public Calc(){	
		
	}
	
	public int sum(int a, int b) {
		return a+b;
}

	public int subtract(int a, int b) {
		return a-b;
}

	public int multiply(int a, int b) {
		return a*b;
	}

	public int divide(int a, int b) {
//		분모 b가 0 이거나 0보다 작으면 0을 리턴
		if (b == 0 || b<0) {
			return 0;
		}
		else{
			return a/b;
		}
	}
}


















