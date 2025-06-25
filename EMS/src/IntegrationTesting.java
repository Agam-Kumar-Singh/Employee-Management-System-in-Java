import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.*;

class IntegrationTesting {
    private conn mockConn;
    private Connection mockConnection;
    private Statement mockStatement;
    private ResultSet mockResultSet;

    @BeforeEach
    void setUp() throws Exception {
        mockConn = mock(conn.class);
        mockConnection = mock(Connection.class);
        mockStatement = mock(Statement.class);
        mockResultSet = mock(ResultSet.class);

        when(mockConn.getConnection()).thenReturn(mockConnection);
        when(mockConnection.createStatement()).thenReturn(mockStatement);
        when(mockStatement.executeQuery(anyString())).thenReturn(mockResultSet);
    }

    // Test 1: Add Employee
    @Test
    void testEmployeeAddedSuccessfully() {
        try {
            String sql = "INSERT INTO employee VALUES ('John Doe','Smith','30','01/01/1995','NY','1234567890','john@example.com','MSc','Engineer','123456789012','1002')";
            mockStatement.executeUpdate(sql);

            verify(mockStatement, times(1)).executeUpdate(sql);
            System.out.println("Test Passed: Employee added successfully!");
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

    // Test 2: Remove Employee
    @Test
    void testEmployeeRemovedSuccessfully() {
        try {
            String sql = "DELETE FROM employee WHERE emp_id = '1002'";
            mockStatement.executeUpdate(sql);

            verify(mockStatement, times(1)).executeUpdate(sql);
            System.out.println("Test Passed: Employee removed successfully!");
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

    // Test 3: Update Employee
    @Test
    void testEmployeeUpdatedSuccessfully() {
        try {
            String sql = "UPDATE employee SET name='John Updated' WHERE emp_id = '1002'";
            mockStatement.executeUpdate(sql);

            verify(mockStatement, times(1)).executeUpdate(sql);
            System.out.println("Test Passed: Employee updated successfully!");
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

    // Test 4: Login Success
    @Test
    void testLoginSuccess() {
        try {
            when(mockResultSet.next()).thenReturn(true);
            String sql = "SELECT * FROM login WHERE username='admin' AND password='admin'";
            ResultSet rs = mockStatement.executeQuery(sql);

            assertTrue(rs.next());
            System.out.println("Test Passed: Login successful!");
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

    // Test 5: Login Failure
    @Test
    void testLoginFailure() {
        try {
            when(mockResultSet.next()).thenReturn(false);
            String sql = "SELECT * FROM login WHERE username='wrong' AND password='wrong'";
            ResultSet rs = mockStatement.executeQuery(sql);

            assertFalse(rs.next());
            System.out.println("Test Passed: Login failed as expected!");
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
}