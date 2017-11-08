package lesson7.lecture.enums3.java8;

import java.time.LocalDate;

// how to integerate with the other DisplayItems for processing?
/* DinosaurStatue is one of a kind -- it should be implemented as a singleton */
public enum DinosaurStatue implements DisplayItem { 
	Dinosaur_Item;
	
	public static final String OWNER = "Tom Ripley";
	public static final LocalDate RETURN_DATE = LocalDate.of(2017, 11, 1);
	public static final String NAME = "Tyrannosaurus";
	
	
	@Override
	public String getOwner() {
		return OWNER;
	}
	@Override
	public LocalDate getDateToReturnToOwner() {
		return RETURN_DATE;
	}
}
