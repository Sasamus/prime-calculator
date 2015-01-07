package calculation;

import gui.BaseJFrame;

/**
 * Class that tests what numbers in a range are primes
 * 
 * @author Albin Engström
 */
public class NumberTester {

	/**
	 * Tests if numbers in a range is are primes and adds the primes to a
	 * BaseJFrame
	 * 
	 * @param rangeStart
	 *            The beginning of the range
	 * @param rangeStop
	 *            The end of the range
	 * @param baseJFrame
	 *            The BaseJFrame to update
	 */
	public void testNumbers(long rangeStart, long rangeStop, BaseJFrame baseJFrame) {

		// Run through the range
		for (long i = rangeStart; i < rangeStop; i++) {

			// Check if i is a prime
			if (PrimeTest.isPrime(i)) {

				// Add i to baseFrame
				baseJFrame.addNumber(i);
			}
		}
	}
}
