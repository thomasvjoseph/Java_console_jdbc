package com.ipl.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionManager {
	
	static Connection con = null;
	public static Properties loadPropertiesFile() throws Exception {
			Properties p = new Properties();
			InputStream in = new FileInputStream("C:\\Users\\User\\eclipse-workspace\\IPL\\src\\resources\\connection.properies");
			p.load(in);
			in.close();
			return p;
	}
	public Connection getConnection() throws Exception {
		Properties p = loadPropertiesFile();
		final String driver = p.getProperty("driver");
		final String url = p.getProperty("url");
		final String username = p.getProperty("username");
		final String password = p.getProperty("password");

		Class.forName(driver);
		con = DriverManager.getConnection(url,username,password);
		
		return con;
		
	}
}
