package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MyDAO;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/xyz")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out=response.getWriter();
	  out.println("<h1>Hello Servlet</h1>");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String uid=request.getParameter("uid");
		String pass=request.getParameter("password");
		  MyDAO m=new MyDAO();
		 int y=m.loginCheck(uid,pass);
				if(y==1)
				{
		HttpSession session=request.getSession();
		session.setMaxInactiveInterval(30000);
		session.setAttribute("UID",uid);
		response.sendRedirect("AdminHome.jsp");
				}	//out.println("login success");
				else
				{
			 RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
             request.setAttribute("msg","Login Fail, try again...");
			 rd.forward(request,response);
					
				}
								
				
	}

}
