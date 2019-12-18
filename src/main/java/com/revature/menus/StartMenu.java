package com.revature.menus;

import java.util.logging.Logger;

import com.revature.services.UserService;
import com.revature.utility.ConnectionUtil;
import com.revature.utility.InputUtility;

public class StartMenu implements Menu {
	public int inputValue;
	private static UserService userService = new UserService();
	Logger logger = Logger.getLogger(ConnectionUtil.class.getName());
	@Override
	public void showMenu() {
		System.out.println("                                                   ");
		System.out.println("                                                   ");
		System.out.println("        *******************************************");
		System.out.println("        *             BankOCheddar                *");
		System.out.println("        *                                         *");
		System.out.println("        *        Welcome to BankOCheddar!         *");
		System.out.println("        *                                         *");
		System.out.println("        *     1. OPEN NEW USER ACCOUNT            *");
		System.out.println("        *     2. LOGIN TO EXISTING ACCOUNT        *");
		System.out.println("        *     3. EXIT BANKING APPLICATION         *");
		System.out.println("        *                                         *");
		System.out.println("        *******************************************");
	}
	
	@Override
	public Menu process() {
		switch(inputValue) {
			case 1: 
				logger.info("Open new user account");
				userService.createUser();
				return new UserMainMenu();
			case 2:
				logger.info("Login to existing account");
				userService.userLogin();
				return new UserMainMenu();
			case 3: 
				logger.info("Exiting Banking App");
				return null;
		}
		return null;
	}

	@Override
	public void getUserInput() {
		this.inputValue = InputUtility.getIntChoice(3);
	}
	
}