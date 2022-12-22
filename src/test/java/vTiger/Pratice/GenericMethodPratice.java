package vTiger.Pratice;

public class GenericMethodPratice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = add(35,10);
		System.out.println(sum);
	}
//public static void add()
//{
//   int a = 20;
//	 int b = 20;
//   int c = a+b;
//	 System.out.println(c);
// }	
	
	public static int add(int a, int b)
	{
		int c = a+b;
		//System.out.println(c );
		return c;
	}
}
