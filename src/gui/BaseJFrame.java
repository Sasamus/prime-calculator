package gui;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

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
	 * A JTextField
	 */
	JTextArea jTextArea = new JTextArea();

	/**
	 * A String to hold the text shown in jTextArea
	 */
	String jTextAreaText = "";
	
	/**
	 * A JButton for start
	 */
	JButton jButtonStart = new JButton("Start");
	
	/**
	 * A JButton for stop
	 */
	JButton jButtonStop = new JButton("Stop");

	/**
	 * Constructor
	 */
	public BaseJFrame() {
		
		// Set the size of the BaseJFrame
		setSize(WIDTH, HEIGHT);

		// Set layout of BaseJFrame
		setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
		
		// Set jTextArea to Line Wrap
		jTextArea.setLineWrap(true);
		
		// Create a JScrollPane with jTextArea in it
		JScrollPane jScrollPane = new JScrollPane(jTextArea);
		
		// Set size of jScrollPane
		jScrollPane.setSize(WIDTH, 100);
		
		// Add jScrollPane to JBaseFrame
		add(jScrollPane);
		
		// Create a JPanel for the buttons
		JPanel buttonPanel = new JPanel();
		
		// Add the buttons to buttonPanel
		buttonPanel.add(jButtonStart);
		buttonPanel.add(jButtonStop);
		
		// Add buttonPanel to JBaseFrame
		add(buttonPanel);

		// Set the JFrame to be visible
		setVisible(true);
	}

	/**
	 * Adds a number to the String showed in jTextField
	 * 
	 * @param number
	 *            The number to add
	 */
	public void addNumber(long number) {

		// Add number to jTextAreaText
		jTextAreaText = jTextAreaText + " " + Long.toString(number);

		// Set the text of jTextField to the new jTextFieldText
		jTextArea.setText(jTextAreaText);
	}
}
