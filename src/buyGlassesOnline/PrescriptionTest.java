package buyGlassesOnline;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;


class PrescriptionTest {
	
    @Test
    public void testAddPrescriptionValid() {
        Prescription prescription = new Prescription();
        Date date = new Date();
        boolean result = prescription.addPrescription(1, "George", "Flight", "123 Flinders Street, Melbourne, VIC 3000, Australia", 0.0f, 0.0f, 90.0f, "Dr. Smith", date);
        assertTrue(result);
    }

    @Test
    public void testAddPrescriptionInvalidFirstName() {
        Prescription prescription = new Prescription();
        Date date = new Date();
        boolean result = prescription.addPrescription(2, "Jo", "Flight", "123 Flinders Street, Melbourne, VIC 3000, Australia", 0.0f, 0.0f, 90.0f, "Dr. Smith", date);
        assertFalse(result);
    }

    @Test
    public void testAddPrescriptionInvalidAddress() {
        Prescription prescription = new Prescription();
        Date date = new Date();
        boolean result = prescription.addPrescription(3, "George", "Flight", "123 Flinders Street", 0.0f, 0.0f, 90.0f, "Dr. Smith", date);
        assertFalse(result);
    }

    @Test
    public void testAddPrescriptionInvalidSphere() {
        Prescription prescription = new Prescription();
        Date date = new Date();
        boolean result = prescription.addPrescription(4, "George", "Flight", "123 Flinders Street, Melbourne, VIC 3000, Australia", -21.0f, 0.0f, 90.0f, "Dr. Smith", date);
        assertFalse(result);
    }
    
    @Test
    public void testAddPrescriptionInvalidCylinder() {
        Prescription prescription = new Prescription();
        Date date = new Date();
        boolean result = prescription.addPrescription(5, "George", "Flight", "123 Flinders Street, Melbourne, VIC 3000, Australia", 0.0f, 5.0f, 90.0f, "Dr. Smith", date);
        assertFalse(result);
    }

    @Test
    public void testAddPrescriptionInvalidOptometrist() {
        Prescription prescription = new Prescription();
        Date date = new Date();
        boolean result = prescription.addPrescription(6, "George", "Flight", "123 Flinders Street, Melbourne, VIC 3000, Australia", 0.0f, 0.0f, 90.0f, "Dr. Who", date);
        assertFalse(result);
    }

    @Test
    public void testAddPrescriptionInvalidAxis() {
        Prescription prescription = new Prescription();
        Date date = new Date();
        boolean result = prescription.addPrescription(7, "George", "Flight", "123 Flinders Street, Melbourne, VIC 3000, Australia", 0.0f, 0.0f, 360.0f, "Dr. Smith", date);
        assertFalse(result);
    }

    @Test
    public void testAddRemarkValid() {
        Prescription prescription = new Prescription();
        boolean result = prescription.addRemark("This is a valid remark, Hooray!", "client");
        assertTrue(result);
    }
    
    @Test
    public void testAddRemarkInvalidCategory() {
        Prescription prescription = new Prescription();
        boolean result = prescription.addRemark("This is a valid remark, Hooray!", "invalidCategory");
        assertFalse(result);
    }

    @Test
    public void testAddRemarkInvalidLength() {
        Prescription prescription = new Prescription();
        boolean result = prescription.addRemark("Short", "client");
        assertFalse(result);
    }

    @Test
    public void testAddRemarkExceedsLimit() {
        Prescription prescription = new Prescription();
        prescription.addRemark("This is the first remark to be added.", "client");
        prescription.addRemark("This is the second remark to be added.", "client");
        boolean result = prescription.addRemark("This is a third remark to be added.", "client");
        assertFalse(result);
    }

    @Test
    public void testAddRemarkNoCapitalFirstLetter() {
        Prescription prescription = new Prescription();
        boolean result = prescription.addRemark("this is a remark without a capital letter.", "client");
        assertFalse(result);
    }

}
