import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TestingSerialization {

	public static void main(String[] args) {
		List<String> strList = new ArrayList<>();
			strList.add("a");
			strList.add("b");
			strList.add("c");
			strList.add("d");
			if(strList.contains("a")){
				System.out.println("It is present");
				
			}else{
				System.out.println("not present");
			}
	}

}

class Customer implements Serializable{
	
	// member variables for Customer
    transient int customerId;
    String customerName;
    transient String customerSSN;
 
    // 3-arg parameterized constructor for Customer
    public Customer(int customerId, String customerName, 
            String customerSSN) {
        super();
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerSSN = customerSSN;
    }
    
	 private void writeObject(ObjectOutputStream objectOutputStream)
	            throws Exception {
	 
	        // 1st do, save using default serialization for all objects
	        objectOutputStream.defaultWriteObject();
	 
	        // temp variable
	        int tempCustId = 333 + customerId;
	        String tempCustSSN = "Test" + customerSSN;
	 
	        // saving customer Id and SSN, in encrypted version
	        objectOutputStream.writeInt(tempCustId);
	        objectOutputStream.writeObject(tempCustSSN);
	    }
	 
	 
	
}
