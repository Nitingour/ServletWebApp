
<%
 response.addHeader("pragma","no-cache");  //chrome
response.addHeader("cache-control","no-store"); //firefox
response.addHeader("expire","0"); //IE
%>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">EMS</a>
    </div>
    <ul class="nav navbar-nav">
    <li class="active"><a ><% String u=(String)session.getAttribute("UID");
    if(u==null)
    	response.sendRedirect("index.jsp");
    out.println("Welcome "+u);
    %></a></li>
      <li class="active"><a href="AdminHome.jsp">Home</a></li>
      <li><a href="Emp.jsp">Create Emp Account</a></li>
      <li><a href="ViewEmpController">View All Emp Accounts</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="LogoutController"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
    </ul>
  </div>
</nav>