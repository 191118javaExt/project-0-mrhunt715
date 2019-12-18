package com.revature.menus;

import java.util.logging.Logger;




/** 
 * @author E.Hunt
 */

public interface Menu {
	static Logger menuLog = Logger.getLogger(Menu.class.getName());
	/**
	 * Display a Menu of options to the User
	 */
	void showMenu();
	
	/**
	 * Hooks user choice into a functional service process
	 * @return View
	 */
	Menu process();
	
	/**
	 * Method for getting user input regarding the 
	 * menu shown in {@link #showMenu()}
	 */
	void getUserInput();
}

