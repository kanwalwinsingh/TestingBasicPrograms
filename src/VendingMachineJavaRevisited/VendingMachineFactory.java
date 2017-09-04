package VendingMachineJavaRevisited;

public class VendingMachineFactory {

	public static VendingMachine createdVendingMachine(){
		return new VendingMachineImpl();
	}
}
