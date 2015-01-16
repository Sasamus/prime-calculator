package calculation;

import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

/**
 * Class that tests what numbers in a range are primes
 * 
 * @author Albin Engström
 */
public class NumberTester extends SwingWorker<Integer, Long> {

	/**
	 * The JTextArea used to show the found numbers
	 */
	JTextArea jTextArea;

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
	Long nrOfNumbers;

	/**
	 * The number of numbers that have been checked
	 */
	Long nrCheckedNumbers = (long) 0;

	/**
	 * Number of found numbers
	 */
	SharedLong nrFoundNumbers;

	/**
	 * A String to hold the text show before nrFoundPrimes
	 */
	String nrFoundNumbersText;

	/**
	 * A JLabel to show the number of found primes
	 */
	JLabel nrFoundNumbersLabel;

	public NumberTester(JTextArea numberOutput, JLabel foundNumbers,
			String foundNumbersText, SharedLong nrFoundNumbers,
			long rangeStart, long rangeStop) {

		// Initialize variables
		this.nrFoundNumbers = nrFoundNumbers;
		this.nrFoundNumbersLabel = foundNumbers;
		this.nrFoundNumbersText = foundNumbersText;
		this.jTextArea = numberOutput;
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
	protected Integer doInBackground() throws Exception {

		// Test Numbers
		testNumbers();

		// Return 0
		return 0;
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
		for (long i = rangeStart; i <= rangeStop; i++) {

			// Check if the SwingWorker is cancelled
			if (!isCancelled()) {

				// Increment nrCheckedNumbers
				nrCheckedNumbers++;

				// Check if i is a prime
				if (PrimeTest.isPrime(i)) {

					// Increment nrFoundNumbers
					nrFoundNumbers.setValue(nrFoundNumbers.getValue() + 1);

					// Publish i
					publish(i);
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.SwingWorker#process(java.util.List)
	 */
	@Override
	protected void process(List<Long> chunks) {

		// A String to hold the text
		String tmpString = "";

		// Iterate through chunks
		for (Long nr : chunks) {

			// Add nr to tmpString
			tmpString = tmpString + nr + ", ";
		}

		// Append tmpString to jTextArea
		jTextArea.append(tmpString);

		// Set progress in percent
		setProgress((int) (100 * (double) nrCheckedNumbers / (double) nrOfNumbers));

		// Set nrFoundNumbersLabel to show the new nrFoundNumbers
		nrFoundNumbersLabel.setText(nrFoundNumbersText
				+ nrFoundNumbers.getValue());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.SwingWorker#done()
	 */
	// @Override
	// protected void done() {
	//
	// // Set progress to 100
	// setProgress(100);
	// }
}
