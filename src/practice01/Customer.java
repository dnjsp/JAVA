package practice01.p10;

public class Customer {
	private String firstName;
	private String lastName;
	private BankAccount[] accounts;
	private int numberOfAccounts;
	
	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		accounts = new BankAccount[5];
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public BankAccount getAccount(int index) {
		return accounts[index];
	}
	
	public void addAccount(BankAccount account) {
		accounts[numberOfAccounts++] = account;
	} // 위에서 초기화해줬기 때문에 if문을 써서 조건을 달아주지 않아도 됨

	public int getNumberOfAccounts() {
		return numberOfAccounts;
	}
	
	public String toString() {
		return "이름: " + firstName + " " + lastName + ", 계좌의 갯수: " + numberOfAccounts;
	}
}
