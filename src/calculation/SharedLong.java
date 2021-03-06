package calculation;

/**
 * A class that wraps a long so it can be shared by reference
 * 
 * @author Albin Engström
 */
public class SharedLong {

	/**
	 * The long
	 */
	long value = 0;

	/**
	 * @return the value
	 */
	public synchronized long getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public synchronized void setValue(long value) {
		this.value = value;
	}
}
