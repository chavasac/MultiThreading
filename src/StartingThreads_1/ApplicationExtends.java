package StartingThreads_1;

class Runner extends Thread {
	
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


public class ApplicationExtends {

	public static void main(String[] args) {
		Runner runner1 = new Runner();
		runner1.start();
		
		Runner runner2 = new Runner();
		runner2.start();
	}

}
