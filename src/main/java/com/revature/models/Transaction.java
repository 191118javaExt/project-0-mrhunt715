package com.revature.models;

public class Transaction {
	private int transaction_id;
	private int account_id;
	private int bank_users_id;
	private float amount ;
	
	
	public Transaction(int transaction_id, int account_id, int bank_users_id, float amount) {
		super();
		this.account_id = account_id;
		this.transaction_id = transaction_id;
		this.bank_users_id = bank_users_id;
		this.amount = amount;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + account_id;
		result = prime * result + Float.floatToIntBits(amount);
		result = prime * result + bank_users_id;
		result = prime * result + transaction_id;
		return result;
	}


	public int getTransaction_id() {
		return transaction_id;
	}


	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}


	public int getAccount_id() {
		return account_id;
	}


	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}


	public int getBank_users_id() {
		return bank_users_id;
	}


	public void setBank_users_id(int bank_users_id) {
		this.bank_users_id = bank_users_id;
	}


	public float getAmount() {
		return amount;
	}


	public void setAmount(float amount) {
		this.amount = amount;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (account_id != other.account_id)
			return false;
		if (Float.floatToIntBits(amount) != Float.floatToIntBits(other.amount))
			return false;
		if (bank_users_id != other.bank_users_id)
			return false;
		if (transaction_id != other.transaction_id)
			return false;
		return true;
	}
}
