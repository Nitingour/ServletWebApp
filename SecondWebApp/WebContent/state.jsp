 <%@page import="java.sql.Connection" %>
    <%@page import="java.sql.DriverManager" %>
      <%@page import="java.sql.PreparedStatement" %>
        <%@page import="java.sql.ResultSet" %>
  
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		
		$("#ss").hide();
		$("#state").change(function(){
			
			var data = "state="+$("#state").val();
			alert(data);
			$.ajax({
				//FetchData.jsp?state=mp
				url:'FetchCity.jsp',
				data:data,
				type:'post',
				success:function(response){
					$("#ss").show();
					$("#city").html(response);
				}
				
			});
			
		});
		
	});

</script>
  
  
  
 State: 
  <select name="state" id="state">
  <%
try
{	
	//loading the class		
	Class.forName("com.mysql.jdbc.Driver");
	
	//establishing connection  
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/empdb","root","root");

	String sql = "select distinct(state) from country ";
	
	PreparedStatement ps = con.prepareStatement(sql);
	ResultSet rs = ps.executeQuery();
	
	while(rs.next())
	{
		%>
		<option><%=rs.getString(1)%></option>
	    <%
	}
//end of start method try block
}
catch(Exception e)
{
	System.out.println("class Connect.start() exception"+e);
}
%>
</select>
<br/>
<div id="ss">
City:
<select id="city">
</select>
</div>

  