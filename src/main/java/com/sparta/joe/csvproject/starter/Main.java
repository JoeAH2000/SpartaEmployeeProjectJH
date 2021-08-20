package com.sparta.joe.csvproject.starter;

import com.sparta.joe.csvproject.cleaner.CsvFileCleaner;
import com.sparta.joe.csvproject.dto.EmployeeDTO;
import com.sparta.joe.csvproject.reader.CsvFileReader;
import com.sparta.joe.csvproject.threads.ThreadRunner;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<EmployeeDTO> employeesUnclean = CsvFileReader.readFromFile("src/main/resources/EmployeeRecordsLarge.csv");

        ThreadRunner.threadRunner(160, CsvFileCleaner.csvFileCleaner(employeesUnclean));
    }

}
