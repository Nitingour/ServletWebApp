<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@page import="java.sql.Connection" %>
    <%@page import="java.sql.DriverManager" %>
      <%@page import="java.sql.PreparedStatement" %>
        <%@page import="java.sql.ResultSet" %>
    
<%

try
{	
	//loading the class		
	Class.forName("com.mysql.jdbc.Driver");
	
	//establishing connection  
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/empdb","root","root");

	String sql = "select city from country where state=?";
	
	PreparedStatement ps = con.prepareStatement(sql);
	
	ps.setString(1, request.getParameter("state"));
	
	System.out.println(ps);
	ResultSet rs = ps.executeQuery();
	
	while(rs.next())
	{
		out.println("<option>"+rs.getString(1)+"</option>"); //111
	}
//end of start method try block
}
catch(Exception e)
{
	System.out.println("class Connect.start() exception"+e);
}
%>