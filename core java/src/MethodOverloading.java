
public class MethodOverloading { 
	int a;
	int b;

	 void sum(int a,int b)
	 {
		 System.out.println(a+b);
	 }
	 void sum(float a,float b,float c)
	 {
		 System.out.println(a+b+c);
	 }
	 public static void main(String[]args)
	 {
		 MethodOverloading obj=new MethodOverloading();
		 obj.sum(2, 7);
		 obj.sum(2,4,5);
		 
	 }
	 
}