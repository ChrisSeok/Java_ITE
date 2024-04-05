//package javaexam2;
//
//public class PlaneTest {
//	public static void main(String args[]) {
//
//		// Airplane과 Cargoplane 객체 생성
//		// setter 사용?
//		Airplane AP = new Airplane("L747",1000);	
//		Cargoplane CP = new Cargoplane("C40",1000);	
//
//		// 생성된 객체의 정보 출력
//		//Plane 클래스에서 toString 오버라이딩 > 객체 출력
//		// getter 사용?
//		System.out.println(AP);	
//		System.out.println(CP+"\n");
//
//
//		// Airplane과 Cargoplane 객체에 100씩 운항
//		//각각의 자식클래스에 오버라이딩 된 flight 함수가 콜된다.
//		AP.flight(100); 
//		CP.flight(100);
//		
//		// 100 운항 후 객체 정보 출력
//		System.out.println(AP);
//		System.out.println(CP+"\n");
//		
//		//Airplane과 Cargoplane 객체에 200씩 주유
//		//부모클래스의 refuel 함수가 콜된다.
//		AP.refuel(200);
//		CP.refuel(200);
//		
//		
//		// 200 주유 후 객체 정보 출력
//		System.out.println(AP);
//		System.out.println(CP+"\n");
//	}
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
