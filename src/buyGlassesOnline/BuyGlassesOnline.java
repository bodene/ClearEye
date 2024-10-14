package buyGlassesOnline;

public class BuyGlassesOnline {

	public static void main(String[] args) {
		Customer customer = new Customer("testcustomerId", "Joe", "Blow", "joe.blow@test.com");
		CatalogueService catalogueService = new CatalogueService();
		ShoppingCart shoppingCart = new ShoppingCart(customer);
		OrderingSystem orderingSystem = new OrderingSystem();
		
		// Step 1 - Browse Products
		catalogueService.browseProductCatalogue();
		
		// Step 2 - Add Product to Cart
		Product product = new Product("Example Glasses", 59.99);
		shoppingCart.addToCart(product);
		
		//Step 3 - Proceed to Checkout
		shoppingCart.proceedToCheckout();
		
		// Step 4 - Checkout
		orderingSystem.checkout(shoppingCart);

	}

}
