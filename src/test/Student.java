package test;

public class Student {
	
	private String name;
	private int age;
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
// Object 클래스의 equals 메서드를 오버라이딩
	
	@Override
	public boolean equals(Object obj) { //인자가 Object 객체 => 인스턴스이면 다 들어올 수 있음
		// 인자로 들어온 인스턴스가 equals method를 가지고 있는 
		// 인스턴스의 내용과 같으면, 같은 객체로 판별하는 로직을 작성
		// 일단 연산을 위해 타입이 일치해야 한다 > 인자로 들어온 인스턴스의 타입을 먼저 맞추기!(Object 를 Student로) 
		Student target = (Student) obj;  // type casting
		//이름과 나이가 같으면 
		boolean result = false;
		if(this.getName().equals(target.getName())&&  // 문자열 비교는 '==' 안쓰고 무조건 equals 씀!!
				this.getAge() == target.getAge()) {
			result = true;
		}
		return result;
		
		
	}
	public String toString() {
		return this.getName() + ":" + this.getAge();
	}
	
}

//entry 만들기 위해 굳이  뺀것임	
//class MyTest{
//	public static void main(String[] args) {
//		Student s1 = new Student("홍길동",20);
//
//		System.out.println(s1); // 메모리 시작주소가 출력
//		
//	}
//}




















