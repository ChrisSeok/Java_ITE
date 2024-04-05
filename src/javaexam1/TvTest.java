package javaexam1;

public class TvTest {
//main 안에서 Tv 타입의 배열을 선언하여 동작 시킨다.
	public static void main(String[] args) {
		Tv tvArray [] = new Tv[3];
		
		Tv tv1 = new Tv("INFINIA",1500000,"LED TV");
		Tv tv2 = new Tv("XCANVAS",1000000,"LCD TV");
		Tv tv3 = new Tv("CINEMA",2000000,"3D TV");
		 // 배열에 있는 객체 정보를 모두 출력 한다. – for 문을 이용 할 것
		 // Tv 가격의 합을 출력 한다.
		tvArray[0] = tv1;
		tvArray[1] = tv2;
		tvArray[2] = tv3;
		int sumprice = tv1.price + tv2.price + tv3.price;
		for (Tv each : tvArray) {
			System.out.println(each.toString());
		}
		System.out.println("가격의 합:"+sumprice);
	}
}
