package testing;

import gui.BaseJFrame;

import javax.swing.WindowConstants;

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
		final long RANGE_STOP = 100000;

		BaseJFrame baseJFrame = new BaseJFrame(RANGE_START, RANGE_STOP, 10, 1);
		
		baseJFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

}
