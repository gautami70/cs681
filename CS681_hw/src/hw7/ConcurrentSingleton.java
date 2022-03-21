package hw7;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentSingleton implements Runnable{
		private ConcurrentSingleton() {};

		private static ConcurrentSingleton instance = null;
		private static ReentrantLock lock = new ReentrantLock();

		public static ConcurrentSingleton getInstance() {
			lock.lock();
			try {
				if (instance == null) {
					instance = new ConcurrentSingleton();
				}
				return instance;
			} finally {
				lock.unlock();
			}
		}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		for (int n = 0; n < 6; n++) {
			Thread thread = new Thread(() -> {
				System.out.println(ConcurrentSingleton.getInstance());
			});
			thread.start();
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
	}

}
