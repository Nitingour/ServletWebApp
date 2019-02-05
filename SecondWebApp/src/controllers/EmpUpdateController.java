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
 * Servlet implementation class EmpUpdateController
 */
@WebServlet("/EmpUpdateController")
public class EmpUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String eid=request.getParameter("empid");//110
	MyDAO m=new MyDAO();
	EmployeeBean e=m.getEmpByEid(Integer.parseInt(eid));
	 RequestDispatcher rd=request.getRequestDispatcher("UpdateEmp.jsp");
     request.setAttribute("EMP",e);
	 rd.forward(request,response);
			

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String eid=request.getParameter("eid");
		String name=request.getParameter("name");
		String salary=request.getParameter("salary");
		String city=request.getParameter("city");
		String gender=request.getParameter("gender");
		String address=request.getParameter("address");

		EmployeeBean e=new EmployeeBean();
		e.setName(name);
		e.setAddress(address);
		e.setCity(city);
		e.setGender(gender);
		e.setSalary(Double.parseDouble(salary));
		e.setEid(Integer.parseInt(eid));
		
		
		MyDAO m=new MyDAO();
	   int y=m.updateEmp(e);
		if(y!=0)
		{
			RequestDispatcher rd=request.getRequestDispatcher("ViewEmp.jsp");
			  ArrayList<EmployeeBean> list= m.viewAllEmployee();
			   request.setAttribute("LIST",list);
			request.setAttribute("msg","Data Updated  Successfully...");
			 rd.forward(request,response);
			
		}
		
		
		
	}

}
