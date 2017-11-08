package lesson5.lecture.factorymethods3.business;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		AddressDao dao = new AddressDao();
		List<Address> list = dao.getAllAddresses();
		System.out.println(list);
	}

}
