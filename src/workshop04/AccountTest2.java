package workshop04;

public class AccountTest2 {
	public static void main(String args[]) { 

		// 5개의 Account 형 객체 배열 선언  
		Account[] accountarr = new Account[5];

		// for문을 이용하여 Account 객체를 배열에 생성  
		//	221-0101-211X(X 부분은 1부터 5까지의 정수가 셋팅 된다) 
		//	잔액 및 이자율은 모두 100000원, 4.5% 
		for(int i=0;i<accountarr.length;i++) {
			String accnum = "221-0101-211"+ (i+1);
			accountarr[i] = new Account(accnum,100000,4.5);

		}
		// for문을 이용하여 Account 정보 출력 
		for (Account each: accountarr) {
			each.accountInfo();
			System.out.println();
		}
		// for문을 이용하여 이자율을 변경하고 이자를 화면에 출력 
		for(Account each: accountarr) {
			each.setInterestRate(3.7);
			each.accountInfo();
			System.out.println(" "+each.calculateInterest());
		}
	}
}
