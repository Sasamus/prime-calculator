package testing;

import gui.BaseJFrame;

import javax.swing.SwingUtilities;
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

		final long RANGE_START = 2;
		final long RANGE_STOP = 10000;

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				BaseJFrame baseJFrame = new BaseJFrame(RANGE_START, RANGE_STOP,
						100, 1);

				baseJFrame
						.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			}
		});

	}

}
