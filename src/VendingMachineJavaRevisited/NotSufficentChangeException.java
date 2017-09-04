package VendingMachineJavaRevisited;

//Vending Machine throws this exception to indicate that it doesn't have sufficient change to complete this request.
public class NotSufficentChangeException extends RuntimeException {
private String message;

public NotSufficentChangeException(String string){
	this.message = string;
}

public String getMessage() {
	return message;
}
	
}
