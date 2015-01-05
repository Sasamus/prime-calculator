package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author Albin Engström
 */
public class TestFrame extends JFrame {

	/**
	 * Generated serialVersionUID
	 */
	private static final long serialVersionUID = 372992706961939363L;
	
	JLabel jLabel;
	
	String text = "";

	public TestFrame() {
		jLabel = new JLabel("Hello World");
		add(jLabel);
		this.setSize(100, 100);
		// pack();
		setVisible(true);
	}
	
	public void update(long number){
		text = text + " " + Long.toString(number);
		jLabel.setText(text);
	}

}
