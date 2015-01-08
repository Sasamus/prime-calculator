package calculation;

import gui.BaseJFrame;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingWorker;

/**
 * Class that tests what numbers in a range are primes
 * 
 * @author Albin Engström
 */
public class NumberTester extends SwingWorker<List<Long>, Long> {

	/**
	 * The BaseJFrame used as a GUI
	 */
	BaseJFrame baseJFrame;

	/**
	 * The start of the range to test
	 */
	long rangeStart;

	/**
	 * The end of the range to check
	 */
	long rangeStop;

	/**
	 * The number of numbers in the range
	 */
	long nrOfNumbers;

	/**
	 * Found numbers
	 */
	List<Long> foundNumbers = new ArrayList<Long>();

	/**
	 * Constructor
	 * 
	 * @param textArea
	 *            The TextArea to print output to
	 * @param rangeStart
	 *            The start of the range
	 * @param longRangeStop
	 *            The end of the range
	 */
	public NumberTester(BaseJFrame baseJFrame, long rangeStart, long rangeStop) {

		// Initialize variables
		this.baseJFrame = baseJFrame;
		this.rangeStart = rangeStart;
		this.rangeStop = rangeStop;
		this.nrOfNumbers = rangeStop - rangeStart + 1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.SwingWorker#doInBackground()
	 */
	@Override
	protected List<Long> doInBackground() throws Exception {

		// Test Numbers
		testNumbers();

		// Return foundNumbers
		return foundNumbers;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.SwingWorker#done()
	 */
	@Override
	protected void done() {

		// Tell baseJFrame to add foundNumbers to it's numbers
		baseJFrame.addNumbers(foundNumbers);
	}

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
	public void testNumbers() {

		// Run through the range
		for (long i = rangeStart; i < rangeStop; i++) {

			// Check if the SwingWorker is cancelled
			if (!isCancelled()) {

				// Check if i is a prime
				if (PrimeTest.isPrime(i)) {

					// Add i to foundNumbers
					foundNumbers.add(i);

					// Set progress in percent
					setProgress((int) (100 * foundNumbers.size() / nrOfNumbers));
				}
			}
		}
	}
}
