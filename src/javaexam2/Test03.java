package javaexam2;
import java.util.*;

//주어진 String 데이터를 “,”로 나누어 5개의 실수 데이터들을 꺼내어 합과 평균을 소수점 3자리까지 구한다.
//단, String 문자열의 모든 실수 데이터를 배열로 만들어 계산 한다.
public class Test03 {
	public static void main(String[] args) {
		String str = "1.22,4.12,5.93,8.71,9.34";
		StringTokenizer st = new StringTokenizer(str,",");
		double data []= new double[5]; 
			int len = data.length;
			double sum = 0;
			double avg;
			 // StringTokenizer를 이용하여 데이터를 꺼낸다.

			 
			 for(int i=0; st.hasMoreElements();i++){
			// 배열에 실수 데이터를 넣는다.
				 String temp = st.nextToken();
				 data[i] = Double.parseDouble(temp);
		}
		for(double each: data){
		//배열 데이터의 합을 구한다.
			sum+=each;
		 }
		avg = sum/len;
		
		
		 // 결과 값을 출력 한다.
		System.out.printf("합:%.3f\n평균:%.3f",sum,avg);
}
}
