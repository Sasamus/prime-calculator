package testing;

import gui.BaseJFrame;

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

		final long RANGE_START = 1;
		final long RANGE_STOP = 10000;

		BaseJFrame baseJFrame = new BaseJFrame(RANGE_START, RANGE_STOP, 100, 8);
	}

}
