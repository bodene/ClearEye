package buyGlassesOnline;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Prescription {
	private int prescID;
	private String firstName;
	private String lastName;
	private String address;
	private float sphere;
	private float axis;
	private float cylinder;
	private Date examinationDate;
	private String optometrist;
	private String[] remarkTypes= {"Client", "Optometrist"};
	private ArrayList <String> postRemarks= new ArrayList<>();
	
	// Default Constructor 
	public Prescription() {
	}
	
	// Add prescription method validates and writes data to file presc.txt
	public boolean addPrescription(int prescID, String firstName, String lastName, String address, float sphere, float cylinder, float axis, String optometrist, String examinationDate) {
		
		// Assigning values
		this.prescID = prescID;
		
		// Calls helper methods to validate
		boolean isValid = setFirstName(firstName) &&
                		  setLastName(lastName) &&
                		  setAddress(address) &&
                		  setSphere(sphere) &&
                		  setCylinder(cylinder) &&
                		  setAxis(axis) &&
                		  setOptometrist(optometrist) &&
                		  setAndValidateDate(examinationDate);
		
		if (!isValid) {
			System.out.println("Failed to add prescription: Invalid input data.");
			return false;
		}
		
		// Format the date
        String formattedDate = new SimpleDateFormat("dd/MM/yy").format(this.examinationDate);
        
		// Details formatted & Save prescription details to file
        String content = prescID + ", " + firstName + ", " + lastName + ", " +
                         address + ", " + sphere + ", " + cylinder + ", " + 
                         axis + ", " + optometrist + ", " + formattedDate;
		
     // Write to file
        boolean success = writeToFile("presc.txt", content);
        if (success) {
            System.out.println("Prescription added.");
        }
        return success;
    }
	
	// Add Remark Method with Validation
	public boolean addRemark(int prescID, String remark, String category) {
		
		// Checks to make sure there are not already 2 remarks
		if (postRemarks.size() >= 2) {
			System.out.println("Cannot add more than 2 remarks.");
			return false;
		}
		// Checks that the comment starts with a capital and contains between 6 - 20 words
		if (!Character.isUpperCase(remark.charAt(0)) || remark.split(" ").length < 6 || remark.split(" ").length > 20) {
			System.out.println("Invalid remark, must start with a capital letter and be between 6-20 words long.");
			return false;
		}
		
		// Checks that the category is either client or optometrist.
		if (!category.equalsIgnoreCase("client") && !category.equalsIgnoreCase("optometrist")) {
			System.out.println("Invalid category.");
			return false;
		}
	
		// Information should be added to a txt file (e.g remark.txt), (also trim the comment to remove leading/trailing whitespace and the function should return True
		String content = prescID + ", " + remark.trim() + ", " + category;
		if (writeToFile("remark.txt", content)) {
            postRemarks.add(remark);
            return true;
        }
        return false;
    }
	
	
	// Helper Methods
	// Helper Method to write to file
	private boolean writeToFile(String filename, String content) {
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter("./" + filename, true))) {
	        writer.write(content);
	        writer.newLine();
	        return true;
	    } catch (IOException e) {
	        System.err.println("Error writing to file: " + filename);
	        e.printStackTrace();
	        return false;
	    }
	}
	
	// Helper Method validate Date format dd/MM/yy
	public boolean setAndValidateDate(String examinationDate) {
        // Define the expected date format: dd/MM/yy
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        dateFormat.setLenient(false);
        
        try {
        	this.examinationDate = dateFormat.parse(examinationDate);
            return true;
        } catch (ParseException e) {
            System.err.println("Invalid date format. Use 'dd/MM/yy'.");
            return false;
        }
    }
	
	// Helper method for name validation
    private boolean isValidName(String name) {
        return name != null && name.length() >= 4 && name.length() <= 15;
    }
	
	
	// Setters
	// Set First Name, using a helper method to validate
    public boolean setFirstName(String firstName) {
        if (isValidName(firstName)) {
        	this.firstName = firstName;
        	return true;
        }
        System.out.println("First name must be bweteen 4 & 15 characters.");
        return false;
    }
    
	// Set Last Name, using a helper method to validate
    public boolean setLastName(String lastName) {
        if (isValidName(lastName)) {
        	this.lastName = lastName;
        	return true;
        }
        System.out.println("Last name must be between 4 & 15 characters.");
        return false;
    }
    
    // Set address, if a min of 20 characters is met
    public boolean setAddress(String address) {
    	if (address.length() >= 20) {
    		this.address = address;
    		return true;
    	}
    	System.out.println("Address must be at least 20 characters long.");
    	return false;
    }
    
    // Set Sphere if between -20.00 and +20.00.
    public boolean setSphere(float sphere) {
        if (sphere >= -20.00f && sphere <= 20.00f) {
            this.sphere = sphere;
            return true;
        }
        System.out.println("Sphere value must be between -20.00 and +20.00.");
        return false;
    }

    // Set Axis if between 0 - 180
    public boolean setAxis(float axis) {
        if (axis >= 0f && axis <= 180f) {
            this.axis = axis;
            return true;
        }
        System.out.println("Axis value must be between 0 and 180.");
        return false;
    }
   
    // Set Cylinder if between -4.00 and +4.00.
    public boolean setCylinder(float cylinder) {
        if (cylinder >= -4.00f && cylinder <= 4.00f) {
            this.cylinder = cylinder;
            return true;
        }
        System.out.println("Cylinder value must be between -4.00 and +4.00.");
        return false;
    }

    // Set Optometrist's name if be between 8-25 characters.
    public boolean setOptometrist(String optometrist) {
        if (optometrist.length() >= 8 && optometrist.length() <= 25) {
            this.optometrist = optometrist;
            return true;
        }
        System.out.println("Optometrist name must be between 8 and 25 characters.");
        return false;
    }
    
    // Getters
    public int getPrescID() { return prescID; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getAddress() { return address; }
    public float getSphere() { return sphere; }
    public float getAxis() { return axis; }
    public float getCylinder() { return cylinder; }
    public Date getExaminationDate() { return examinationDate; }
    public String getOptometrist() { return optometrist; }
    public ArrayList<String> getPostRemarks() { return postRemarks; }
 	

}
