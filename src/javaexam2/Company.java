//package javaexam2;
//
//import java.util.HashMap;
//
//public class Company {
//
//	public static void main(String args[]) {
//		HashMap<Integer,Object> map = new HashMap<>(); // 뒤의 타입선언 <>로 생략 가능.
//		
//		// 1번의 데이터를 기반으로 객체를 생성 하여 HashMap에 넣는다.
//		Secretary sec1 = new Secretary("Hilery", 1 ,"secretary", 800);
//		Sales sale1 = new Sales("Clinten", 2 ,"sales", 1200);
//		// HashMap에 넣을 때 키 값은 각 객체의 Number로 한다.
//		map.put(sec1.getNumber(), sec1);
//		map.put(sale1.getNumber(), sale1);
//		
//		
//		// 모든 객체의 기본 정보를 출력 한다(for문을 이용하여 출력 한다.)
//		for (Object value : map.values()) {
//			System.out.println(value);
//		}
//		// 모든 객체에 인센티브 100씩 지급하고 다시 HashMap에 넣는다.
//		
//		sec1.incentive(100);
//		sale1.incentive(100);
//		System.out.println("인센티브 100 지급");
//		
//		
//		// 모든 객체의 정보와 세금을 출력 한다 (for문을 이용하여 출력 한다.) 
//		// map에 있는 모든 인스턴스 변수 출력
//		//toString 대신 getter, setter 사용해서 for문으로 출력
//		for (Object value : map.values()) {
//		    if (value instanceof Secretary) {
//		        Secretary sec = (Secretary) value;
//		        System.out.println("Secretary - Name: " + sec.getName() + ", Department: " + sec.getDepartment() + ", Salary: " + sec.getSalary()+ ", tax: " + sec.tax());
//		    } else if (value instanceof Sales) {
//		        Sales sale = (Sales) value;
//		        System.out.println("Sales - Name: " + sale.getName() + ", Department: " + sale.getDepartment() + ", Salary: " + sale.getSalary()+ ", tax: " + sale.tax());
//		    } else {
//		        System.out.println("Unknown type");
//		    }
//		}
//	}
//}