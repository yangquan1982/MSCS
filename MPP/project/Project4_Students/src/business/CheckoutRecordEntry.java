/**
 * 
 */
package business;

import java.util.Date;

/**
 * @author quanyang
 *
 */
public class CheckoutRecordEntry {
	private Date checkoutDate;
	private Date DueDate;
	private BookCopy bookCopy;
	
	public CheckoutRecordEntry(Date checkoutDate, Date dueDate, BookCopy bookCopy) {
		this.checkoutDate = checkoutDate;
		DueDate = dueDate;
		this.bookCopy = bookCopy;
	}

	/**
	 * @return the checkoutDate
	 */
	public Date getCheckoutDate() {
		return checkoutDate;
	}

	/**
	 * @param checkoutDate the checkoutDate to set
	 */
	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	/**
	 * @return the dueDate
	 */
	public Date getDueDate() {
		return DueDate;
	}

	/**
	 * @param dueDate the dueDate to set
	 */
	public void setDueDate(Date dueDate) {
		DueDate = dueDate;
	}

	/**
	 * @return the bookCopy
	 */
	public BookCopy getBookCopy() {
		return bookCopy;
	}

	/**
	 * @param bookCopy the bookCopy to set
	 */
	public void setBookCopy(BookCopy bookCopy) {
		this.bookCopy = bookCopy;
	}
	
}
