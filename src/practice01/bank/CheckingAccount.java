package practice01.p07.bank;

public class CheckingAccount extends BankAccount {
	private SavingsAccount protectedBy;
	
	public CheckingAccount(int balance) {
		super(balance);
	}

	public CheckingAccount(int balance, SavingsAccount protectedBy) {
		super(balance);
		this.protectedBy = protectedBy;
	}
	
	@Override
	public boolean withdraw(int amount) {
		if (balance < amount) {
			protectedBy.balance -= amount - balance;	
			balance = 0;
		} else {
			super.withdraw(amount);
		}
		return true;
	}
}
