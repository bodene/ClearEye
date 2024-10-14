package buyGlassesOnline;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	private Customer customer;
	private List<Product> products;
	
	// Constructor
	public ShoppingCart(Customer customer) {
		this.customer = customer;
		this.products = new ArrayList<>();
	}

	// adds product to cart
	public void addToCart(Product product) {
		products.add(product);
		System.out.println(product.getName() + " added to cart");
	}

	public void proceedToCheckout() {
		System.out.println("Proceeding to checkout");	
	}
	
	// Calculate Shopping cart total
	public double calculateTotal() {
		double total = 0.0;
		
		// loop through to sum carts total
		for (Product product : products) {
			total += product.getPrice();
		}
		return total;
	}
	
	// Getters
	public Customer getCustomer() {
		return customer;
	}
	
	public List<Product> getProducts() {
		return products;
	}

}
