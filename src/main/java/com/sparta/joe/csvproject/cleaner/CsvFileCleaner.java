package com.sparta.joe.csvproject.cleaner;

import com.sparta.joe.csvproject.dto.EmployeeDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CsvFileCleaner {
    public static List<EmployeeDTO> csvFileCleaner(ArrayList<EmployeeDTO> employees) {
        int originalSize = employees.size();
        List<EmployeeDTO> employeesClean = employees.stream().distinct().collect(Collectors.toList());
        System.out.println("Removed " + (originalSize-employeesClean.size()) + " duplicate records from file.");
        return employeesClean;
    }
}
