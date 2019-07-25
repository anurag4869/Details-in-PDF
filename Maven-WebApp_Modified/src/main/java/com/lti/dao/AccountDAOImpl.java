package com.lti.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import com.lti.bean.Account;

public class AccountDAOImpl  
{
	private Connection con;


	public boolean insertAccount(Account ob) 
	{
		boolean inserted=false;
		// Load Driver
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				// Establish connection using url, username and password
				String url="jdbc:oracle:thin:@localhost:1521:xe";
				String username="hr";
				String password="hr";
				
				try
				{
				//establish connection
				con=DriverManager.getConnection(url,username,password);
				System.out.println("Connected");
				
				//parametrized query
				PreparedStatement ps1=con.prepareStatement("insert into Account values(?,?,?,?)");
				ps1.setInt(1, ob.getAid());
				ps1.setString(2,ob.getAname());
				
				LocalDate Id=ob.getDob();
				//Date d=new Date(Id.getYear(),Id.getMonthValue()-1,Id.getDayOfMonth());
				Date d=Date.valueOf(Id);
				ps1.setDate(3, d);
				ps1.setDouble(4, ob.getBalance());
				int i=ps1.executeUpdate();
				System.out.println("Records inserted are: "+i);
				
				inserted=true; 
				}
				catch(SQLException e)
					{
					System.out.println(e.getMessage());
					inserted=false;
					}
				finally
				{
				try 
					{
					con.close();
					} 
				catch (SQLException e) 
					{
					e.printStackTrace();
					}	
				}
		return inserted;
	}

	
	public boolean updateAccount(Account ob)
	{
		// TODO Auto-generated method stub
		//update account set aname=?,dob=?,balance=? where aid=?
		
		boolean inserted=false;
		// Load Driver
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				// Establish connection using url, username and password
				String url="jdbc:oracle:thin:@localhost:1521:xe";
				String username="hr";
				String password="hr";
				
				try
				{
				//establish connection
				con=DriverManager.getConnection(url,username,password);
				System.out.println("Connected");
				
				//parametrized query
				PreparedStatement ps1=con.prepareStatement("update account set aname=?,dob=?,balance=? where aid=?");

				ps1.setString(1,ob.getAname());
				LocalDate Id=ob.getDob();
				//Date d=new Date(Id.getYear(),Id.getMonthValue()-1,Id.getDayOfMonth());
				Date d=Date.valueOf(Id);
				ps1.setDate(2, d);
				ps1.setDouble(3, ob.getBalance());
				ps1.setInt(4, ob.getAid());
				
				
				int i=ps1.executeUpdate();
				System.out.println("Records updated are: "+i);
				
				inserted=true; 
				}
				catch(SQLException e)
					{
					System.out.println(e.getMessage());
					inserted=false;
					}
				finally
				{
				try 
					{
					con.close();
					} 
				catch (SQLException e) 
					{
					e.printStackTrace();
					}	
				}
		return inserted;
		
	
	}

	
	public boolean deleteAccount(Account ob) 
	{
		// TODO Auto-generated method stub
		//delete from Account where aid=?
		return false;
	}


	public Account getAccountById(int aid)
	{
		// TODO Auto-generated method stub
	
		// Load Driver
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				// Establish connection using url, username and password
				String url="jdbc:oracle:thin:@localhost:1521:xe";
				String username="hr";
				String password="hr";
				Account ob = new Account();
				try
				{
				//establish connection
				con=DriverManager.getConnection(url,username,password);
				System.out.println("Connected");
				
				//parametrized query
				PreparedStatement ps1=con.prepareStatement("select * from account where aid=?");
				ResultSet rs=ps1.executeQuery();
				
				while(rs.next())
				{
					
					int id=rs.getInt(1);
					ob.setAid(id);
					ob.setAname(rs.getString("aname"));
					ob.setDob(rs.getDate(3).toLocalDate());
					ob.setBalance(rs.getDouble(4));
					
				
				}
				
				}
				catch(SQLException e)
					{
					System.out.println(e.getMessage());
				
					}
				finally
				{
				try 
					{
					con.close();
					} 
				catch (SQLException e) 
					{
					e.printStackTrace();
					}	
				}
		return ob;
	}


	public List<Account> getAllAccount() {
		// TODO Auto-generated method stub
	List<Account>acclist=new ArrayList<Account>();
		// Load Driver
	try {			
	Class.forName("oracle.jdbc.driver.OracleDriver");
	}
	catch(Exception e) {
		System.out.println("Exception: "+e.getMessage());
	}	
				// Establish connection using url, username and password
				String url="jdbc:oracle:thin:@localhost:1521:xe";
				String username="hr";
				String password="hr";
	
				
				try
				{
				//establish connection
				con=DriverManager.getConnection(url,username,password);
				System.out.println("Connected");
				
				//parametrized query
				PreparedStatement ps1=con.prepareStatement("select * from account");
				ResultSet rs=ps1.executeQuery();
				while(rs.next())
				{
					Account ob = new Account();
					int id=rs.getInt(1);
					ob.setAid(id);
					ob.setAname(rs.getString("aname"));
					ob.setDob(rs.getDate(3).toLocalDate());
					ob.setBalance(rs.getDouble(4));
					acclist.add(ob);
				
				}
				
				}
				catch(SQLException e)
					{
					System.out.println(e.getMessage());
				
					}
				finally
				{
				try 
					{
					con.close();
					} 
				catch (SQLException e) 
					{
					e.printStackTrace();
					}	
				}
		return acclist;
	}

}
