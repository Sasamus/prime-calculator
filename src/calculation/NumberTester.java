package calculation;

import gui.TestFrame;

/**
 * Class that tests what numbers in a range are primes
 * 
 * @author Albin Engström
 */
public class NumberTester {
	
	public void testNumbers(long from, long to, TestFrame testFrame){
		
		for(long i = from; i < to; i++){
			if(PrimeTest.isPrime(i)){
				testFrame.update(i);
			}
		}
	}

}
