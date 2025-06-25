import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.event.ActionEvent;

public class TestLoginPage {
    private login_page loginPage;

    @BeforeEach
    void setUp() {
        loginPage = new login_page();
        System.out.println("✅ Setup completed for LoginPageTest.");
    }

    @Test
    void testValidLogin() {
        loginPage.t1.setText("admin");
        loginPage.t2.setText("admin");

        ActionEvent e = new ActionEvent(loginPage.b1, ActionEvent.ACTION_PERFORMED, null);
        loginPage.actionPerformed(e);

        boolean frameClosed = !loginPage.frame.isVisible();
        System.out.println("✅ Test Valid Login: Frame closed? " + frameClosed);
        assertTrue(frameClosed, "Frame should be closed after successful login");
    }

    @Test
    void testInvalidLogin() {
        loginPage.t1.setText("wrongUser");
        loginPage.t2.setText("wrongPass");

        ActionEvent e = new ActionEvent(loginPage.b1, ActionEvent.ACTION_PERFORMED, null);
        loginPage.actionPerformed(e);

        boolean frameOpen = loginPage.frame.isVisible();
        System.out.println("✅ Test Invalid Login: Frame open? " + frameOpen);
        assertFalse(frameOpen, "Frame should remain open after failed login");
    }
}
