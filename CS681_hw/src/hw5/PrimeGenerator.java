package hw5;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.LinkedList;
import java.util.List;

public class PrimeGenerator {

	protected long from, to;
	protected LinkedList<Long> primeNumbers = new LinkedList<Long>();

	public PrimeGenerator(long from, long to){
		if(from >= 1 && to > from){
			this.from = from;
			this.to = to;
		}else{
			throw new RuntimeException("Wrong input: from: " + from + " to: " + to);
		}
	}
	public LinkedList<Long> primeNumbers(){ return primeNumbers; };
	protected boolean isEvenNo(long n){
		if(n%2 == 0){ return true; }
		else{ return false; }
	}
	
	protected boolean isPrime(long n){
		if(n <= 1){ return false; }  
		if( n > 2 && isEvenNo(n) ){ return false; }
		long i;
        for (i = (long) Math.sqrt(n); n%i != 0 && i >= 1; i--){}
        if (i == 1){ return true; }
        else{ return false; }
	}

	public void generatePrimes(){
		for (long n = from; n <= to; n++) {
			if( isEvenNo(n) ){ primeNumbers.add(n); }
        }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				PrimeGenerator gen = new PrimeGenerator(1, 100);
				gen.generatePrimes();
				gen.primeNumbers().forEach( (Long prime)-> System.out.print(prime + ", ") );
				System.out.println("\n" + gen.primeNumbers().size() + " total prime numbers found.");

				PrimeGenerator gen2 = new PrimeGenerator(1, 100);
				List<Long> primes = LongStream.rangeClosed(gen2.from, gen2.to)
										.filter( (long n)->gen2.isPrime(n) )
										.boxed()
										.collect(Collectors.toList());
				primes.forEach( (Long prime)-> System.out.print(prime + ", ") );
				System.out.println("\n" + primes.size() + "total prime numbers found.");

				PrimeGenerator gen3 = new PrimeGenerator(1, 100);
				long size = LongStream.rangeClosed(gen3.from, gen3.to)
										.filter( (long n)->gen3.isPrime(n) )
										.reduce( 0L, (long count, long n)->{System.out.print(n + ", ");
																			return ++count;} );
				System.out.println("\n" + size + "total prime numbers found.");
	}

}
