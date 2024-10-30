package Prescription;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PrescriptionTest {
    private String currentDate;

    @BeforeEach
    void setUp() {
        currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yy"));
        System.out.println("\n=== Test Setup ===");
        System.out.println("Current test date: " + currentDate);
    }

    // Test Scenario 1: Name Validation
    @Test
    void testNameValidation() {
        System.out.println("\n=== Name Validation Test ===");
        
        // Test Case 1: Minimum Length
        System.out.println("\nTesting Minimum Length Names:");
        System.out.println("Input: First Name: 'Mura' (length: 4)");
        System.out.println("Input: Last Name: 'Guru' (length: 4)");
        System.out.println("Expected: Should be accepted (minimum valid length)");
        
        Prescription prescription1 = new Prescription(
            1, "Mura", "Guru",
            "45 Anna Salai, Chennai TN 600002, India",
            1.50f, -2.00f, 90, currentDate, "Dr. Divakar Gajini"
        );
        boolean result1 = prescription1.addPrescription();
        System.out.println("Result: Names were " + 
            (result1 ? "accepted ✓" : "rejected ✗"));
        assertTrue(result1, "Minimum valid length names should be accepted");

        // Test Case 2: Maximum Length
        System.out.println("\nTesting Maximum Length Names:");
        System.out.println("Input: First Name: 'Mrunal' (length: 6)");
        System.out.println("Input: Last Name: 'MuraliThakur' (length: 11)");
        System.out.println("Expected: Should be accepted (within maximum length)");
        
        Prescription prescription2 = new Prescription(
            2, "Mrunal", "MuraliThakur",
            "45 Anna Salai, Chennai TN 600002, India",
            1.50f, -2.00f, 90, currentDate, "Dr. Divakar Gajini"
        );
        boolean result2 = prescription2.addPrescription();
        System.out.println("Result: Names were " + 
            (result2 ? "accepted ✓" : "rejected ✗"));
        assertTrue(result2, "Maximum valid length names should be accepted");
    }

    // Test Scenario 2: Address Validation
    @Test
    void testAddressValidation() {
        System.out.println("\n=== Address Validation Test ===");
        
        // Test Case 1: Minimum Length
        String minAddress = "123 MG Road Bangalore";
        System.out.println("\nTesting Minimum Length Address:");
        System.out.println("Input: '" + minAddress + "'");
        System.out.println("Input Length: " + minAddress.length() + " characters");
        System.out.println("Expected: Should be accepted (minimum required length)");
        
        Prescription prescription1 = new Prescription(
            3, "Murali", "Guru", minAddress,
            1.50f, -2.00f, 90, currentDate, "Dr. Divakar Gajini"
        );
        boolean result1 = prescription1.addPrescription();
        System.out.println("Result: Address was " + 
            (result1 ? "accepted ✓" : "rejected ✗"));
        assertTrue(result1, "Minimum length address should be accepted");

        // Test Case 2: Longer Address
        String longAddress = "42 Pantheon Road, Egmore, Chennai, Tamil Nadu 600008, India";
        System.out.println("\nTesting Longer Address:");
        System.out.println("Input: '" + longAddress + "'");
        System.out.println("Input Length: " + longAddress.length() + " characters");
        System.out.println("Expected: Should be accepted (valid longer address)");
        
        Prescription prescription2 = new Prescription(
            4, "Murali", "Guru", longAddress,
            1.50f, -2.00f, 90, currentDate, "Dr. Divakar Gajini"
        );
        boolean result2 = prescription2.addPrescription();
        System.out.println("Result: Address was " + 
            (result2 ? "accepted ✓" : "rejected ✗"));
        assertTrue(result2, "Longer address should be accepted");
    }

    // Test Scenario 3: Sphere Value Validation
    @Test
    void testSphereValidation() {
        System.out.println("\n=== Sphere Value Validation Test ===");
        
        // Test Case 1: Minimum Value
        System.out.println("\nTesting Minimum Sphere Value:");
        float minSphere = -20.00f;
        System.out.println("Input: Sphere value: " + minSphere);
        System.out.println("Expected: Should be accepted (minimum valid value)");
        
        Prescription prescription1 = new Prescription(
            5, "Murali", "Guru",
            "27 Church Street, Bangalore KA 560001, India",
            minSphere, -2.00f, 90, currentDate, "Dr. Divakar Gajini"
        );
        boolean result1 = prescription1.addPrescription();
        System.out.println("Result: Minimum sphere value was " + 
            (result1 ? "accepted ✓" : "rejected ✗"));
        assertTrue(result1, "Minimum sphere value should be accepted");

        // Test Case 2: Maximum Value
        System.out.println("\nTesting Maximum Sphere Value:");
        float maxSphere = 20.00f;
        System.out.println("Input: Sphere value: " + maxSphere);
        System.out.println("Expected: Should be accepted (maximum valid value)");
        
        Prescription prescription2 = new Prescription(
            6, "Murali", "Guru",
            "27 Church Street, Bangalore KA 560001, India",
            maxSphere, -2.00f, 90, currentDate, "Dr. Divakar Gajini"
        );
        boolean result2 = prescription2.addPrescription();
        System.out.println("Result: Maximum sphere value was " + 
            (result2 ? "accepted ✓" : "rejected ✗"));
        assertTrue(result2, "Maximum sphere value should be accepted");
    }

    // Test Scenario 4: Cylinder Value Validation
    @Test
    void testCylinderValidation() {
        System.out.println("\n=== Cylinder Value Validation Test ===");
        
        // Test Case 1: Minimum Value
        System.out.println("\nTesting Minimum Cylinder Value:");
        float minCylinder = -4.00f;
        System.out.println("Input: Cylinder value: " + minCylinder);
        System.out.println("Expected: Should be accepted (minimum valid value)");
        
        Prescription prescription1 = new Prescription(
            7, "Murali", "Guru",
            "15 Nungambakkam High Road, Chennai TN 600034, India",
            1.50f, minCylinder, 90, currentDate, "Dr. Divakar Gajini"
        );
        boolean result1 = prescription1.addPrescription();
        System.out.println("Result: Minimum cylinder value was " + 
            (result1 ? "accepted ✓" : "rejected ✗"));
        assertTrue(result1, "Minimum cylinder value should be accepted");

        // Test Case 2: Maximum Value
        System.out.println("\nTesting Maximum Cylinder Value:");
        float maxCylinder = 4.00f;
        System.out.println("Input: Cylinder value: " + maxCylinder);
        System.out.println("Expected: Should be accepted (maximum valid value)");
        
        Prescription prescription2 = new Prescription(
            8, "Murali", "Guru",
            "15 Nungambakkam High Road, Chennai TN 600034, India",
            1.50f, maxCylinder, 90, currentDate, "Dr. Divakar Gajini"
        );
        boolean result2 = prescription2.addPrescription();
        System.out.println("Result: Maximum cylinder value was " + 
            (result2 ? "accepted ✓" : "rejected ✗"));
        assertTrue(result2, "Maximum cylinder value should be accepted");
    }

    // Test Scenario 5: Invalid Data Validation
    @Test
    void testInvalidDataValidation() {
        System.out.println("\n=== Invalid Data Validation Test ===");
        
        // Test Case 1: Invalid Names
        System.out.println("\nTesting Invalid Name Lengths:");
        System.out.println("Input: First Name: 'Ram' (length: 3)");
        System.out.println("Input: Last Name: 'Raj' (length: 3)");
        System.out.println("Expected: Should be rejected (names too short)");
        
        Prescription prescription1 = new Prescription(
            9, "Ram", "Raj",
            "15 Nungambakkam High Road, Chennai TN 600034, India",
            1.50f, -2.00f, 90, currentDate, "Dr. Divakar Gajini"
        );
        boolean result1 = prescription1.addPrescription();
        System.out.println("Result: Invalid names were " + 
            (result1 ? "wrongly accepted ✗" : "correctly rejected ✓"));
        assertFalse(result1, "Names that are too short should be rejected");

        // Test Case 2: Invalid Measurements
        System.out.println("\nTesting Invalid Measurements:");
        System.out.println("Input: Sphere: -21.00 (Valid range: -20.00 to 20.00)");
        System.out.println("Input: Cylinder: -5.00 (Valid range: -4.00 to 4.00)");
        System.out.println("Input: Axis: 181 (Valid range: 0 to 180)");
        System.out.println("Expected: Should be rejected (measurements out of range)");
        
        Prescription prescription2 = new Prescription(
            10, "Murali", "Guru",
            "15 Nungambakkam High Road, Chennai TN 600034, India",
            -21.00f, -5.00f, 181, currentDate, "Dr. Divakar Gajini"
        );
        boolean result2 = prescription2.addPrescription();
        System.out.println("Result: Invalid measurements were " + 
            (result2 ? "wrongly accepted ✗" : "correctly rejected ✓"));
        assertFalse(result2, "Invalid measurements should be rejected");
    }

    // Test Scenario 6: Valid Remark Addition
    @Test
    void testValidRemarkAddition() {
        System.out.println("\n=== Valid Remark Addition Test ===");
        
        Prescription prescription = new Prescription(
            11, "Murali", "Guru",
            "15 Nungambakkam High Road, Chennai TN 600034, India",
            1.50f, -2.00f, 90, currentDate, "Dr. Divakar Gajini"
        );

        // Test Case 1: Minimum Word Count
        String remark1 = "This is a valid six word remark";
        System.out.println("\nTesting Minimum Word Count Remark:");
        System.out.println("Input: '" + remark1 + "'");
        System.out.println("Word Count: " + remark1.split("\\s+").length);
        System.out.println("Expected: Should be accepted (minimum required words)");
        
        boolean result1 = prescription.addRemark(remark1, "Client");
        System.out.println("Result: Remark was " + 
            (result1 ? "accepted ✓" : "rejected ✗"));
        assertTrue(result1, "Minimum word count remark should be accepted");

        // Test Case 2: Maximum Word Count
        String remark2 = "This is a valid remark with exactly twenty words to test the maximum limit of our system";
        System.out.println("\nTesting Maximum Word Count Remark:");
        System.out.println("Input: '" + remark2 + "'");
        System.out.println("Word Count: " + remark2.split("\\s+").length);
        System.out.println("Expected: Should be accepted (maximum allowed words)");
        
        boolean result2 = prescription.addRemark(remark2, "Optometrist");
        System.out.println("Result: Remark was " + 
            (result2 ? "accepted ✓" : "rejected ✗"));
        assertTrue(result2, "Maximum word count remark should be accepted");
    }

    // Test Scenario 7: Invalid Remark Validation
    @Test
    void testInvalidRemarkValidation() {
        System.out.println("\n=== Invalid Remark Validation Test ===");
        
        Prescription prescription = new Prescription(
            12, "Murali", "Guru",
            "15 Nungambakkam High Road, Chennai TN 600034, India",
            1.50f, -2.00f, 90, currentDate, "Dr. Divakar Gajini"
        );

        // Test Case 1: Too Few Words
        String shortRemark = "Only five words here now";
        System.out.println("\nTesting Too Few Words:");
        System.out.println("Input: '" + shortRemark + "'");
        System.out.println("Word Count: " + shortRemark.split("\\s+").length);
        System.out.println("Expected: Should be rejected (insufficient words)");
        
        boolean result1 = prescription.addRemark(shortRemark, "Client");
        System.out.println("Result: Short remark was " + 
            (result1 ? "wrongly accepted ✗" : "correctly rejected ✓"));
        assertFalse(result1, "Remark with too few words should be rejected");

        // Test Case 2: Invalid Type
        String validRemark = "This is a valid length remark but wrong type";
        System.out.println("\nTesting Invalid Remark Type:");
        System.out.println("Input: '" + validRemark + "'");
        System.out.println("Input Type: 'Doctor' (Valid types: Client, Optometrist)");
        System.out.println("Expected: Should be rejected (invalid type)");
        
        boolean result2 = prescription.addRemark(validRemark, "Doctor");
        System.out.println("Result: Invalid type was " + 
            (result2 ? "wrongly accepted ✗" : "correctly rejected ✓"));
        assertFalse(result2, "Remark with invalid type should be rejected");
    }

    // Test Scenario 8: Remark Limit Validation
    @Test
    void testRemarkLimitValidation() {
        System.out.println("\n=== Remark Limit Validation Test ===");
        
        Prescription prescription = new Prescription(
            13, "Murali", "Guru",
            "15 Nungambakk High Road, Chennai TN 600034, India",
            1.50f, -2.00f, 90, currentDate, "Dr. Divakar Gajini"
        );

        // Test Case 1: First Remark
        String remark1 = "This is the first valid remark for testing purposes";
        System.out.println("\nAdding First Remark:");
        System.out.println("Input: '" + remark1 + "'");
        System.out.println("Expected: Should be accepted (first remark)");
        
        boolean result1 = prescription.addRemark(remark1, "Client");
        System.out.println("Result: First remark was " + 
            (result1 ? "accepted ✓" : "rejected ✗"));
        assertTrue(result1, "First remark should be accepted");

        // Test Case 2: Second Remark
        String remark2 = "This is the second valid remark for testing purposes";
        System.out.println("\nAdding Second Remark:");
        System.out.println("Input: '" + remark2 + "'");
        System.out.println("Expected: Should be accepted (second remark)");
        
        boolean result2 = prescription.addRemark(remark2, "Optometrist");
        System.out.println("Result: Second remark was " + 
            (result2 ? "accepted ✓" : "rejected ✗"));
        assertTrue(result2, "Second remark should be accepted");

        // Test Case 3: Third Remark
        String remark3 = "This third remark should not be accepted at all";
        System.out.println("\nAttempting to Add Third Remark:");
        System.out.println("Input: '" + remark3 + "'");
        System.out.println("Expected: Should be rejected (exceeds remark limit)");
        
        boolean result3 = prescription.addRemark(remark3, "Client");
        System.out.println("Result: Third remark was " + 
            (result3 ? "wrongly accepted ✗" : "correctly rejected ✓"));
        assertFalse(result3, "Third remark should be rejected");
    }
}