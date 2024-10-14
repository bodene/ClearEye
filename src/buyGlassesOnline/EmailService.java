package buyGlassesOnline;

// Email Service System
public class EmailService {

	// Sends order confirmation email - TODO
	public void sendConfirmationEmail(ShoppingCart cart) {
		System.out.println("Sending confirmation email to: " + cart.getCustomer().getEmail());
	}

}
