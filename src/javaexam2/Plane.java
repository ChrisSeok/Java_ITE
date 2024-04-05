package javaexam2;
import java.util.*;

abstract class Plane {
	String planeName;
	int fuelSize;
	
	
	public Plane() {
		
	}
	
	public Plane(String planeName, int fuelSize) {
		this.planeName = planeName;
		this.fuelSize = fuelSize;
	}
	
// Getter, Setter로 private 변수 접근 및 설정.	
	//Getter for planeName
	public String getPlaneName() {
		return planeName;
	}
	//Setter for planeName
	public void setPlaneName(String planeName) {
		this.planeName = planeName;
	}
	//Getter for fuelSize
	public int getFuelSize() {
		return fuelSize;
	}
	//Setter for fuelSize
	public void setFuelSize(int fuelSize) {
		this.fuelSize = fuelSize;
	}

	
	public void refuel(int fuel){ // 주유
		fuelSize += fuel;
	}
	public String toString() {
		return String.format("planeName:%s, fuelsize: %d",planeName, fuelSize);
	}
	abstract void flight(int distance); // 운항

	
}










