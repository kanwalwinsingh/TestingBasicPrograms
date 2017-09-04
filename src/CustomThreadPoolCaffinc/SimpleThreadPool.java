package CustomThreadPoolCaffinc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import com.sun.corba.se.impl.orbutil.threadpool.TimeoutException;
import com.sun.prism.paint.Stop;

public class SimpleThreadPool {

	
	private static AtomicInteger poolCount = new AtomicInteger(0);
	
	
	private ConcurrentLinkedQueue<Runnable> runnables;
	
	private AtomicBoolean execute;
	
	private List<SimpleThreadPoolThread> threads;
	
	
	private class ThreadpoolExecption extends RuntimeException {

		public ThreadpoolExecption(Throwable cause) {
			super(cause);
			// TODO Auto-generated constructor stub
		}
		
	}


	private SimpleThreadPool(int threadCount) {
		poolCount.incrementAndGet();
		this.runnables = new ConcurrentLinkedQueue<>();
		this.execute = new AtomicBoolean(true);
		this.threads = new ArrayList<>();
		
		for(int i=0;i<threadCount;i++){
			SimpleThreadPoolThread thread = new SimpleThreadPoolThread("SimpleThreadpool" + poolCount.get() + "Thread" + i, execute, runnables);
		}
	}
	
	
	public static SimpleThreadPool getInstance(){
		return getInstance(Runtime.getRuntime().availableProcessors());
	}
	
	public static SimpleThreadPool getInstance(int threadCount){
		return new SimpleThreadPool(threadCount);
	}
	
	public void execute(Runnable runnable){
		if(this.execute.get()){
			runnables.add(runnable);
		}else{
			throw new IllegalStateException("Threadpool terminating, unable to execute runnable");
		}
	}
	
	public void awaitTermination(long timeout) throws TimeoutException{
		if(this.execute.get()){
			 throw new IllegalStateException("Threadpool not terminated before awaiting termination");
		}
		long startTime = System.currentTimeMillis();
		while(System.currentTimeMillis()-startTime<=timeout){
			boolean flag = true;
			for(Thread thread : threads){
				if(thread.isAlive()){
					flag=false;
					break;
				}
				if(flag){
					return;
				}try{
				Thread.sleep(1);	
				}catch(InterruptedException e){
					throw new ThreadpoolExecption(e);
				}
			}
			throw new TimeoutException();
		}
	}
	
	public void terminate(){
		runnables.clear();
		stop();
	}
	
	public void stop(){
		execute.set(false);
	}
}
