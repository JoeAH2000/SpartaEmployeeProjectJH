package com.sparta.joe;

import com.sparta.joe.csvproject.dto.EmployeeDTO;
import com.sparta.joe.csvproject.jdbc.ConnectionManager;
import com.sparta.joe.csvproject.jdbc.EmployeeDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JDBCTests {
    @Test
    void connectionManagerConnectionTest() {
        Connection connection = ConnectionManager.openConnection();

        Assertions.assertNotNull(connection);
    }

    @Test
    void employeeDAOInsertTest() {
        //ENSURE DATABASE IS TRUNCATED BEFORE RUNNING TEST
        Connection connection = ConnectionManager.openConnection();
        EmployeeDAO testDAO = new EmployeeDAO(connection);

        ArrayList<EmployeeDTO> cleanEmployees = new ArrayList<>();
        String[] employee1 = {"198429", "Mrs.", "Serafina", "I", "Bumgarner", "F", "serafina.bumgarner@exxonmobil.com", "9/21/1982", "2/1/2008", "69294"};
        cleanEmployees.add(new EmployeeDTO(employee1));

        testDAO.insertData(cleanEmployees.get(0));

        Statement statement;
        int id = 0;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `employee_records`.`employees`;");
            while(resultSet.next()) {
                id = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Assertions.assertEquals(198429, id);
    }
}
