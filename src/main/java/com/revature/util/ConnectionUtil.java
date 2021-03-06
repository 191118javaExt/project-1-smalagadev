package com.revature.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConnectionUtil {
	private static Logger logger = Logger.getLogger(ConnectionUtil.class);
	
	public static Connection getConnection() {
		
		try {
			Class.forName("org.postgresql.Driver");
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Properties props = new Properties();
		
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		
		Connection conn = null;
		
		try {
			
			props.load(loader.getResourceAsStream("connection.properties"));
				String url = props.getProperty("url");
				String username = props.getProperty("username");
				String password = props.getProperty("password");
			try {
				conn = DriverManager.getConnection(url,username,password);
				logger.info("Connected to database.");	
			}
			catch(SQLException e) {
				logger.warn("Could not connect to database: ", e);
			}
		}
		catch(IOException e) {}
		
		return conn;
	}

}
