package com.xrq;

import java.sql.*;

/*
 * �����������ݿⷵ��һ������
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
			System.out.println("������������ȡʧ��");
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(URL, Name, Password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("���ݿ�����ʧ��");
			e.printStackTrace();
		}
		return conn;
	}

}
