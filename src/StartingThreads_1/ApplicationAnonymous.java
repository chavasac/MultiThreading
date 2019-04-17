package StartingThreads_1;

public class ApplicationAnonymous {

	public static void main(String[] args) {
		Thread thread1 = new Thread(new Runnable() {

			@Override
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
			
		});
		
		Thread thread2 = new Thread(new Runnable() {

			@Override
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
			
		});
		
		thread1.start();
		thread2.start();

	}

}
