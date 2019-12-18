package com.revature.services;

import com.revature.menus.CurrencyMenu;

import java.util.List;
import java.util.logging.Logger;

import com.revature.daos.AccountDao;
import com.revature.daos.AccountDaoImpl;
import com.revature.models.Account;
import com.revature.utility.ConnectionUtil;
import com.revature.utility.InputUtility;

public class  AccountService{
	public static Account acct = new Account();
	private static AccountDaoImpl acctDao = new AccountDaoImpl();
	private static UserService userService = new UserService();
	private static Logger logger = Logger.getLogger(ConnectionUtil.class.getName());
	public static Account getAccount() {
		return acct;
	}

	public static void setAccount(Account acct) {
		AccountService.acct = acct;
	}
	
	public int getAcctId() {
		return acct.getAcctID();
	}
	
	public void setAcctId(int id) {
		id = acct.getAcctID();
	}
	
	public double getBalance() {
		return acct.getBalance();
	}
	
	public void setBalance(double balance) {
		balance = acct.getBalance();
	}
	
	public String getCurrency() {
		return acct.getCurrency();
	}
	
	public void setCurrency(String currency) {
		currency = acct.getCurrency();
	}
	
	public String getType() {
		return acct.getType();
	}
	
	public void setType(String acctType) {
		acctType = acct.getType();
	}
	
	public void openChecking() {
		acct.setBalance(0.00);
		acct.setCurrency(CurrencyMenu.process());
		acct.setType("CHECKING");

		// Create account in DB and add returned id(unique account number) to user accounts array
		acct = acctDao.createAcct(acct, userService.getUserId());
		UserService.newUser = false;
	}
	
	public void openSavings() {
		acct.setBalance(0.00);
		acct.setCurrency(CurrencyMenu.process());
		acct.setType("SAVINGS");

		// Create account in DB and add returned id(unique account number) to user accounts array
		acct = acctDao.createAcct(acct, userService.getUserId());
		UserService.newUser = false;
	}
	
	public void deposit() {
		System.out.println("                                                   ");
		System.out.println("                                                   ");
		System.out.println("        *******************************************");
		System.out.println("        *             BankOCheddar                *");
		System.out.println("        *                                         *");
		System.out.println("        *                 DEPOSIT                 *");
		System.out.println("    	*******************************************");
		System.out.println("                                                   ");
		
		// Display user accounts menu
		
		System.out.print("Enter account to deposit into: "); // id for account
		int acct_id = InputUtility.getIntChoice(100);
		
		System.out.println();
		System.out.print("Enter amount to be deposited: ");
		double amt = InputUtility.getDoubleInput(100_000);
		
		acctDao.depositTo(acct_id, amt);
	}
	
	public void withdraw() {
		System.out.println("                                                   ");
		System.out.println("                                                   ");
		System.out.println("    	*******************************************");
		System.out.println("        *             BankOCheddar                *");
		System.out.println("        *                                         *");
		System.out.println("        *                WITHDRAW                 *");
		System.out.println("    	*******************************************");
		System.out.println("                                                   ");
		
		// Display user accounts menu
		
		System.out.print("Enter account to withdraw from: "); // id for account
		int acct_id = InputUtility.getIntChoice(100);
		System.out.println();
		
		boolean acctFound = userService.getAcctNumbers().contains(acct_id);
		
		if(acctFound == false) {
			do {
				System.out.println("ERROR: Please enter a correct account number!");
				System.out.print("Enter account to withdraw from: "); // id for account
				System.out.println();
				acct_id = InputUtility.getIntChoice(100);
				acctFound = userService.getAcctNumbers().contains(acct_id);
			}while(acctFound == false);
		}
		
		System.out.print("Enter amount to be withdrawn: ");
		double amt = InputUtility.getDoubleInput(100_000);
		
		acctDao.withdrawFrom(acct_id, amt);
	}
	
	public void transfer() {
		System.out.println("                                                   ");
		System.out.println("                                                   ");
		System.out.println("    	*******************************************");
		System.out.println("        *             BankOCheddar                *");
		System.out.println("        *                                         *");
		System.out.println("        *             TRANSFER MONEY              *");
		System.out.println("    	*******************************************");
		System.out.println("                                                   ");
		
		// Display user accounts menu
		
		System.out.print("Enter account to transfer from: "); // id for account
		int acct_idFrom = InputUtility.getIntChoice(100);
		System.out.println();
		
		boolean acctFound = userService.getAcctNumbers().contains(acct_idFrom);
		
		if(acctFound == false) {
			do {
				System.out.println("ERROR: Please enter a correct account number!");
				System.out.print("Enter account to transfer from: "); // id for account
				System.out.println();
				acct_idFrom = InputUtility.getIntChoice(100);
				acctFound = userService.getAcctNumbers().contains(acct_idFrom);
			}while(acctFound == false);
		}
		
		System.out.print("Enter account to transfer to: "); // id for account
		int acct_idTo = InputUtility.getIntChoice(100);
		System.out.println();
		
		System.out.print("Enter amount to be transferred: ");
		double amt = InputUtility.getDoubleInput(100_000);
		
		acctDao.transferMoney(acct_idFrom, acct_idTo, amt);
	}
	
	public void addUserToAccount() {
		System.out.println("                                                   ");
		System.out.println("                                                   ");
		System.out.println("    	*******************************************");
		System.out.println("        *             BankOCheddar                *");
		System.out.println("        *                                         *");
		System.out.println("        *            ADD USER TO ACCOUNT          *");
		System.out.println("    	*******************************************");
		System.out.println("                                                   ");
		
		// Display user accounts menu
		
		System.out.print("Enter account to add user: "); // id for account
		int acct_id = InputUtility.getIntChoice(100);
		System.out.println();
		
		boolean acctFound = userService.getAcctNumbers().contains(acct_id);
		
		if(acctFound == false) {
			do {
				System.out.println("ERROR: Please enter a correct account number!");
				System.out.print("Enter account to transfer from: "); // id for account
				System.out.println();
				acct_id = InputUtility.getIntChoice(100);
				acctFound = userService.getAcctNumbers().contains(acct_id);
			}while(acctFound == false);
		}
		
		System.out.print("Enter Email of new user: "); // id for account
		String newUserEmail = InputUtility.getStringInput(100);
		
		acctDao.addUserToAcct(acct_id, newUserEmail);
	} 
	
	public void deleteAcct() {
		System.out.println("                                                   ");
		System.out.println("                                                   ");
		System.out.println("    	*******************************************");
		System.out.println("        *             BankOCheddar                *");
		System.out.println("        *                                         *");
		System.out.println("        *           DELETE BANK ACCOUNT           *");
		System.out.println("    	*******************************************");
		System.out.println("                                                   ");
		
		// Display user accounts menu
		
		System.out.print("Enter account to delete: "); // id for account
		int acct_id = InputUtility.getIntChoice(100);
		acctDao.deleteAccount(acct_id, userService.getUserId());
	}
	
	public double exchangeCurrency(String startCurrency, double startAmount, String newCurrency) {
		double newAmount = 0.0;
		return newAmount;
	}

	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Account findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Account> findByUserId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean insert(Account e) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(Account e) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Account> findStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteAccount(int acct_id, int userId) {
		// TODO Auto-generated method stub
		
	}

	public void addUserToAcct(int acct_id, String newUserEmail) {
		// TODO Auto-generated method stub
		
	}

	public void transferMoney(int acct_idFrom, int acct_idTo, double amt) {
		// TODO Auto-generated method stub
		
	}

	public void withdrawFrom(int acct_id, double amt) {
		// TODO Auto-generated method stub
		
	}

	public void depositTo(int acct_id, double amt) {
		// TODO Auto-generated method stub
		
	}

	public Account createAcct(Account acct, int userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}