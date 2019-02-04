package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.EmployeeBean;
import dao.MyDAO;

/**
 * Servlet implementation class EmpDelController
 */
@WebServlet("/EmpDelController")
public class EmpDelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpDelController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String empid=request.getParameter("empid");
	int eid=Integer.parseInt(empid);   
	MyDAO m=new MyDAO();
	 int x=   m.deleteEmp(eid);
	   if(x!=0)
	   {
		   RequestDispatcher rd=request.getRequestDispatcher("ViewEmp.jsp");
           request.setAttribute("msg",eid+" Deleted Successfully...");
          ArrayList<EmployeeBean> list= m.viewAllEmployee();
           request.setAttribute("LIST",list);
           
           rd.forward(request,response);
		   
	   }
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
