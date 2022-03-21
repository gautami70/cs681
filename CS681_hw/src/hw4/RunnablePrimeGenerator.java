package hw4;

public class RunnablePrimeGenerator extends PrimeGenerator implements Runnable {

	public RunnablePrimeGenerator(long from, long to) {
		super(from, to);
	}
	
	public void run() {
		generatePrimes();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				RunnablePrimeGenerator gen = new RunnablePrimeGenerator(1L, 2000000L);
				Thread t = new Thread(gen);

				long startTime = System.currentTimeMillis();
				t.start();
				
				try {
					t.join();
				} catch (InterruptedException e) {
				}

				long endTime = System.currentTimeMillis();
				float time1 = (endTime - startTime) / 1000F;
				
				gen.primeNumbers().forEach( (Long prime)->System.out.print(prime + ", ") );
				long primeNum = gen.primeNumbers().size();

				System.out.println("\n" + primeNum + " total prime numbers: ");

				RunnablePrimeGenerator gen1 = new RunnablePrimeGenerator(1L, 1000000L);
				RunnablePrimeGenerator gen2 = new RunnablePrimeGenerator(1000000L, 2000000L);
				Thread t1 = new Thread(gen1);
				Thread t2 = new Thread(gen2);

				startTime = System.currentTimeMillis();
				t1.start();
				t2.start();

				try {
					t1.join();
					t2.join();
				} catch (InterruptedException e) {
				}

				endTime = System.currentTimeMillis();
				float time2 = (endTime - startTime) / 1000F;

				long primeNumWithTwoThreads = gen1.primeNumbers().size() + gen2.primeNumbers().size() ;
				System.out.println("\n" + primeNumWithTwoThreads + " total prime numbers: .");
				System.out.println("Time for two threads: " + time2 + " seconds");


				RunnablePrimeGenerator gen3 = new RunnablePrimeGenerator(1L, 500000L);
				RunnablePrimeGenerator gen4 = new RunnablePrimeGenerator(500000L, 1000000L);
				RunnablePrimeGenerator gen5 = new RunnablePrimeGenerator(1000000L,1500000L);
				RunnablePrimeGenerator gen6 = new RunnablePrimeGenerator(1500000L, 2000000L);

				Thread t3 = new Thread(gen3);
				Thread t4 = new Thread(gen4);
				Thread t5 = new Thread(gen5);
				Thread t6 = new Thread(gen6);

				startTime = System.currentTimeMillis();
				t3.start();
				t4.start();
				t5.start();
				t6.start();

				try {
					t3.join();
					t4.join();
					t5.join();
					t6.join();
				} catch (InterruptedException e) {
				}

				endTime = System.currentTimeMillis();
				float time4 = (endTime - startTime) / 1000F;

				long primeNumWithFourThreads = gen3.primeNumbers().size() + gen4.primeNumbers().size() + gen5.primeNumbers().size() + gen6.primeNumbers().size() ;
				System.out.println("\n" + primeNumWithFourThreads + " total prime numbers: ");
				System.out.println("Time for Four threads: " + time4 + " seconds");

				RunnablePrimeGenerator gen7  = new RunnablePrimeGenerator(1L, 250000L);
				RunnablePrimeGenerator gen8  = new RunnablePrimeGenerator(250000L, 500000L);
				RunnablePrimeGenerator gen9  = new RunnablePrimeGenerator(500000L,750000L);
				RunnablePrimeGenerator gen10 = new RunnablePrimeGenerator(750000L, 1000000L);
				RunnablePrimeGenerator gen11 = new RunnablePrimeGenerator(1000000L, 1250000L);
				RunnablePrimeGenerator gen12 = new RunnablePrimeGenerator(1250000L, 1500000L);
				RunnablePrimeGenerator gen13 = new RunnablePrimeGenerator(1500000L,1750000L);
				RunnablePrimeGenerator gen14 = new RunnablePrimeGenerator(1750000L, 2000000L);

				Thread t7  = new Thread(gen7);
				Thread t8  = new Thread(gen8);
				Thread t9  = new Thread(gen9);
				Thread t10 = new Thread(gen10);
				Thread t11 = new Thread(gen11);
				Thread t12 = new Thread(gen12);
				Thread t13 = new Thread(gen13);
				Thread t14 = new Thread(gen14);

				startTime = System.currentTimeMillis();
				t7.start();
				t8.start();
				t9.start();
				t10.start();
				t11.start();
				t12.start();
				t13.start();
				t14.start();

				try {
					t7.join();
					t8.join();
					t9.join();
					t10.join();
					t11.join();
					t12.join();
					t13.join();
					t14.join();
				} catch (InterruptedException e) {
				}

				endTime = System.currentTimeMillis();
				float time8 = (endTime - startTime) / 1000F;

				long primeNumWithEightThreads = gen7.primeNumbers().size() + gen8.primeNumbers().size() + gen9.primeNumbers().size() + gen10.primeNumbers().size()
												+ gen11.primeNumbers().size() + gen12.primeNumbers().size() + gen13.primeNumbers().size() + gen14.primeNumbers().size() ;
				System.out.println("\n" + primeNumWithEightThreads + " total prime numbers: ");
				System.out.println("Time for Eight threads: " + time8 + " seconds");
	}

}
