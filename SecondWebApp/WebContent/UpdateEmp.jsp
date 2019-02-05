<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <%@include file="header.jsp" %>
</head>
<body>


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



<div class="container" >
<div class="row">
  <div class="col-sm-4">
  
 <form action="EmpUpdateController" method="post" >
<%@page import="beans.EmployeeBean" %>
 <%
 EmployeeBean e=(EmployeeBean)request.getAttribute("EMP");
 %>
 <div class="form-group">
    <label for="pwd">EID:</label>
    <input type="text" name="eid" value="<%=e.getEid()%>"  class="form-control" readonly />
  </div>
  
  <div class="form-group">
    <label for="pwd">Name:</label>
    <input type="text" name="name" value="<%=e.getName()%>" class="form-control" id="pwd">
  </div>
   <div class="form-group">
    <label for="pwd">Salary:</label>
    <input type="text" name="salary" value="<%=e.getSalary()%>" class="form-control" id="pwd">
  </div>
  <div class="form-group">
    <label for="pwd">City</label>
    <Select name="city" class="form-control" id="pwd">
    <option selected><%=e.getCity()%></option>
    <option>-select-</option>
    <option>Mumbai</option>
    <option>Pune</option>
    <option>Nagpur</option>
    </Select>
  </div>
  <div class="form-group">
    <label for="pwd">Gender:</label>
    <% if(e.getGender().equals("Male")) 
    {
    %>
    <input type="radio" name="gender" value="Male"  id="pwd" checked="checked" />Male
    <input type="radio" name="gender" value="female"  id="pwd">Female
    <%
    }else
    {
    %>
    <input type="radio" name="gender" value="Male"  id="pwd"  />Male
    <input type="radio" name="gender" value="female"  id="pwd" checked="checked" />Female
    <%} 
    %>
  </div>
  <div class="form-group">
    <label for="pwd">Address:</label>
    <textarea name="address" class="form-control" id="pwd"><%=e.getAddress()%></textarea>
  </div>
  
  <button type="submit" class="btn btn-default" onclick="return confirm('Do you really want to Update?');">Update</button>
</form>
</div></div>
</div>


</body>
</html>