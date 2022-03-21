package hw8;
import java.util.concurrent.locks.ReentrantLock;

public class RunnableCancellablePrimeFactorizer extends RunnablePrimeFactorizer{
	private boolean done = false;
    private ReentrantLock lock = new ReentrantLock();

    public RunnableCancellablePrimeFactorizer(long dividend, long from, long to) {
        super(dividend, from, to);
    }
    
    public void setDone() {
        lock.lock();
        try {
            done = true;
        } finally {
            lock.unlock();
        }
    }
    public void generatePrimeFactors() {
        long divisors = from;
        while( dividend != 1 && divisors <= to ){
            lock.lock();
            try {
                if (done) break; 
                if (divisors > 2 && isEven(divisors)) {
                    divisors++;
                    continue;
                }
                if (dividend % divisors == 0) {
                    factors.add(divisors);
                    dividend = dividend / divisors;
                } else {
                    if (divisors == 2) {
                        divisors++;
                    } else {
                        divisors = divisors + 2;
                    }
                }
            } finally {
              lock.unlock();
            }
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  RunnableCancellablePrimeFactorizer factorizer = new RunnableCancellablePrimeFactorizer(36, 2, (long)Math.sqrt(36));
	        Thread thread = new Thread(factorizer);
	        System.out.println("Thread:: " + thread.getId() +
	                " factorization in given range:: " + factorizer.getFrom() + " --> " + factorizer.getTo());
	        thread.start();
	        factorizer.setDone();
	        try {
	            thread.join();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        System.out.println("result:: " + factorizer.getPrimeFactors() + "\n");
	}
}
