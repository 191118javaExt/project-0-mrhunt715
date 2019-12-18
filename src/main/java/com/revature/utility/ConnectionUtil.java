package com.revature.utility;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class ConnectionUtil {
	
	private static Logger logger = Logger.getLogger(ConnectionUtil.class.getName());

	public static Connection getConnection() throws SQLException {
		
		String url = "jdbc:postgresql://localhost:5432/";
		String username = "postgres";
		String password = "SkyeBH0714";
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			logger.warning("Unable to obtain connection to database");
		}
		
		return conn;
	}
}

		
		