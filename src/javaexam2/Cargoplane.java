package javaexam2;

public class Cargoplane extends Plane{
	
	Cargoplane(){
		
	}
	Cargoplane(String planeName,int fuelSize){
		super(planeName, fuelSize);
	}

	public void flight(int distance) {
		int d = distance/10;
		super.fuelSize -= d*50;
	}

}
