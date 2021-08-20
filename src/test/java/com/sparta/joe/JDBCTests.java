package com.sparta.joe;

import com.sparta.joe.csvproject.jdbc.ConnectionManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

public class JDBCTests {
    @Test
    void connectionManagerConnectionTest() {
        Connection connection = ConnectionManager.openConnection();

        Assertions.assertNotNull(connection);
    }

    @Test
    void employeeDAOInsertTest() {

    }
}
