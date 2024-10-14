package buyGlassesOnline;

import java.util.Scanner;

// Ordering system handles the checkout process
public class OrderingSystem {
	InventoryService inventoryService = new InventoryService();
	PaymentGateway paymentGateway = new PaymentGateway();
	EmailService emailService = new EmailService();

	// Checkout process, including stock confirmation, payment processing & loops and confirmation email
	public void checkout(ShoppingCart cart) {
		// Step 5 - Check Stock Availability
		boolean isStockAvailable = inventoryService.checkStock(cart);
		
		if (isStockAvailable) {
			// Step 6 - Process Payment
			double amount = cart.calculateTotal();
			boolean paymentSuccess = paymentGateway.processPayment(amount);
			
			if (paymentSuccess) {
				// Step 7 - Confirm Order
				confirmOrder(cart);
				emailService.sendConfirmationEmail(cart);
			}
			else {
				// Step 8 - Retry Payment Loop
				retryPayment(cart);
			}
		}
		else {
			System.out.println("Stock currently unavailable");
		}
	}

	// Handles the Retry payment loop
	private void retryPayment(ShoppingCart cart) {
		boolean retry = true;
		
		while (retry) {
			boolean paymentSuccess = paymentGateway.processPayment(cart.calculateTotal());
			if (paymentSuccess) {
				confirmOrder(cart);
				retry = false;
			}
			else {
				retry = askCustomerToRetry();
			}
		}	
	}

	// Asks customer to retry payment or cancel order
	private boolean askCustomerToRetry() {

		System.out.println("Retry payment? (y/n)");
		try (Scanner scanner = new Scanner(System.in)) {
			String input = scanner.nextLine();
			return input.equalsIgnoreCase("y");
		}
	}

	// Notification for confirmed order
	private void confirmOrder(ShoppingCart cart) {
		System.out.println("Order confirmed for: " + cart.getCustomer().getFirstName() + " " + cart.getCustomer().getLastName());	
	}

}
