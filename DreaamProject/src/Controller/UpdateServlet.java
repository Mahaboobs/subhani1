package Controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.EmployeeBean;
import Model.DAOOperations;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String empid=request.getParameter("empid");
		String empname=request.getParameter("empname");
		String emplocation=request.getParameter("emplocation");
		EmployeeBean empbean=new EmployeeBean();
		empbean.setEmpid(empid);
		empbean.setEmpname(empname);
		empbean.setEmplocation(emplocation);		
		DAOOperations dao=new DAOOperations();
		int result=dao.update(empbean);
		RequestDispatcher requestdis=request.getRequestDispatcher("emp.jsp");
	HttpSession session=request.getSession();
	session.setAttribute("empid", empid);
	if(result>0)
	{
		requestdis.forward(request, response);
	}
	}

}
