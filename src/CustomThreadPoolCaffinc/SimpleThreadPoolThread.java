package CustomThreadPoolCaffinc;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class SimpleThreadPoolThread extends Thread {

	private AtomicBoolean execute;
	private ConcurrentLinkedQueue<Runnable> runnables;
	public SimpleThreadPoolThread(String name, AtomicBoolean execute, ConcurrentLinkedQueue<Runnable> runnables) {
		super(name);
		this.execute = execute;
		this.runnables = runnables;
	}
	
	
	public void run(){
		try{
			while(execute.get() || !runnables.isEmpty())
			{
				Runnable runnable;
				while((runnable = runnables.poll())!= null){
					runnable.run();
				}
				Thread.sleep(1);
			}
		}catch(RuntimeException | InterruptedException e){
			System.out.println("An error occured "+ e.getMessage());
		}
		
	}
	
}
