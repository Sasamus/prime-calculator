package testing;

import gui.BaseJFrame;
import calculation.NumberTesterSwingWorker;

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

		BaseJFrame baseJFrame = new BaseJFrame(RANGE_START, RANGE_STOP);

		NumberTesterSwingWorker numberTesterSwingWorker = new NumberTesterSwingWorker(
				baseJFrame, RANGE_START, RANGE_STOP);

		numberTesterSwingWorker.run();

	}

}
