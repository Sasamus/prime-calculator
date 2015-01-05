package calculation;

/**
 * Class for testing if a number is a prime
 * 
 * @author Albin Engström
 */
public class PrimeTest {

	/**
	 * Tests if a number is a calculation
	 * 
	 * @param number
	 *            The number to test
	 * @return true if number is a calculation, else false
	 */
	public static boolean isPrime(long number) {
		long limit = (long) Math.sqrt(number) + 1;
		for (long i = 2; i < limit; ++i) {
			if ((number % i) == 0) {
				return false;
			}
		}
		return true;
	}

}
