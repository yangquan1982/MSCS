package lesson9.exercise_3;

public class Account {
	private String ownerName;
	private int balance;
	private int acctId;
	public Account(String owner, int bal, int id) {
		ownerName = owner;
		balance = bal;
		acctId = id;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getAcctId() {
		return acctId;
	}
	public void setAcctId(int acctId) {
		this.acctId = acctId;
	}
	@Override
	public String toString() {
		return ownerName +": " + acctId + ", $" + balance;
	}
}
