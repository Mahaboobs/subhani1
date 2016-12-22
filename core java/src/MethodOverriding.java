class Bank{  
int sum()
{
	return 0;
	}  
}  
  
class SBI extends Bank{  
int sum(){return 8;}  
}  
  
class ICICI extends Bank{  
int sum(){return 7;}  
}  
class AXIS extends Bank{  
int sum(){return 9;}  
}  
  
class Test2{  
public static void main(String args[]){  
SBI s=new SBI();  
ICICI i=new ICICI();  
AXIS a=new AXIS();  
System.out.println("SBI Rate of Interest: "+s.sum());  
System.out.println("ICICI Rate of Interest: "+i.sum());  
System.out.println("AXIS Rate of Interest: "+a.sum());  
}  
}  