package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

	public Connection start()
	{
		Connection con=null;
		  try {
			  Class.forName("com.mysql.jdbc.Driver");
			   con=DriverManager.getConnection("jdbc:mysql://localhost:3307/mytestdb","root","root");
		  }
		  catch(ClassNotFoundException |SQLException  e)
		   {
			  System.out.println(e);
		   }
	   return con;	
	}
	
}
