import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.event.ActionEvent;

public class TestUpdateEmployee {
    private update_employee updateEmp;

    @BeforeEach
    void setUp() {
        updateEmp = new update_employee("123");
        System.out.println("✅ Setup completed for UpdateEmployeeTest.");
    }

    @Test
    void testShowEmployeeData() {
        boolean dataLoaded = !updateEmp.t1.getText().isEmpty();
        System.out.println("✅ Test Show Employee Data: Data loaded? " + dataLoaded);
        assertTrue(dataLoaded, "Employee data should be loaded into fields");
    }

    @Test
    void testUpdateEmployee() {
        updateEmp.t1.setText("NameUpdated");
        ActionEvent e = new ActionEvent(updateEmp.b, ActionEvent.ACTION_PERFORMED, null);
        updateEmp.actionPerformed(e);

        boolean frameClosed = !updateEmp.f.isVisible();
        System.out.println("✅ Test Update Employee: Frame closed? " + frameClosed);
        assertTrue(frameClosed, "Frame should close after updating an employee");
    }
}
