package Connections;

import java.util.*;


public class Test 
{

	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		Employee employeeBean=new Employee();
		
		System.out.println("enter employee Id");
		employeeBean.setEmployeeId(input.nextInt());
		System.out.println("enter employee name");
		employeeBean.setEmployeeName(input.next());
		System.out.println("enter employee salary");
		employeeBean.setEmployeeSalary(input.nextDouble());
		System.out.println("enter employee emi");
		employeeBean.setEmployeeEmi(input.nextFloat());
		DataBaseOperations dbo=new DataBaseOperations();
		
		
		//int result=dbo.insertData(employeeBean);
		
	

        int result1=dbo.insertDataUsingPrepared(employeeBean);
		System.out.println(result1+ " data inserted");
			
	/*	int result=dbo.deleteData(employeeBean);
		System.out.println(result+"data deleted"); */
	
		
		System.out.println("enter employee Id to search");
		int employeeId=input.nextInt();
		
		  ArrayList<Employee> listOfEmp=  dbo.search(employeeId);
		  Iterator<Employee> itr=listOfEmp.iterator();
		 Employee employee=null;
		 System.out.println("Id \t Name \t salary \t emi \t");
		  while(itr.hasNext())
		  {
			  employee=(Employee)itr.next();
			  
			  System.out.println(employee.getEmployeeId()+"\t"+employee.getEmployeeName()+"\t"+employee.getEmployeeSalary()+"\t"+employee.getEmployeeEmi());
		  }
		  

	}

	private static void swith() {
		// TODO Auto-generated method stub
		
	}

}
