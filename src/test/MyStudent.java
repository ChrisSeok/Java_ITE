package test;

import java.util.ArrayList;
import java.util.List;

class MyStudent {

}

//
//public class ArrayListTest{
//	public static void main(String[] args) {
////		ArrayList 객체를 만들어 사용해 보자
////		List 계열은 객체면 type에 상관없이 다 저장이 가능하다.
////		다른 데이터 타입도 저장할 수 있음!
////		But 구현하다 보면 대부분의 경우 같은 데이터타입을 이용해서 사용하게 됨(배열처럼)
//		List<String> list1 = new ArrayList<String>();  // 일반적 generic을 명시한다. 모든 타입이 다 들어갈 경우 <Object> 로.
//		
//		List list = new ArrayList(); 
//		list.add("홍길동");
//		list.add(new MyStudent());
//		list.add(100); //100은 int형태의 primitive type이다 > 따라서 ArrayList안에 저장될 수 없다 
//						// but 자바에는 primitive type에 각각 대응되는 wrapper class가 존재.	
//						// list.add(100); => list.add(new Integer(100))
//						// boxing 이라는 표현을 사용한다.
//		
//		for(Object obj : list) { // 집합형 자료구조 반복
//			//어떤 객체가 list에서 나올지 모르니까 Object로 잡음 > 모든 객체 커버할 수 있으니까.
//			System.out.println(obj.toString()); //동적바인딩 발생 오버라이딩 된 toString에 대해서는 값이 출력, 아니면 주소.
//		}
//		
//		//Generic 잡아서 타입 지정
//		List<String> myList = new ArrayList<String>();
//		myList.add("홍길동");
//		myList.add("신사임당");
//		
//		for(String str : myList) { // 집합형 자료구조 반복
//			//어떤 객체가 list에서 나올지 모르니까 Object로 잡음 > 모든 객체 커버할 수 있으니까.
//			System.out.println(str); //동적바인딩 발생 오버라이딩 된 toString에 대해서는 값이 출력, 아니면 주소.
//		}
//		
//	}
//}
