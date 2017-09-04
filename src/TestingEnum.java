
public class TestingEnum {

	public static void main(String[] args) {
	/*	Enums en = Enums.B; 
		System.out.println(en);
		 Enums en2 = Enums.C;   //No enum constant is created here.
		 
	        Enums en3 = Enums.A;*/
		 System.out.println(EnumOne.EnumTwo.TWO);
	}
	
	/*enum Enums
	{
	    A, B(10), C("ccc", 20);
	 
	    //No-arg private constructor
	 
	    private Enums()
	    {
	        System.out.println(1);
	    }
	 
	    //Private constructor taking one argument
	 
	    private Enums(int i)
	    {
	        System.out.println(2);
	    }
	 
	    //Private constructor taking two arguments
	 
	    private Enums(String s, int j)
	    {
	        System.out.println(3);
	    }
	}*/
	
	enum EnumOne
	{
	    ONE;
	     
	    {
	        System.out.println("ONE");
	    }
	     
	    enum EnumTwo
	    {
	        TWO;
	         
	        {
	            System.out.println("TWO");
	        }
	    }
	}
	 


}
