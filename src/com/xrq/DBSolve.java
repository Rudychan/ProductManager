package com.xrq;
import java.sql.*;
import java.util.ArrayList;

public class DBSolve {
	private String dbPassword="";
	private int total=0;
	
	//登陆验证
	public boolean verify(String user, String password)
	{
		Connection conn = (Connection)new DBConnection().ConnectDB();
		try {
				Statement sta = conn.createStatement();
				ResultSet rs =sta.executeQuery("SELECT * FROM manager WHERE user = "+"\""+user+"\"");
				if(rs.next())
				{
					dbPassword = rs.getString(3);
				}
				
			if(dbPassword.equals(password)) return true;
			else return false;
		} catch (SQLException e) {
			System.out.println("数据库查询处理出错");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
//查看数据总条数
	public int TotalItem()
	{
		Connection conn = (Connection)new DBConnection().ConnectDB();
		try {
				Statement sta = conn.createStatement();
				ResultSet rs =sta.executeQuery("SELECT COUNT(1) FROM product");
				if(rs.next())
				{
					total = rs.getInt(1);
				}
		} catch (SQLException e) {
			System.out.println("数据库查询处理出错");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
	}

	
	//查询商品数据,用Bean的方式放在ArrayList中
	public ArrayList<DataBean> DataResulta(int PageNow , int PageRow)
	{
		ArrayList<DataBean> al = new ArrayList<>();
		Connection conn = new DBConnection().ConnectDB();
		Statement sts;
		try {
			sts = conn.createStatement();
			ResultSet rs = sts.executeQuery("SELECT * FROM product LIMIT "+(PageNow-1)*5+","+PageRow);
			while(rs.next())
			{
				DataBean bean = new DataBean();
				bean.setID(rs.getString(1));
				bean.setName(rs.getString(2));
				bean.setPrice(rs.getString(3));
				bean.setNumber(rs.getString(4));
				al.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
	}

}
