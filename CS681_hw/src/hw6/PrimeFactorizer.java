package hw6;
import java.util.LinkedList;

public class PrimeFactorizer {

	protected long dividend, from, to;
	protected LinkedList<Long> factors = new LinkedList<Long>();
	
	public PrimeFactorizer(long dividend){
		if(dividend >= 2){
			this.dividend = dividend;
			this.from = 2;
			this.to = dividend;
		}else{
			throw new RuntimeException("dividend >= 2. dividend: " + dividend);
		}
	}

	public long getDividend() { return dividend; }
	public long getFrom(){ return from; }
	public long getTo(){ return to; }
	public LinkedList<Long> getPrimeFactors(){ return factors; }
	
	public void generatePrimeFactors() {
		long divisor = 2;
	    while( dividend != 1 && to >= divisor ){
		    if(dividend % divisor == 0) {
		        factors.add(divisor);
		        dividend /= divisor;
		    }else {
		    	if(divisor==2)  divisor++; 
		    	else  divisor += 2; 
		    }
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.print("Prime factors of 6:: ");
		PrimeFactorizer factorizer = new PrimeFactorizer(6);
		factorizer.generatePrimeFactors();
		System.out.println(factorizer.getPrimeFactors());
	
		System.out.print("Prime factors of 17:: ");
		factorizer = new PrimeFactorizer(17);
		factorizer.generatePrimeFactors();
		System.out.println(factorizer.getPrimeFactors());

		System.out.print("Prime factors of 131:: ");
		factorizer = new PrimeFactorizer(131);
		factorizer.generatePrimeFactors();
		System.out.println(factorizer.getPrimeFactors());
		
		System.out.print("Prime factors of 84:: ");
		factorizer = new PrimeFactorizer(84);
		factorizer.generatePrimeFactors();
		System.out.println(factorizer.getPrimeFactors());
		
		System.out.print("Prime factors of 125:: ");
		factorizer = new PrimeFactorizer(125);
		factorizer.generatePrimeFactors();
		System.out.println(factorizer.getPrimeFactors());
		
		System.out.print("Prime factors of 2489:: ");
		factorizer = new PrimeFactorizer(2489);
		factorizer.generatePrimeFactors();
		System.out.println(factorizer.getPrimeFactors());
		
		System.out.print("Prime factors of 8633:: ");
		factorizer = new PrimeFactorizer(8633);
		factorizer.generatePrimeFactors();
		System.out.println(factorizer.getPrimeFactors());
	}

}
