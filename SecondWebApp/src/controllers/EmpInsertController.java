package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.EmployeeBean;
import dao.MyDAO;

/**
 * Servlet implementation class EmpInsertController
 */
@WebServlet("/EmpInsertController")
public class EmpInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
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
		
		
		
		MyDAO m=new MyDAO();
	int y=m.insertEmp(e);
		if(y!=0)
		{
			RequestDispatcher rd=request.getRequestDispatcher("Emp.jsp");
            request.setAttribute("msg","Data Inserted Successfully...");
			 rd.forward(request,response);
			
		}
		
		
	}

}
