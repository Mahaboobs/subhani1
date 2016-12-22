package Model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;


public class DAOOperations {
	Connection connection;
	PreparedStatement preparestatement;
	ResultSet resultset;
	 
	public DAOOperations()
	{
		connection=MyConnections.getInstance().connec;
		
	}
	public int insertData(EmployeeBean empbean)
	{
		int result=0;
		String query="insert into emp values(?,?,?,?,?,?,?)";
		try {
			preparestatement =connection.prepareStatement(query);
			preparestatement.setString(1,empbean.getEmpid());
			preparestatement.setString(2,empbean.getEmpname());
			preparestatement.setDouble(3,empbean.getEmpsalary());
			preparestatement.setString(4,empbean.getEmplocation());
			preparestatement.setFloat(5,empbean.getEmpexp());
			preparestatement.setDouble(6,empbean.getEmploan());
			preparestatement.setDouble(7,empbean.getEmpemi());
			result=preparestatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return result;
		
	}

public void loan(EmployeeBean empbean)

{

ArrayList<EmployeeBean> ref=search();

Iterator<EmployeeBean> it=ref.iterator();
EmployeeBean ee=null;

while(it.hasNext())
{

ee=(EmployeeBean)it.next();

double empLoan=0.0;
double isalary=ee.getEmpsalary();

if(ee.getEmpexp()<=2 && ee.getEmpexp()>1 && ee.getEmpsalary()<=240000)
{
empLoan=isalary/2;
ee.setEmploan(empLoan);
double emi=((ee.getEmploan()*0.14+ee.getEmploan())/9);
ee.setEmpemi(emi);
System.out.println("Loan: "+"Rs"+empLoan);
System.out.println("Emi: "+"Rs"+emi);
}
else if(ee.getEmpexp()>2 && ee.getEmpexp()<=5 && ee.getEmpsalary()>=300000 && ee.getEmpsalary()<=500000)
{
empLoan=(3*isalary/4);
ee.setEmploan(empLoan);
double emi=((ee.getEmploan()*0.14+ee.getEmploan())/9);
ee.setEmpemi(emi);
System.out.println("Loan: "+"Rs"+empLoan);
System.out.println("Emi: "+"Rs"+emi);

}

else
{
System.out.println("Not Eligible For Loan");

}
}
}

public ArrayList<EmployeeBean> search()
{
	ArrayList<EmployeeBean> employeelist=new ArrayList<EmployeeBean>();
	String query="select * from emp";
	try
	{
	preparestatement=connection.prepareStatement(query);
	//preparedStatement.setString(1, searchElement);
	
	resultset=preparestatement.executeQuery();
	
	EmployeeBean empBean=null;
	while(resultset.next())
	{
		empBean=new EmployeeBean();
		empBean.setEmpid(resultset.getString(1));
		empBean.setEmpname(resultset.getString(2));
		empBean.setEmpsalary(resultset.getDouble(3));
		empBean.setEmplocation(resultset.getString(4));
		empBean.setEmpexp(resultset.getFloat(5));
		employeelist.add(empBean);	
	}
	}
 catch(SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}	return employeelist;	
}
public int delete(EmployeeBean empbean)
{int result=0;
String query="delete from emp where empid=?";
try {
	preparestatement =connection.prepareStatement(query);
	preparestatement.setString(1, empbean.getEmpid());
	result=preparestatement.executeUpdate();

} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	return result;
}
public int update(EmployeeBean empbean)
{
	int result=0;
	
	String query="update emp set  empname=?,emplocation=? where empid=?";
	try {
		
		preparestatement=connection.prepareStatement(query);
	//preparestatement.setString(1,empbean.getEmpid());
	preparestatement.setString(1,empbean.getEmpname());
	preparestatement.setString(2, empbean.getEmplocation());
	preparestatement.setString(3, empbean.getEmpid());
		
		 result=preparestatement.executeUpdate();
		//System.out.println("Updated sucessfully"+result);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result;
	
	
}

}
