package Controller;


import java.io.IOException;

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
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
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
		// TODO Auto-generated method stub
		
		
		String empid=request.getParameter("empid");
		String empname=request.getParameter("empname");
		String empsalary=request.getParameter("empsalary");
		String emplocation=request.getParameter("emplocation");
		String empexp=request.getParameter("empexp");
			double salary;
			float exp;
			try
			{
			salary=Double.parseDouble(empsalary);
			exp=Float.parseFloat(empexp);
			}catch(Exception e)
			{
				salary=0.0;
				exp=0.0f;
			}
			EmployeeBean empbean=new EmployeeBean();
			empbean.setEmpid(empid);
			empbean.setEmpname(empname);
			empbean.setEmpsalary(salary);
			empbean.setEmplocation(emplocation);
			empbean.setEmpexp(exp);
			DAOOperations dao=new DAOOperations();
			int result=dao.insertData(empbean);
			RequestDispatcher requestdis=request.getRequestDispatcher("Success.jsp");
		HttpSession session=request.getSession();
		session.setAttribute("empid", empid);
		if(result>0)
		{
			requestdis.forward(request, response);
		}

		}

	}


