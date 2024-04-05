package javaexam2;
import java.util.*;
//ArrayList에 10개의 정수형 데이터를 1~10 랜덤 하게 만들어서 셋팅 한 후 정보를 출력, 
//ArrayList에 셋팅된 정수 들을 Collections 클래스의 [ public static void sort(List list) ] 함수를 이용하여
//sorting 된 숫자를 화면에 출력 한다
//랜덤 넘버는 중복 가능

public class Test04 {
	
	public static void main(String[] args) {
		// 기본 데이터 타입(primitive type)인 int를 이용하여 제네릭 타입으로 사용할 수 없다.
		// 제네릭은 reference type에 대해서만 유효하다.
 		//대신 wrapper 클래스인 Integer를 사용해야 한다.
		List<Integer> list= new ArrayList<Integer>(10);
		Random rand = new Random();
		for(int i = 0; i<10;i++){
		 // ArrayList에 1~10까지의 정수를 랜덤하게 셋팅 하고 셋팅 된 데이터를 출력 한다.
			int randnum = rand.nextInt(10)+1;
//			ArrayList에 값 추가시 add() 메서드를 사용하여 값을 추가해야 한다.
			list.add(randnum);
		}
		 // ArrayList의 값들을 Sorting 처리
		 Collections.sort(list);
		 //for문 사용시에도 int 아닌 wrapper인 Integer사용.
		for(Integer each : list){
			System.out.println(each);
		}

}
}
