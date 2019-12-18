package com.revature.driver;


/** 
 * @author E.Hunt
 */

import com.revature.menus.StartMenu;
import com.revature.menus.UserMainMenu;
import com.revature.utility.ConnectionUtil;
import com.revature.menus.Menu;
import java.util.logging.Logger;

public class BankApp {
	private static Logger logger = Logger.getLogger(ConnectionUtil.class.getName());
	
	public static void main(String[] args) {
		runStartMenu();
	}
	
	public static void runStartMenu() {
		Menu menu = new StartMenu();
		do {
			logger.info("The BankOCheddar Application Log is running! :)");
			menu.showMenu();
			menu.getUserInput();
			menu = menu.process();
		} while(menu!=null);
		
		System.out.println();
		System.out.println("Thank You! See you again soon!");
	}
	
	public static void toUserMainMenu() {
		Menu menu = new UserMainMenu();
		do {
			menu.showMenu();
			menu.getUserInput();
			menu = menu.process();
		} while(menu!=null);
	}
}