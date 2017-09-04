import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Java8Test {

	public static void main(String args[]){

//	      List<String> list =new ArrayList<String>();
//	      list.add("hi");
////	    list.add("how are you?");
////	    list.add("hi");
//	      list.add("good to see u..");
//	      list.add("nice meeting u");
//
//	      List<String> list1 = new ArrayList<>();
//	      list1.add("hi");
//	      list1.add("hello");
//	      list1.add("Thank u");
//	      list1.add("my pleasure");
//
//
//	      System.out.println("Start : " + list1);
//
//	      for (String string : list){
//
//	         list1.removeIf(value -> func(string,list1));
//	      }
//
//	      System.out.println("End : " +list1);
		for(int i=5;i<=20;i++){
		System.out.println("value of "+i +" for numeric with no Leading zero False is "+ countSerialNumber(String.valueOf(i),"NUMERIC",false)); 
		System.out.println("value of "+i +" for EFPIAUpperCase with no Leading zero False is "+countSerialNumber(String.valueOf(i),"EFPIAUpperCase",false)); 
		System.out.println("value of "+i +" for EFPIALowerCase with no Leading zero False is "+countSerialNumber(String.valueOf(i),"EFPIALowerCase",false));
		System.out.println("value of "+i +" for GS1UpperCase with no Leading zero False is "+countSerialNumber(String.valueOf(i),"GS1UpperCase",false)); 
		System.out.println("value of "+i +" for GS1LowerCase with no Leading zero False is "+countSerialNumber(String.valueOf(i),"GS1LowerCase",false)); 
		System.out.println("----------------------------------------------------------------------------------------------------------------------");
		System.out.println("value of "+i +" for numeric  with no Leading zero True is "+ countSerialNumber(String.valueOf(i),"NUMERIC",true)); 
		System.out.println("value of "+i +" for EFPIAUpperCase  with no Leading zero True is "+countSerialNumber(String.valueOf(i),"EFPIAUpperCase",true)); 
		System.out.println("value of "+i +" for EFPIALowerCase  with no Leading zero True  is "+countSerialNumber(String.valueOf(i),"EFPIALowerCase",true));
		System.out.println("value of "+i +" for GS1UpperCase  with no Leading zero True is "+countSerialNumber(String.valueOf(i),"GS1UpperCase",true)); 
		System.out.println("value of "+i +" for GS1LowerCase  with no Leading zero True is "+countSerialNumber(String.valueOf(i),"GS1LowerCase",true)); 
		System.out.println("***********************************************************************************************************************");
		}
	   }

	public static String countSerialNumber(final String snLength, final String charSet, final boolean isNoLeadingZero) {
		int i = 0;
		switch (charSet) {
			case "NUMERIC":
				i = 10;
				break;
			case "EFPIAUpperCase":
			case "EFPIALowerCase":
				i = 30;
				break;
			case "GS1UpperCase":
			case "GS1LowerCase":
				i = 36;
				break;
			default:
		}

		int snLengthInt = Integer.parseInt(snLength);
		final BigDecimal tenPowFour = new BigDecimal(10).pow(4);
		final BigDecimal snCount;

		if(isNoLeadingZero == Boolean.TRUE) {
			final BigDecimal numCharsMinusOne = (new BigDecimal(i - 1));
			snLengthInt -= 1;
			snCount = (numCharsMinusOne.multiply(new BigDecimal(i).pow(snLengthInt))).divide(tenPowFour);
		}
		else {
			snCount = (new BigDecimal(i).pow(snLengthInt)).divide(tenPowFour);
		}

		return snCount.setScale(0, BigDecimal.ROUND_FLOOR).toString();
	}
	


	    static int methodReturningValue()
	    {
	        int i = 0;
	 
	        try
	        {
	            i = 1;
	            return i;
	        }
	        catch (Exception e)
	        {
	            i = 2;
	        }
	        finally
	        {
	            i = 3;
	            return i;
	        }
	 
	   //     return i;
	    }



	
	
}
