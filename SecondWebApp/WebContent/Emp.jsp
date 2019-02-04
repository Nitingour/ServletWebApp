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
  
 <form action="EmpInsertController" method="post" >
 
  <div class="form-group">
    <label for="pwd">Name:</label>
    <input type="text" name="name" class="form-control" id="pwd">
  </div>
   <div class="form-group">
    <label for="pwd">Salary:</label>
    <input type="text" name="salary" class="form-control" id="pwd">
  </div>
  <div class="form-group">
    <label for="pwd">City</label>
    <Select name="city" class="form-control" id="pwd">
    <option>-select-</option>
    <option>Mumbai</option>
    <option>Pune</option>
    <option>Nagpur</option>
    </Select>
  </div>
  <div class="form-group">
    <label for="pwd">Gender:</label>
    <input type="radio" name="gender" value="Male"  id="pwd">Male
    <input type="radio" name="gender" value="female"  id="pwd">Female
    
  </div>
  <div class="form-group">
    <label for="pwd">Address:</label>
    <textarea name="address" class="form-control" id="pwd"></textarea>
  </div>
  
  <button type="submit" class="btn btn-default">Submit</button>
</form>
</div></div>
</div>


</body>
</html>