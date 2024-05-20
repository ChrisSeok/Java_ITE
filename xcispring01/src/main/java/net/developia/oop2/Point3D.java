package net.developia.oop2;

public class Point3D extends Point2D{

		int z;
		
		public Point3D() {
			this(1,2,3);
		}
		
		public Point3D(int x, int y,int z) {
			super(x,y);
			this.z = z;

		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "x="+x +"y="+y +"z="+z;
		}
	}



