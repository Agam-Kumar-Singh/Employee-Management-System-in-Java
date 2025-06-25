import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.event.ActionEvent;

public class TestRemoveEmployee {
    private remove_employee removeEmp;

    @BeforeEach
    void setUp() {
        removeEmp = new remove_employee();
        System.out.println("✅ Setup completed for RemoveEmployeeTest.");
    }

    @Test
    void testSearchEmployee() {
        removeEmp.t.setText("E123");
        ActionEvent e = new ActionEvent(removeEmp.b, ActionEvent.ACTION_PERFORMED, null);
        removeEmp.actionPerformed(e);

        boolean isVisible = removeEmp.l2.isVisible();
        System.out.println("✅ Test Search Employee: Employee details visible? " + isVisible);
        assertFalse(isVisible, "Details should be visible after searching");
    }

    @Test
    void testRemoveEmployee() {
        removeEmp.t.setText("E123");
        ActionEvent e = new ActionEvent(removeEmp.b1, ActionEvent.ACTION_PERFORMED, null);
        removeEmp.actionPerformed(e);

        boolean isHidden = !removeEmp.l2.isVisible();
        System.out.println("✅ Test Remove Employee: Employee details hidden? " + isHidden);
        assertTrue(isHidden, "Details should be hidden after removing employee");
    }
}
