package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
}
