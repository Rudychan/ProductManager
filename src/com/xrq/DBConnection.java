package com.xrq;

import java.sql.*;

/*
 * 用于连接数据库返回一个链接
 */
public class DBConnection {
	private Connection conn;
	private static String URL = "jdbc:mysql://localhost:3306/testdb";
	private static String Name = "root";
	private static String Password = "123456";
	
	
	public Connection ConnectDB()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("数据量驱动获取失败");
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(URL, Name, Password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库链接失败");
			e.printStackTrace();
		}
		return conn;
	}

}
