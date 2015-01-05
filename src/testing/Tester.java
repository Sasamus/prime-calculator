package testing;

import calculation.NumberTester;

/**
 * Class to test things
 * 
 * @author Albin Engström
 */
public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NumberTester numberTester = new NumberTester();
		
		numberTester.testNumbers(0, 100);
	}

}
