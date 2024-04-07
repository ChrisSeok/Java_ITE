package workshop04;

class Account{
	//	필드
	private String account;
	private int balance;
	private double interestRate;

	//	 생성자
	public Account() {

	}

	public Account(String account, int balance, double interestRate){
		this.account = account;
		this.balance = balance;
		this.interestRate = interestRate;

	}

	//	 메서드
	public void setAccount(String account) {
		this.account = account;
	}
	public String getAccount() {
		return account;
	}
	public int getBalance() {
		int b;
		b = this.balance ;
		return b;
	}

	public double calculateInterest() {
		return balance*interestRate;
	}

	public void deposit(int money) {
		this.balance += money;
	}

	public void withdraw(int money) {
		this.balance -= money;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return account+" "+balance;
	}
//	Account class에 Account의 모든 정보를 출력 할 수 있는 accountInfo()를 만든다. 
	public void accountInfo() {
		System.out.print(account+" "+balance+" "+interestRate);
	}
	public void setInterestRate(double interest) {
		this.interestRate = interest;
	}
}


public class AccountTest{
	public static void main(String[] args) {
		Account account; 
		
		// account 객체 생성 
		account = new Account("441-0290-1203",500000, 7.3);
		
		// account 기본 정보 출력 
		System.out.println(account);
		
		// account 에 20000원 입금 
		account.deposit(20000);
		// account 변경 정보 출력 
		System.out.println(account);
		// 이자 출력 – 현재 잔고를 기준으로 고객에게 줄 이자 금액을 출력 한다 
		System.out.println(account.calculateInterest());
	}
}





