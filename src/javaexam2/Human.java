package javaexam2;

public class Human {
	String name;
	int age;
	int height;
	int weight;
	Human(){
		
	}
	Human(String name,int age, int height, int weight){
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
	
	public String printInformation() {
		return this.name + this.age+ this.height+ this.weight;
	}
}
