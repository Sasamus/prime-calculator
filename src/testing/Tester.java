package testing;

import gui.BaseJFrame;
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
		
		BaseJFrame baseJFrame = new BaseJFrame();
		
		NumberTester numberTester = new NumberTester();
		
		numberTester.testNumbers(1, 100, baseJFrame);
		
		
	}

}
