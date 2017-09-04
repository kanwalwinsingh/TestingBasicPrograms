
public class sss implements Runnable{

	public void run() {
		System.out.println("Thread Name = " + Thread.currentThread().getName() + ", Alive = " + Thread.currentThread().isAlive());
		
		
	}

}
