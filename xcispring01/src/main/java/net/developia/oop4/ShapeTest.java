package net.developia.oop4;

public class ShapeTest {
	public static void main(String[] args) {
		printArea(new Circle());
		printArea(new Rectangle());
		printArea(new Triangle());	
		
	}

	public static void printArea(Shape s) {
		s.area();
		if(s instanceof Circle) {
			Circle c = (Circle) s;
	}else if (s instanceof Rectangle) {
		Rectangle r = (Rectangle) s;
	}else if (s instanceof Triangle) {
		Triangle t = (Triangle) s;
		
	}
}
}
