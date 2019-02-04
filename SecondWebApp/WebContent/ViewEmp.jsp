<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="header.jsp" %>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="java.util.ArrayList,beans.EmployeeBean" %>
   <%  ArrayList<EmployeeBean> list=( ArrayList<EmployeeBean>)request.getAttribute("LIST"); %>
  <div class="container">
   <center><h1>View All Employee Details</h1></center>
   
  
   <%
   String m=(String)request.getAttribute("msg");
   if(m!=null)
  {  
%>
<div class="alert alert-success alert-dismissible">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  <strong><% out.println(m); %></strong>
</div>

<%
}
%>
   
  <table class="table table-hover">
  <tr><th>EID</th><th>Name</th><th>Salary</th><th>City</th><th>Gender</th><th>Address</th><th></th></tr>
    <%   for(EmployeeBean e:list)
   {
	 %> <tr>
	  <td><%=e.getEid()%></td>
	  <td><%=e.getName()%></td>
	  <td><%=e.getSalary()%></td>
	  <td><%=e.getCity()%></td>
	  <td><%=e.getGender()%></td>
	  <td><%=e.getAddress()%></td>
	    <td><a href="EmpDelController?empid=<%=e.getEid()%>" class="glyphicon glyphicon-remove" onclick="return confirm('Do you really want to Delete?')"  ></a></td>
      </tr>
   <%
   }
   
   %>
   </table>
   </div>
</body>
</html>