import java.util.Arrays;

public class LeadersInArray {

	static void findTheLeaders(int inputArray[])
    {
        System.out.println("The leaders in "+Arrays.toString(inputArray)+" are :");
 
        for (int i = 0; i < inputArray.length; i++)
        {
            boolean flag = true;
 
            for (int j = i+1; j < inputArray.length; j++)
            {
                if (inputArray[j] > inputArray[i])
                {
                    flag = false;
 
                    break;
                }
            }
 
            if (flag)
            {
                System.out.println(inputArray[i]);
            }
        }
    }
 
    public static void main(String[] args)
    {
        findTheLeaders(new int[] {12, 9, 7, 14, 8, 6, 3});
 
        findTheLeaders(new int[] {8, 23, 19, 21, 15, 6, 11});
 
        findTheLeaders(new int[] {55, 67, 71, 57, 51, 63, 38});
 
        findTheLeaders(new int[] {21, 58, 44, 14, 51, 36, 23});
    }

}
