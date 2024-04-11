package javaexam2;

public class StudentTest {
	public static void main(String[] args) {
		Student arrays [] = new Student[3];
		Student st1 = new Student("홍길동",15,171, 81 ,"201101","영문");
		Student st2 = new Student("한사람",15,171, 81 ,"201101" ,"영문");
		Student st3 = new Student("임꺽정",15,171, 81 ,"201101" ,"영문");
		
		arrays[0] = st1;
		arrays[1] = st2;
		arrays[2] = st3;
		for (Student each : arrays) {
			System.out.println(each.printInformation());
		}
}	
}
