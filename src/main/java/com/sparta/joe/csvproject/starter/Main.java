package com.sparta.joe.csvproject.starter;

import com.sparta.joe.csvproject.cleaner.CsvFileCleaner;
import com.sparta.joe.csvproject.dto.EmployeeDTO;
import com.sparta.joe.csvproject.reader.CsvFileReader;
import com.sparta.joe.csvproject.threads.ThreadRunner;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String fileName = "src/main/resources/EmployeeRecordsLarge.csv";
        int numOfThreads = 160;
        ArrayList<EmployeeDTO> employeesUnclean = CsvFileReader.readFromFile(fileName);

        ThreadRunner.threadRunner(numOfThreads, CsvFileCleaner.csvFileCleaner(employeesUnclean));
    }

}
