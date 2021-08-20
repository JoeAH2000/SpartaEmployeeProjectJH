package com.sparta.joe.csvproject.datainsertmanager;

import com.sparta.joe.csvproject.dto.EmployeeDTO;
import com.sparta.joe.csvproject.jdbc.ConnectionManager;
import com.sparta.joe.csvproject.jdbc.EmployeeDAO;

import java.sql.Connection;
import java.util.List;

public class DataHandler implements Runnable {
    List<EmployeeDTO> employeeSegment;

    public void setEmployeeSegment(List<EmployeeDTO> employeeSegment) {
        this.employeeSegment = employeeSegment;
    }

    public void insertData() {
        Connection connection = ConnectionManager.openConnection();
        EmployeeDAO employeeDAO = new EmployeeDAO(connection);

        for (EmployeeDTO employee: employeeSegment) {
            employeeDAO.insertData(employee);
        }
    }

    @Override
    public void run() {
        insertData();
    }
}
