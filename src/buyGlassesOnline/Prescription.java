package buyGlassesOnline;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
	
	public boolean addPrescription(int prescID, String firstName, String lastName, String address, float sphere, float cylinder, float axis, String optometrist, Date examinationDate) {
		
		// Validation checks - If the prescription meets the given conditions,
		// First and last names must be between 4-15 characters.
		if (firstName.length() < 4 || firstName.length() > 15 || lastName.length() < 4 || lastName.length() > 15) {
			return false;
		}
		
		// Address must be at least 20 characters.
		if (address.length() < 20) {
			return false;
		}
		
		// Sphere between -20.00 and +20.00.
		if (sphere < -20.00 || sphere > 20.00) {
			return false;
		}
		
		// Cylinder between -4.00 and +4.00.
		if (cylinder < -4.00 || cylinder > 4.00) {
			return false;
		}
		
		// Axis between 0 and 180.
		if (axis < 0 || axis > 180) {
			return false;
		}
		
		// Optometrist's name must be between 8-25 characters.
		if (optometrist.length() < 8 || optometrist.length() > 25) {
			return false;
		}
		
		// Assigning values to instance variables
		this.prescID = prescID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.sphere = sphere;
		this.cylinder = cylinder;
		this.axis = axis;
		this.optometrist = optometrist;
		this.examinationDate = examinationDate;
		
		// Add prescription's information to a TXT file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("presc.txt", true))) {
            writer.write(prescID + ", " + firstName + ", " + lastName + ", " + address + ", " + sphere + ", " + cylinder + ", " + axis + ", " + optometrist + ", " + examinationDate.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
		
		return true;
	}
	
	public boolean addRemark(String remark, String category) {
		//TODO Add the prescriptions remark to a txt file
		
		// If the remark meets the given conditions
		// Checks to make sure there are not already 2 remarks
		if (postRemarks.size() >= 2) {
			return false;
		}
		// Checks that the comment starts with a capital and contains between 6 - 20 words
		if (!Character.isUpperCase(remark.charAt(0)) || remark.split(" ").length < 6 || remark.split(" ").length > 20) {
			return false;
		}
		
		// Checks that the category is either client or optometrist.
		if (!category.equals("client") && !category.equals("optometrist")) {
			return false;
		}
	
		// Information should be added to a txt file (e.g remark.txt), and the function should return True
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("remark.txt", true))) {
            writer.write(remark + " (" + category + ")");
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        postRemarks.add(remark);
        return true;
	}
	

}
