//package javaexam2;
//import java.util.*;
//// Collection 인터페이스 사용 : 컬렉션은 데이터를 그룹화하고 저장하는 자료 구조를 나타냅니다. 
//// Collection 인터페이스는 다양한 종류의 컬렉션을 표현하며, 
//// 이러한 컬렉션은 리스트(list), 세트(set), 큐(queue) 등과 같이 다양한 데이터 구조를 제공합니다.
//public class Test05 {
//	public static void main(String[] args) {
//		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
//		double sum=0.0;
//		int tempsum = 0;
//		double avg;
//		Random rand = new Random();
//		
//		 for(int i=0;i<10;i++){
//		// HashMap에 1~100까지의 정수를 랜덤하게 10개 셋팅
//			int randnum = rand.nextInt(100)+1;
//			map.put(i,randnum);
//		 } 
//		Collection <Integer> value = map.values();
//		for(int each : value){
//		// HashMap 데이터를 화면에 출력
//			System.out.print(each+ " ");
//		 }
//		for(int each : value){
//		// HashMap 데이터의 합계를 계산
//			tempsum += each;
//		 }
//		sum = (double)tempsum;
//		avg = sum/map.size();
//		// 합계와 평균을 화면에 출력
//		System.out.printf("\n합계:%.2f\n평균:%.2f",sum,avg);
////	} 
//}
//}
