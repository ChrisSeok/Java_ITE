package net.developia.oop4;

public class Circle extends Shape{
	int r = 10;
	public void area() {
		System.out.println("Circle's area");
		res = r*r*3.14; 
		System.out.println(res);
	}
	
	@Test
	public void testsize() {
		
	}
	
}
