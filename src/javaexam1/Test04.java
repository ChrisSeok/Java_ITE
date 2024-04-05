package javaexam1;
//1부터 100까지의 모든 정수들의 합과 평균을 구하는 프로그램을 작성 한다.
//단, while문이나 do while문을 이용하여 작성 한다.
public class Test04 {
	public static void main(String[] args) {
		int i = 1;
		double sum = 0;
		double avg = 0;
		while (i<101) {
			sum +=i;
			i++;
		}
		System.out.printf("합계:%.1f\n",sum);
		System.out.printf("합계:%.1f",sum/100);
		
	}
}
