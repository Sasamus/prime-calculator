package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import calculation.NumberTester;
import calculation.SharedLong;

/**
 * @author Albin Engström
 */
public class BaseJFrame extends JFrame {

	/**
	 * Generated serialVersionUID
	 */
	private static final long serialVersionUID = 372992706961939363L;

	/**
	 * A final int to hold the width of the frame
	 */
	final int WIDTH = 800;

	/**
	 * A final int to hold the height of the frame
	 */
	final int HEIGHT = 500;

	/**
	 * A JTextField to show the found primes
	 */
	JTextArea jTextArea = new JTextArea("");

	/**
	 * A Long to hold the number of found primes
	 */
	SharedLong nrFoundPrimes = new SharedLong();

	/**
	 * A String to hold the text show before nrFoundPrimes
	 */
	String nrFoundPrimesText = "Primes found: ";

	/**
	 * A JLabel to show the number of found primes
	 */
	JLabel jLabelNrFoundPrimes = new JLabel(nrFoundPrimesText
			+ nrFoundPrimes.getValue());

	/**
	 * A JButton for start
	 */
	JButton jButtonStart = new JButton("Start");

	/**
	 * A JButton for stop
	 */
	JButton jButtonStop = new JButton("Stop");

	/**
	 * A JProgressBar to show how far the range have been processed
	 */
	JProgressBar jProgressBar = new JProgressBar(0, 100);

	/**
	 * The NumberTesters doing the work
	 */
	Vector<NumberTester> numberTesters = new Vector<NumberTester>();

	/**
	 * Number of numbers int the range
	 */
	long rangeSize;

	/**
	 * Constructor
	 * 
	 * @param rangeStart
	 *            The number the range starts at
	 * @param rangeStop
	 *            The number the range stops at
	 * @param chunkSize
	 *            The number numbers that one NumberTester should handle
	 * @param threads
	 *            The number of threads to use
	 */
	public BaseJFrame(long rangeStart, long rangeStop, long chunkSize,
			int threads) {

		// A FixedThreadPool for the NumberTesters
		final ExecutorService threadPool = Executors
				.newFixedThreadPool(threads);

		// Calculate the required number of "full" NumberTesters
		long nrOfNumberTesters = (long) Math.floor((rangeStop - rangeStart)
				/ chunkSize);

		// Get the remainder of the division
		long remainder = (rangeStop - rangeStart) % chunkSize;

		// If there are numbers left over, increment nrOfNumberTesters by one to
		// accommodate them
		if (remainder != 0) {

			nrOfNumberTesters++;
		}

		// Temporary range markers to work with
		long tmpRangeStart = rangeStart;
		long tmpRangeStop = rangeStart + chunkSize - 1;

		// Redo nrOfNumberTesters times
		for (long i = 0; i < nrOfNumberTesters; i++) {

			// If we are at the last nummberTester and it have a < chunkSize
			// workload
			if (i == nrOfNumberTesters - 1 && remainder != 0) {

				// Create a new NumberTester and add it to numberTesters, pass
				// rangeStop to it
				// it should stop at the final end of the range
				numberTesters.add((new NumberTester(jTextArea,
						jLabelNrFoundPrimes, nrFoundPrimesText, nrFoundPrimes,
						tmpRangeStart, rangeStop)));

			} else {

				// Create a new NumberTester and add it to numberTesters, pass
				// tmpRangeStop to it
				// it should stop at it's own personal end of range
				numberTesters.add((new NumberTester(jTextArea,
						jLabelNrFoundPrimes, nrFoundPrimesText, nrFoundPrimes,
						tmpRangeStart, tmpRangeStop)));

				// Increase the temporary range markers to fit the next one
				tmpRangeStart = tmpRangeStop + 1;
				tmpRangeStop = tmpRangeStart + chunkSize - 1;
			}

		}

		// Set rangeSize
		rangeSize = rangeStop - rangeStart + 1;

		// Set the size of the BaseJFrame
		setSize(WIDTH, HEIGHT);

		// Set layout of BaseJFrame
		setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

		// Create a JLabel to show the range for the user
		JLabel jLabelRangeText = new JLabel("Primes in range " + rangeStart
				+ "-" + rangeStop);

		// Align rangeText to the center
		jLabelRangeText.setAlignmentX(CENTER_ALIGNMENT);

		// Add rangeText to BaseJFrame
		add(jLabelRangeText);

		// Set jTextArea to Line Wrap
		jTextArea.setLineWrap(true);

		// Create a JScrollPane with jTextArea in it
		JScrollPane jScrollPane = new JScrollPane(jTextArea);

		// Set size of jScrollPane
		jScrollPane.setSize(WIDTH, 100);

		// Add jScrollPane to BaseJFrame
		add(jScrollPane);

		// Set value of jProgressBar
		jProgressBar.setValue(0);

		// Set jProgressbar to show the percentage in text
		jProgressBar.setStringPainted(true);

		// Add jProgressBar to BaseJFrame
		add(jProgressBar);

		// Create a JPanel for the buttons
		JPanel buttonPanel = new JPanel();

		// Set jButtonStart to execute the NumberTesters in numberTesters with
		// threadPool
		jButtonStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (NumberTester numberTester : numberTesters) {
					threadPool.submit(numberTester);
				}
			}
		});

		// Set jButtonStop to call the first NumberTester in numberTesters
		// cancel method
		jButtonStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (NumberTester numberTester : numberTesters) {
					numberTester.cancel(true);
				}
			}
		});

		// Add the buttons to buttonPanel
		buttonPanel.add(jButtonStart);
		buttonPanel.add(jButtonStop);

		// Add jLabelNrFoundPrimes to buttonPanel
		buttonPanel.add(jLabelNrFoundPrimes);

		// Add buttonPanel to JBaseFrame
		add(buttonPanel);

		// Set the JFrame to be visible
		setVisible(true);
	}
}
