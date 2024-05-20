package net.developia.oop2;
//생성자를 살펴보아요

public class Point2D {
	int x;
	int y;
	
	public Point2D() {
		//생성자에서 다른 생성자를 콜하면 
		//...다른 코드가 먼저 오면 안된다.
		this(1,2);
		System.out.println("기본생성자");
	}
	
	public Point2D(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "x="+x +"y="+y;
	}
}



