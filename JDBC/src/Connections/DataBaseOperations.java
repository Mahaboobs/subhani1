package Connections;

import java.sql.*;
import java.util.ArrayList;


public class DataBaseOperations 
{
	Connection connection;
	java.sql.Statement statementRef;
	PreparedStatement statement;
	ResultSet resultSet;
	
	public DataBaseOperations()
	{
		MyConnection.getInstance();
		connection=MyConnection.connection;
	}
	
	public int insertData(Employee employee)
	{
		int result=0;
		
		String query="insert into employee values("+ employee.getEmployeeId()+','+"'"+employee.getEmployeeName()+"',"+employee.getEmployeeSalary()+ ")";
		try {
			statementRef=connection.createStatement();
			result=statementRef.executeUpdate(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	public int insertDataUsingPrepared(Employee employee)
	{
		int result=0;
		
		String query="insert into employee values(?,?,?,?)";
		
		try 
		{
			statement=connection.prepareStatement(query);
			
			statement.setInt(1, employee.getEmployeeId());
			statement.setString(2, employee.getEmployeeName());
			statement.setDouble(3, employee.getEmployeeSalary());
			statement.setFloat(4,employee.getEmployeeEmi());
            result=statement.executeUpdate();
			
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
		
		
	}
	/*public  int deleteData(Employee employee)
	{
		int result1=0;
	String query="delete from employee where EmployeeId='?'";
	
	
	
	
	
			try {
				statement=connection.prepareStatement(query);
				result1=statement.executeUpdate();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
				return result1;
	}*/

	
	
	
	public ArrayList<Employee> search()
	{
		ArrayList<Employee> listOfEmployee=new ArrayList<Employee>();
		
		Employee employeeRef=null;
		
		String query="select * from employee";
		
		try {
			statement=connection.prepareStatement(query);
			resultSet=statement.executeQuery();
			
			while(resultSet.next())
			{
				employeeRef=new Employee();
				employeeRef.setEmployeeId(resultSet.getInt(1));
				employeeRef.setEmployeeName(resultSet.getString(2));
				employeeRef.setEmployeeSalary(resultSet.getDouble(3));
				employeeRef.setEmployeeEmi(resultSet.getFloat(4));
				
				
				listOfEmployee.add(employeeRef);
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return listOfEmployee;
	}
	
	public ArrayList<Employee> search(int employeeId)
	{
		ArrayList<Employee> listOfEmployee=new ArrayList<Employee>();
		
		Employee employeeRef=null;
		
		String query="select * from employee where EmployeeId=?";
		
		try {
			statement=connection.prepareStatement(query);
			
			statement.setInt(1, employeeId);
			
			resultSet=statement.executeQuery();
			
			while(resultSet.next())
			{
				employeeRef=new Employee();
				employeeRef.setEmployeeId(resultSet.getInt(1));
				employeeRef.setEmployeeName(resultSet.getString(2));
				employeeRef.setEmployeeSalary(resultSet.getDouble(3));
				employeeRef.setEmployeeEmi(resultSet.getFloat(4));
				
				
				listOfEmployee.add(employeeRef);
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return listOfEmployee;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
