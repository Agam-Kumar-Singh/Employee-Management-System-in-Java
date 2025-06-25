import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.event.ActionEvent;

public class TestViewEmployee {
    private view_employee viewEmp;

    @BeforeEach
    void setUp() {
        viewEmp = new view_employee();
        System.out.println("✅ Setup completed for ViewEmployeeTest.");
    }

    @Test
    void testViewEmployee() {
        viewEmp.t.setText("E123");
        ActionEvent e = new ActionEvent(viewEmp.b1, ActionEvent.ACTION_PERFORMED, null);
        viewEmp.actionPerformed(e);

        boolean frameClosed = !viewEmp.frame.isVisible();
        System.out.println("✅ Test View Employee: Frame closed? " + frameClosed);
        assertTrue(frameClosed, "Frame should close when an employee is viewed");
    }

    @Test
    void testCancelButton() {
        ActionEvent e = new ActionEvent(viewEmp.b2, ActionEvent.ACTION_PERFORMED, null);
        viewEmp.actionPerformed(e);

        boolean frameClosed = !viewEmp.frame.isVisible();
        System.out.println("✅ Test Cancel Button: Frame closed? " + frameClosed);
        assertTrue(frameClosed, "Frame should close when cancel button is clicked");
    }
}
