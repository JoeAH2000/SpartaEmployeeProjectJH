package com.sparta.joe.csvproject.reader;

import com.sparta.joe.csvproject.dto.EmployeeDTO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CsvFileReader {
    public static ArrayList<EmployeeDTO> readFromFile(String fileName) {
        ArrayList<EmployeeDTO> employees = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();
            for (line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                employees.add(new EmployeeDTO(line.split(",")));
            }

            bufferedReader.close();
            fileReader.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File not found");
        }
        return employees;
    }
}
