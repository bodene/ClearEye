package buyGlassesOnline;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;


class PrescriptionTest {
	private int defaultPrescID = 1234;
	private String defaultFirstName = "George";
	private String defaultLastName = "Flight";
	private String defaultAddress = "123 Flinders Street, Melbourne, VIC 3000";
	private float defaultSphere = 0.00f;
	private float defaultAxis = 90f;
	private float defaultCylinder = 0.00f;
	private String defaultExaminationDate = "21/11/24";
	private String defaultOptometrist = "Dr. Eyetester";
	private String[] remarkTypes= {"client", "optometrist"};
	
    @Test
    // Test Case 1: Testing valid addPrescription function
    public void testAddPrescriptionValid() {
        Prescription prescription = new Prescription();	
        //Test Data 1
        assertTrue(prescription.addPrescription(defaultPrescID, defaultFirstName, defaultLastName, defaultAddress, defaultSphere, defaultCylinder, defaultAxis, defaultOptometrist, defaultExaminationDate));
        
        // Test Data 2
        assertTrue(prescription.addPrescription(2, "Megan", "Brown", "456 Queen Street, Sydney, NSW 2000, Australia", -5.5f, 1.5f, 45f, "Dr. Alice Miller", "31/01/26"));
    }

    @Test
    // Test Case 2:  Testing invalid first name length
    public void testAddPrescriptionInvalidFirstName() {
        Prescription prescription = new Prescription();
        // Test Data 1
        assertFalse(prescription.addPrescription(defaultPrescID, "Jo", defaultLastName, defaultAddress, defaultSphere, defaultCylinder, defaultAxis, defaultOptometrist, defaultExaminationDate));

        // Test Data 2
        assertFalse(prescription.addPrescription(defaultPrescID, "Annabelle-Louise", defaultLastName, defaultAddress, defaultSphere, defaultCylinder, defaultAxis, defaultOptometrist, defaultExaminationDate));
    }

    @Test
    // Test Case 3:  Testing invalid address length
    public void testAddPrescriptionInvalidAddress() {
        Prescription prescription = new Prescription();
        // Test Data 1
        assertFalse(prescription.addPrescription(defaultPrescID, defaultFirstName, defaultLastName, "Short Address", defaultSphere, defaultCylinder, defaultAxis, defaultOptometrist, defaultExaminationDate));
   
        // Test Data 2
        assertFalse(prescription.addPrescription(defaultPrescID, defaultFirstName, defaultLastName, "Perth, WA 6000", defaultSphere, defaultCylinder, defaultAxis, defaultOptometrist, defaultExaminationDate));
    }

    @Test
    // Test Case 4: Testing invalid sphere values
    public void testAddPrescriptionInvalidSphere() {
        Prescription prescription = new Prescription();
        // Test Data 1
        assertFalse(prescription.addPrescription(defaultPrescID, defaultFirstName, defaultLastName, defaultAddress, 20.5f, defaultCylinder, defaultAxis, defaultOptometrist, defaultExaminationDate));
        
        // Test Data 2
        assertFalse(prescription.addPrescription(defaultPrescID, defaultFirstName, defaultLastName, defaultAddress, -20.5f, defaultCylinder, defaultAxis, defaultOptometrist, defaultExaminationDate)); 
    }
    
    @Test
    // Test Case 5: Testing invalid cylinder values
    public void testAddPrescriptionInvalidCylinder() {
        Prescription prescription = new Prescription();
        // Test Data 1
        assertFalse(prescription.addPrescription(defaultPrescID, defaultFirstName, defaultLastName, defaultAddress, defaultSphere, 5.0f, defaultAxis, defaultOptometrist, defaultExaminationDate));

        // Test Data 2
        assertFalse(prescription.addPrescription(defaultPrescID, defaultFirstName, defaultLastName, defaultAddress, defaultSphere, -5.0f, defaultAxis, defaultOptometrist, defaultExaminationDate));
    }
    
    @Test
    // Test Case 6: Testing invalid axis values
    public void testAddPrescriptionInvalidAxis() {
        Prescription prescription = new Prescription();
        // Test Data 1
        assertFalse(prescription.addPrescription(defaultPrescID, defaultFirstName, defaultLastName, defaultAddress, defaultSphere, defaultCylinder, -1f, defaultOptometrist, defaultExaminationDate));
        
        // Test Data 2
        assertFalse(prescription.addPrescription(defaultPrescID, defaultFirstName, defaultLastName, defaultAddress, defaultSphere, defaultCylinder, 181f, defaultOptometrist, defaultExaminationDate));
    }

    @Test
    // Test Case 7: Testing invalid optometrist name length
    public void testAddPrescriptionInvalidOptometrist() {
        Prescription prescription = new Prescription();
        // Test Data 1
        assertFalse(prescription.addPrescription(defaultPrescID, defaultFirstName, defaultLastName, defaultAddress, defaultSphere, defaultCylinder, defaultAxis, "Dr. J", defaultExaminationDate));
        
        // Test Data 2
        assertFalse(prescription.addPrescription(defaultPrescID, defaultFirstName, defaultLastName, defaultAddress, defaultSphere, defaultCylinder, defaultAxis, "Dr. Extremely Long Name for Optometrist", defaultExaminationDate));
    }
    
    @Test
    // Test Case 8: Invalid Date format
    public void testInvalidExaminationDateFormat() {
        Prescription prescription = new Prescription();
        // Test with incorrect date formats
        assertFalse(prescription.addPrescription(defaultPrescID, defaultFirstName, defaultLastName,
                defaultAddress, defaultSphere, defaultCylinder, defaultAxis, defaultOptometrist, "2024-10-21"));

        assertFalse(prescription.addPrescription(defaultPrescID, defaultFirstName, defaultLastName,
                defaultAddress, defaultSphere, defaultCylinder, defaultAxis, defaultOptometrist, "01/18/24"));
    }

    @Test
    // Test Case 9: Testing valid addRemark function
    public void testAddRemarkValid() {
        Prescription prescription = new Prescription();
        // Test Data 1
        assertTrue(prescription.addRemark(defaultPrescID, "This is a valid remark, Hooray!", "client"));
        
        // Test Data 2
        assertTrue(prescription.addRemark(defaultPrescID, "Another valid remark for testing purpose.", "optometrist"));    
    }
    
    @Test
    // Test Case 10: Testing invalid remark word count
    public void testAddRemarkInvalidWordCount() {
        Prescription prescription = new Prescription();
        // Test Data 1
        assertFalse(prescription.addRemark(defaultPrescID, "Too short", "client"));
        
        // Test Data 2
        assertFalse(prescription.addRemark(defaultPrescID, "This remark contains way too many words and should definitely exceed the twenty word limit set for remarks in the prescription system.", "optometrist"));
    }
    
    @Test
    // Test Case 11: Testing invalid remark category
    public void testAddRemarkInvalidCategory() {
        Prescription prescription = new Prescription();
        // Test Data 1
        assertFalse(prescription.addRemark(defaultPrescID, "This is a valid remark but invalid category.", "patient"));
        
        // Test Data 2
        assertFalse(prescription.addRemark(defaultPrescID, "Another valid remark but incorrect category.", "doctor"));
    }

    @Test
    // Test Case 12: Testing remark limit exceeded
    public void testAddRemarkLimitExceeded() {
        Prescription prescription = new Prescription();
        // Adding two valid remarks
        prescription.addRemark(defaultPrescID, "This is the first remark to be added.", "client");
        prescription.addRemark(defaultPrescID, "This is the second remark to be added.", "client");
        // Test Data 1: Adding a third remark, which should fail
        assertFalse(prescription.addRemark(defaultPrescID, "This is a third remark to be added.", "client"));     
    }

    @Test
    // Test Case 13: Testing remark begins with a capital letter
    public void testAddRemarkNoCapitalFirstLetter() {
        Prescription prescription = new Prescription();
        // Test Data 1
        assertFalse(prescription.addRemark(defaultPrescID, "this is a remark without a capital letter.", "client"));
        
        // Test Data 2
        assertFalse(prescription.addRemark(defaultPrescID, "!This is a remark starting with a symbol", "client"));       
    }
    
    @Test
    // Test Case 14: Testing invalid remark word count & invalid category
    public void testAddRemarkInvalidWordCountAndCategory() {
        Prescription prescription = new Prescription();
        // Test Data 1
        assertFalse(prescription.addRemark(defaultPrescID, "Too short", "patient"));
        
        // Test Data 2
        assertFalse(prescription.addRemark(defaultPrescID, "This remark contains way too many words and should definitely exceed the twenty word limit set for remarks in the prescription system.", "patient"));
    }

}
