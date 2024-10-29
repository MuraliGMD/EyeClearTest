package Prescription;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Prescription {
    // Constants for validation
    private static final int MIN_NAME_LENGTH = 4;
    private static final int MAX_NAME_LENGTH = 15;
    private static final int MIN_ADDRESS_LENGTH = 20;
    private static final float MIN_SPHERE = -20.00f;
    private static final float MAX_SPHERE = 20.00f;
    private static final float MIN_CYLINDER = -4.00f;
    private static final float MAX_CYLINDER = 4.00f;
    private static final int MIN_AXIS = 0;
    private static final int MAX_AXIS = 180;
    private static final int MIN_OPTOMETRIST_LENGTH = 8;
    private static final int MAX_OPTOMETRIST_LENGTH = 25;
    private static final int MIN_REMARK_WORDS = 6;
    private static final int MAX_REMARK_WORDS = 20;
    private static final int MAX_REMARKS = 2;
    private static final String DATE_FORMAT = "dd/MM/yy";

    // Instance variables
    private int prescID;
    private String firstName;
    private String lastName;
    private String address;
    private float sphere;
    private float cylinder;
    private float axis;
    private Date examinationDate;
    private String optometrist;
    private String[] remarkTypes = {"Client", "Optometrist"};
    private ArrayList<String> postRemarks = new ArrayList<>();

    public Prescription(int prescID, String firstName, String lastName, String address, 
                       float sphere, float cylinder, float axis, String examinationDate, 
                       String optometrist) {
        this.prescID = prescID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.sphere = sphere;
        this.cylinder = cylinder;
        this.axis = axis;
        this.optometrist = optometrist;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
            this.examinationDate = sdf.parse(examinationDate);
        } catch (ParseException e) {
            logError("Invalid date format. Use DD/MM/YY", e);
        }
    }

    public boolean addPrescription() {
        // Condition 1: Name validation
        if (!isValidName(firstName) || !isValidName(lastName)) {
            return false;
        }

        // Condition 2: Address validation
        if (!isValidAddress(address)) {
            return false;
        }

        // Condition 3: Prescription details validation
        if (!isValidSphere(sphere) || !isValidCylinder(cylinder) || !isValidAxis((int)axis)) {
            return false;
        }

        // Condition 4: Date validation is handled in constructor

        // Condition 5: Optometrist name validation
        if (!isValidOptometrist(optometrist)) {
            return false;
        }

        try (FileWriter writer = new FileWriter("presc.txt", true)) {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
            String dateStr = sdf.format(examinationDate);
            
            writer.write(String.format("ID: %d, Name: %s %s, Address: %s, " +
                                     "Sphere: %.2f, Cylinder: %.2f, Axis: %.0f, " +
                                     "Date: %s, Optometrist: %s\n",
                                     prescID, firstName, lastName, address,
                                     sphere, cylinder, axis,
                                     dateStr, optometrist));
            return true;
        } catch (IOException e) {
            logError("Error writing prescription to file", e);
            return false;
        }
    }

    public boolean addRemark(String remark, String remarkType) {
        // Condition 1: Word count and capitalization
        if (remark == null || remarkType == null) {
            return false;
        }

        String[] words = remark.split("\\s+");
        if (words.length < MIN_REMARK_WORDS || words.length > MAX_REMARK_WORDS) {
            return false;
        }

        if (!Character.isUpperCase(remark.charAt(0))) {
            return false;
        }

        // Condition 2: Remark type and count validation
        if (!remarkType.equalsIgnoreCase("Client") && !remarkType.equalsIgnoreCase("Optometrist")) {
            return false;
        }

        if (postRemarks.size() >= MAX_REMARKS) {
            return false;
        }

        try (FileWriter writer = new FileWriter("remark.txt", true)) {
            writer.write(String.format("Prescription ID: %d, Type: %s, Remark: %s\n",prescID, remarkType, remark));
            postRemarks.add(remark);
            return true;
        } catch (IOException e) {
            logError("Error writing remark to file", e);
            return false;
        }
    }

    private boolean isValidName(String name) {
        return name != null && name.length() >= MIN_NAME_LENGTH && name.length() <= MAX_NAME_LENGTH;
    }

    private boolean isValidAddress(String address) {
        return address != null && address.length() >= MIN_ADDRESS_LENGTH;
    }

    private boolean isValidSphere(float sphere) {
        return sphere >= MIN_SPHERE && sphere <= MAX_SPHERE;
    }

    private boolean isValidCylinder(float cylinder) {
        return cylinder >= MIN_CYLINDER && cylinder <= MAX_CYLINDER;
    }

    private boolean isValidAxis(int axis) {
        return axis >= MIN_AXIS && axis <= MAX_AXIS;
    }

    private boolean isValidOptometrist(String optometrist) {
        return optometrist != null && 
               optometrist.length() >= MIN_OPTOMETRIST_LENGTH && 
               optometrist.length() <= MAX_OPTOMETRIST_LENGTH;
    }

    private void logError(String message, Exception e) {
        System.err.println(message);
        e.printStackTrace();
    }
}
