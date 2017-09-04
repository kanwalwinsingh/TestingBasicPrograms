import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo {

	private static final ExecutorService threadPool = Executors.newFixedThreadPool(3);

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FactorialCalculator task = new FactorialCalculator(10);
		System.out.println("Submitting Task ...");
		Future future = threadPool.submit(task);
		System.out.println("Task is submitted");
		while(!future.isDone()){
			System.out.println("Task is not completed yet...");
			Thread.sleep(1);
		}
		System.out.println("Task is completed, lets check results");
		long factorial = (long) future.get();
		System.out.println("Factorial of 1000000 is"+ factorial);
		
		threadPool.shutdown();


	}

	private static class FactorialCalculator implements Callable {

		private final int number;

		public FactorialCalculator(int number) {
			super();
			this.number = number;
		}

		@Override
		public Long call() throws Exception {

long output = 0;
try{
	output = factorial(number);
}
	catch(InterruptedException ex){
		ex.printStackTrace();
	}
return output;
		}

		private long factorial(int number) throws InterruptedException{
			if(number<0){
				throw new IllegalArgumentException("Number must be greater tha zero");
			}
			long result = 1;
			while(number>0){
				Thread.sleep(1);
				result = result*number;
				number--;
			}
			return result;
		}
	}
	
	

}
