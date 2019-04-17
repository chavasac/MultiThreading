package StartingThreads_1;

class RunnerRunnable implements Runnable {
	public void run() {
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

public class ApplicationRunnable {

	public static void main(String[] args) {
		Thread thread1 = new Thread(new RunnerRunnable());
		thread1.start();
		
		Thread thread2 = new Thread(new RunnerRunnable());
		thread2.start();
	}

}
