/**
 * 
 */
package business;

/**
 * @author quanyang
 *
 */
public class CheckoutRecord {
	private CheckoutRecordEntry checkoutEntry;

	public CheckoutRecord(CheckoutRecordEntry checkoutEntry) {
		this.checkoutEntry = checkoutEntry;
	}

	/**
	 * @return the checkoutEntry
	 */
	public CheckoutRecordEntry getCheckoutEntry() {
		return checkoutEntry;
	}

	/**
	 * @param checkoutEntry the checkoutEntry to set
	 */
	public void setCheckoutEntry(CheckoutRecordEntry checkoutEntry) {
		this.checkoutEntry = checkoutEntry;
	}
	
}
