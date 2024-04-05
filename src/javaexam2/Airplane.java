package javaexam2;

public class Airplane extends Plane{
	
	Airplane(){
		
	}
	
	Airplane(String planeName, int fuelSize){
		super(planeName, fuelSize);
	}
	
	public void flight(int distance) {
			int d = distance/10;
			super.fuelSize -= d*30;
		}
	}

