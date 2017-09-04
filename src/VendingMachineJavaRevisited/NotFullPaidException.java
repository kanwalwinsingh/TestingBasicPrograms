package VendingMachineJavaRevisited;

//An Exception, thrown by Vending Machine when a user tries to collect an item, without paying the full amount
public class NotFullPaidException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private long remaining;
	
	public NotFullPaidException(String message, long remainig){
		this.message = message;
		this.remaining = remainig;
				
	}

	public String getMessage() {
		return message;
	}

	public long getRemaining() {
		return remaining;
	}
	
	

}
