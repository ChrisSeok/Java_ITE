package javaexam2;
import java.util.*;


//부모클래스인 Employee 클래스
public abstract class Employee {
	//클래스(인스턴스) 변수
	private String name;
	private int number;
	private String department;
	private int salary;

	//getters & setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String toString(){
		return String.format("name:%s\t department: %s \t salary: %d"
				,this.name, this.department, this.salary);
	}

	//기본생성자
	Employee(){

	}

	//4개의 클래스 변수를 받는 생성자
	Employee(String name,int number,String department,int salary){
		this.name = name;
		this.number = number;
		this.department = department;
		this.salary = salary;
	}

	//세금을 리턴하는 추상 함수
	public abstract double tax();

}



//Bonus 인터페이스
interface Bonus{
	//추상메서드 incentive 선언
	abstract public void incentive(int pay);

}



//클래스 상속과 인터페이스 구현을 모두 하는 클래스
class Secretary extends Employee implements Bonus{
	//기본생성자
	Secretary(){

	}
	//생성자
	Secretary(String name,int number,String departme, int salary){
		super(name,number,departme,salary);
	}


	//tax 메서드 오버라이딩
	//세금을 리턴 한다 - salary에 10% 징수
	public double tax(){
		int sal = getSalary();
		double taxAmount = sal * 0.1; // Calculate tax amount
		return taxAmount;
	}

	// incentive 메서드 정의
	//지급되는 pay에 80%가 기존 salary에 더해진다
	public void incentive(int pay){
		int sal = getSalary();
		sal += pay*0.8;
		setSalary(sal);
	}

}

class Sales extends Employee implements Bonus{
	
	Sales(){
		
	}
	
	Sales(String name,int number,String departme, int salary){
		super(name,number,departme,salary);
	}


	//tax 메서드 오버라이딩
	//세금을 리턴 한다 - salary에 13% 징수
	public double tax(){
		int sal = getSalary();
		double taxAmount = sal * 0.13; // double로 형변환
		return taxAmount;
	}

	// incentive 메서드 정의
	//지급되는 pay의 120%가 기존 salary에 더해진다
	public void incentive(int pay){
		int sal = getSalary();
		sal += pay*1.2;
		setSalary(sal);
	}
}



	
	
	
	
	
	
	
	
	