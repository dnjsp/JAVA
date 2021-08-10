package practice01.p10;

public abstract class BankAccount {
	protected int balance;

	public BankAccount(int balance) {
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}
	
	public void deposit(int amount) {
		balance += amount;
	}
	
	public boolean withdraw(int amount) {
		if (balance < amount || amount < 0) {
			return false;
		} 
		balance -= amount;
		return true;
	}
	
	public boolean transfer(int amount, BankAccount otherAccount) {
		if (balance < amount || amount < 0) {
			throw new IllegalArgumentException();
		} 
		if (otherAccount == null) {
			throw new NullPointerException();
		}
		balance -= amount;
		otherAccount.balance += amount;
		return true;
	}
	
	public String toString() {
//		return "잔액: " + balance;
		
		return String.format("%,d", balance);
	}
	
	public abstract String getAccountType();
}
