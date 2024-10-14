package buyGlassesOnline;

public class Customer {
	private String customerId;
	private String firstName;
	private String lastName;
	private String prescriptionLeft;
	private String prescriptionRight;
	private String email;

	// Constructor
	public Customer(String customerId, String firstName, String lastName, String email) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	// Getters
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getPrescriptionLeft() {
		return prescriptionLeft;
	}

	public void setPrescriptionLeft(String prescriptionLeft) {
		this.prescriptionLeft = prescriptionLeft;
	}

	public String getPrescriptionRight() {
		return prescriptionRight;
	}

	public void setPrescriptionRight(String prescriptionRight) {
		this.prescriptionRight = prescriptionRight;
	}	

}
