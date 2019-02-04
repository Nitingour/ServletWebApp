<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
   <center>
<h1>Login Form</h1><hr/>

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
  
 <form action="xyz" method="post" >
  <div class="form-group">
    <label for="email">LoginID:</label>
    <input type="TEXT" name="uid"  class="form-control" id="email">
  </div>
  <div class="form-group">
    <label for="pwd">Password:</label>
    <input type="password" name="password" class="form-control" id="pwd">
  </div>
  <button type="submit" class="btn btn-default">Submit</button>
</form>
</div></div>
</div>
</center>

</body>
</html>