package gui;

import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * @author Albin Engström
 */
public class BaseJFrame extends JFrame {

	/**
	 * Generated serialVersionUID
	 */
	private static final long serialVersionUID = 372992706961939363L;

	/**
	 * A JTextField
	 */
	JTextField jTextField = new JTextField();

	/**
	 * A String to hold the text shown in jTextField
	 */
	String jTextFieldText = "";

	/**
	 * Constructor
	 */
	public BaseJFrame() {

		// Add jTextField to the JFrame
		add(jTextField);

		// Set the size of the JFrame
		setSize(500, 500);

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

		// Add number to jTextFieldText
		jTextFieldText = jTextFieldText + " " + Long.toString(number);

		// Set the text of jTextField to the new jTextFieldText
		jTextField.setText(jTextFieldText);
	}
}
