package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.EmployeeBean;

public class MyDAO {

	public int loginCheck(String uid,String password)
	{   int x=0;
		Connect c=new Connect();
		try(Connection con= c.start()){
 PreparedStatement ps=con.prepareStatement("select * from Login where uid=? and password=?");
		ps.setString(1,uid);
		ps.setString(2,password);
			   ResultSet rs=ps.executeQuery();
				if(rs.next())
			    x=1;
				}catch(SQLException e)
				{
					System.out.println(e);
				}
		
		return x;
	}

	public int insertEmp(EmployeeBean e)
	{
	int x=0;
	Connect c=new Connect();
	try(Connection con= c.start()){
PreparedStatement ps=con.prepareStatement("insert into EMp(ename,salary,address,city,gender) values(?,?,?,?,?)");
	ps.setString(1,e.getName());
	ps.setDouble(2,e.getSalary());
	ps.setString(3,e.getAddress());
	ps.setString(4,e.getCity());
	ps.setString(5,e.getGender());
      x=ps.executeUpdate();
			}catch(SQLException ex)
			{
				System.out.println(ex);
			}
	
		return x;
	}

	public ArrayList<EmployeeBean> viewAllEmployee() {
		 ArrayList<EmployeeBean> list=new  ArrayList<>();
		 Connect c=new Connect();
			try(Connection con= c.start()){
	 PreparedStatement ps=con.prepareStatement("select * from Emp");
				   ResultSet rs=ps.executeQuery();
					while(rs.next())
					{
					EmployeeBean e=new EmployeeBean();
					e.setEid(rs.getInt("eid"));
					e.setName(rs.getString("ename"));
			        e.setAddress(rs.getString("address"));
			        e.setCity(rs.getString("city"));
			        e.setGender(rs.getString("gender"));
			         list.add(e);
					}
			}
			catch(SQLException e)
					{
						System.out.println(e);
					}
		return list;
	}

	public int deleteEmp(int eid) {
	int x=0;
	Connect c=new Connect();
	try(Connection con= c.start()){
PreparedStatement ps=con.prepareStatement("delete from emp where eid=?");
	ps.setInt(1,eid);
      x=ps.executeUpdate();
			}catch(SQLException ex)
			{
				System.out.println(ex);
			}
		return x;
	}
	
}
