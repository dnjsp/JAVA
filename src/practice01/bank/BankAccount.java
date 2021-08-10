package practice01.p07.bank;

public class BankAccount {
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
		if (balance < amount) {
			return false;
		} 
		balance -= amount;
		return true;
	}
	
	public boolean transfer(int amount, BankAccount otherAccount) {
		if (balance < amount) {
			return false;
		}
		balance -= amount;
		otherAccount.balance += amount;
		return true;
	}
	
	public String toString() {
//		return "잔액: " + balance;
		
		return String.format("%,d", balance);
	}
}
