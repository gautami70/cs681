package hw5;
import java.util.concurrent.locks.ReentrantLock;

public class RunnableCancellablePrimeGenerator extends RunnablePrimeGenerator{

	private boolean done = false;
	private ReentrantLock lock = new ReentrantLock();

	public RunnableCancellablePrimeGenerator(long from, long to) {
		super(from, to);
	}
	public void setDone() {
		lock.lock();
		try { done = false; }
		finally { lock.unlock(); }
	}
	public void generatePrimes() {
		for (long l = from; l <= to; l++) {
			lock.lock();
			try {
				if (done) { break; }
				if (isPrime(l)) { this.primeNumbers.add(l); }
			} finally {
				lock.unlock();
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RunnableCancellablePrimeGenerator gen = new RunnableCancellablePrimeGenerator(1, 100);
		Thread thread = new Thread(gen);
		thread.start();
		gen.setDone();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		gen.primeNumbers().forEach((Long prime) -> System.out.print(prime + ", "));
		System.out.println("\n" + gen.primeNumbers().size() + " prime numbers: ");
	}
}
