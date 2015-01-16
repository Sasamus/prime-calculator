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

		// Define default arguments
		long rangeStart = 2;
		long rangeStop = 1500;
		long numbersPerWorker = 10;
		int threads = 8;

		// If the correct number of arguments are provided, apply them
		if (args.length == 3) {
			rangeStop = Long.parseLong(args[0]);
			numbersPerWorker = Long.parseLong(args[1]);
			threads = Integer.parseInt((args[2]));
		}

		// Create a BaseJFrame with the arguments
		BaseJFrame baseJFrame = new BaseJFrame(rangeStart, rangeStop,
				numbersPerWorker, threads);
		
		// Set it to exit on close
		baseJFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}

}
