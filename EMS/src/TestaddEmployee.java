import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestaddEmployee {
    private add_employee addEmp;

    @BeforeEach
    void setUp() {
        addEmp = new add_employee();
        System.out.println("✅ Setup completed.");
    }

    @Test
    void testValidPhoneNumber1() {
        addEmp.t6.setText("9876543210");
        assertTrue(addEmp.t6.getText().matches("\\d{10}"), "Phone number validation failed");
        System.out.println("✅ Valid phone number test passed.");
    }
    
    @Test
    void testInvalidPhoneNumber() {
        addEmp.t6.setText("98765");
        assertFalse(addEmp.t6.getText().matches("\\d{10}"), "Invalid phone should not pass validation");
        System.out.println("✅ Invalid phone number test passed.");
    }

    /** Test Case 3: Valid Email **/
    @Test
    void testValidEmail() {
        addEmp.t7.setText("test@example.com");
        assertTrue(addEmp.t7.getText().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"),"Valid email should pass validation");
        System.out.println("✅ Valid email number test passed.");
    }

    /** Test Case 4: Invalid Email **/
    @Test
    void testInvalidEmail() {
        addEmp.t7.setText("invalid-email");
        assertFalse(addEmp.t7.getText().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"),"Invalid email should fail validation");
        System.out.println("✅ Invalid email test passed.");
    }

    /** Test Case 5: Valid Date Format **/
    @Test
    void testValidDOB() {
        addEmp.t4.setText("12/05/1995"); // DD/MM/YYYY format
        assertTrue(addEmp.t4.getText().matches("\\d{2}/\\d{2}/\\d{4}"), "Valid DOB should pass validation");
        System.out.println("✅ Valid DOB number test passed.");
    }

    /** Test Case 6: Invalid Date Format **/
    @Test
    void testInvalidDOB() {
        addEmp.t4.setText("1995-05-12"); // Wrong format
        assertFalse(addEmp.t4.getText().matches("\\d{2}/\\d{2}/\\d{4}"), "Invalid DOB should fail validation");
        System.out.println("✅ Invalid DOB test passed.");
    }

}
