package lesson2.lecture.birdir.onetoone_factory;

public class CustShopCartFactory {
	public static Customer createCustomer(String name) {
		if(name == null) 
			throw new IllegalArgumentException("Customer name cannot be null");
		Customer cust = new Customer(name);
		
		//customer set in cart
		ShoppingCart cart = new ShoppingCart(cust);
		
		//cart set in customer
		cust.setCart(cart);
		
		return cust;
	}
	
	public static ShoppingCart createShoppingCart(Customer cust) {
		if(cust == null) 
			throw new IllegalArgumentException("Cannot create shopping cart with null Customer");
		ShoppingCart cart = new ShoppingCart(cust);
		//replace the cart that is currently stored in cust
		cust.setCart(cart);
		return cart;
	}
	
	
}
