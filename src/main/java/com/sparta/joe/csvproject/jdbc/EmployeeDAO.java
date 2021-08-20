package com.sparta.joe.csvproject.jdbc;

import com.sparta.joe.csvproject.dto.EmployeeDTO;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.List;

public class EmployeeDAO {
    private Connection connection;
    private Statement statement;

    public EmployeeDAO(Connection connection) {
        this.connection = connection;

    }

    public void insertData(EmployeeDTO employee) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `employee_records`.`employees` (`emp_id`, `name_prefix`, `first_name`, `middle_initial`, `last_name`, `gender`, `email`, `date_of_birth`, `date_of_joining`, `salary`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, employee.getEmployeeID());
            preparedStatement.setString(2, employee.getNamePrefix());
            preparedStatement.setString(3, employee.getFirstName());
            preparedStatement.setString(4, employee.getMiddleInitial());
            preparedStatement.setString(5, employee.getLastName());
            preparedStatement.setString(6, employee.getGender());
            preparedStatement.setString(7, employee.getEmail());
            preparedStatement.setDate(8, new Date(employee.getDateOfBirth().getTime()));
            preparedStatement.setDate(9, new Date(employee.getDateOfJoining().getTime()));
            preparedStatement.setInt(10, employee.getSalary());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int tableCount() {
        int numOfRows = 0;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM `employee_records`.`employees`;");
            while(resultSet.next()) {
                numOfRows = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return numOfRows;
    }

}
