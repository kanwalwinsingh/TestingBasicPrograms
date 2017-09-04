package ThreadPoolImplCodeGeeks;

public class Task implements Runnable {

	private int num;
	
	
	public Task(int num) {
		super();
		this.num = num;
	}


	@Override
	public void run() {
		System.out.println("Task "+ num + " is running ");
		
	}

}
