package lesson7.lecture.defaultmethods;

public class PersonInfoFullView implements NameAddress {
	private String firstName, middleName, lastName;
	private Address address;
	PersonInfoFullView(String first, String middle, String last, Address add) {
		this.firstName = first;
		this.middleName = middle;
		this.lastName = last;
		this.address= add;
	}
	
	public String getStreet() {
		return address.getStreet1();
	}
	public String getCity() {
		return address.getCity();
	}
	public String getState() {
		return address.getState();
	}
	public String getFullName() {
		return firstName + " " + middleName + " " + lastName;
	}
	public String getFullAddress() {
		return address.toString();
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
