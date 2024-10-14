package buyGlassesOnline;

public class Product {
	private String productName;
	private double productPrice;
	

	// Constructor
	public Product(String name, double price) {
		this.productName = name;
		this.productPrice = price;
	}
	
	// Getters
	public String getName() {
		return productName;
	}
	
	public double getPrice() {
		return productPrice;
	}

}
