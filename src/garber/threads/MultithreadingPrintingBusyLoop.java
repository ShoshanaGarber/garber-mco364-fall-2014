package garber.threads;

import java.util.concurrent.CountDownLatch;



public class MultithreadingPrintingBusyLoop {

	public static void main(String args[]) throws InterruptedException {

		Thread threads[] = new Thread[5];
		final CountDownLatch latch = new CountDownLatch(5);
		for (int i = 0; i < threads.length; i++) {
			final int current = 1;
			threads[i] = new Thread() {
				public void run() {
					System.out.println(current);
					latch.countDown();
				}
			};
			threads[i].start();
		}

		int alive = threads.length;
		while (alive > 0) {
			alive = 0;
			for (int i = 0; i < threads.length; i++) {
				if (threads[i].isAlive()) {
					alive++;
				}
			}
		}
		latch.await();
		System.out.println("finished");
	}
}
