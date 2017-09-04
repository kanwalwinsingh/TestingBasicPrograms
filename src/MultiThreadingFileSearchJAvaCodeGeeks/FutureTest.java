package MultiThreadingFileSearchJAvaCodeGeeks;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutureTest {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter directory(e.g /usr/local)");
		
		String dir = input.nextLine();
		System.out.println("Please enter keyword (e.g myFile)");
		
		String keyword = input.nextLine();
		
		MatchCounter countFiles = new MatchCounter(new File(dir), keyword);
		
		FutureTask<Integer> tsk = new FutureTask<>(countFiles);
		
		Thread thread = new Thread(tsk);
		thread.start();
		try{
			System.out.println(tsk.get() + " matching files.");
	
		}catch (ExecutionException e) {
			e.printStackTrace();
		 } catch (InterruptedException e) {
		 }

	}

}

class MatchCounter implements Callable<Integer>{
	
	private File dir;
	private String keyword;
	private int counter;
	
	

	public MatchCounter(File dir, String keyword) {
		super();
		this.dir = dir;
		this.keyword = keyword;
	}



	@Override
	public Integer call() throws Exception {

		counter  = 0;
		try{
		File[] files = dir.listFiles();
		ArrayList<Future<Integer>> results = new ArrayList<Future<Integer>>();
		
		for(File file : files){
			if(file.isDirectory()){
				MatchCounter counter = new MatchCounter(file, keyword);
				FutureTask<Integer> task = new FutureTask<Integer>(counter);
				results.add(task);
				
				Thread t = new Thread(task);
				t.start();
			}else{
				if(search(file)){
					counter++;
				}
			}
		}
		
		for(Future<Integer> result : results){
			try{
				counter+=result.get();
			}catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		return counter;
	}
	
	public boolean search(File file){
		try{
			Scanner in = new Scanner(new FileInputStream(file));
			boolean found = false;
			while(!found && in.hasNextLine()){
				String line = in.nextLine();
				if(line.contains(keyword)){
					found = true;
				}
			}
			in.close();
			return found;
		}catch (IOException e) {
			return false;
		}
	}
	
}
