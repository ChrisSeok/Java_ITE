package javaexam2;

//3개의 Student 객체를 생성 하여 배열에 셋팅 한 후 각 객체의 모든 정보를 출력 한다.
public class Student extends Human{
	String number;
	String major;

	Student(){

	}

	Student(String name,int age,int height,int weight,String number,String major){
//		super(name,age,height,weight);
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.number = number;
		this.major = major;

	}
	@Override
	public String printInformation() {
		return this.name +" "+ this.age+" "+ this.height+" "+ 
				this.weight+" " + this.number+" "+this.major;
	}

}
