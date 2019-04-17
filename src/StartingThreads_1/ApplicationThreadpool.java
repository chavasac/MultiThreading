package StartingThreads_1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class RunnableTask implements Runnable {
	public void run() {
		synchronized(this) {
			for (int i = 0; i < 5; i++) {
				System.out.println("Hello: " + i + " Thread: " + Thread.currentThread().getName());
				
				//This sleep was added so that output of threads wont be jumbled between one another.
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

class CallableTask implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		synchronized(this) {
			for (int i = 0; i < 5; i++) {
				System.out.println("Hello: " + i + " Thread: " + Thread.currentThread().getName());
				
				//This sleep was added so that output of threads wont be jumbled between one another.
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return i;
			}
		}
		return null;
	}
	
}

public class ApplicationThreadpool {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		
		executorService.submit(new RunnableTask());
		executorService.submit(new RunnableTask());
		Future<Integer> future1 = executorService.submit(new CallableTask());
		Future<Integer> future2 = executorService.submit(new CallableTask());
		
		executorService.shutdown();
		executorService.awaitTermination(5000, TimeUnit.DAYS);

	}

}
