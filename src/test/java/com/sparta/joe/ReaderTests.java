package com.sparta.joe;

import com.sparta.joe.csvproject.cleaner.CsvFileCleaner;
import com.sparta.joe.csvproject.dto.EmployeeDTO;
import com.sparta.joe.csvproject.reader.CsvFileReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class ReaderTests {

    @Test
    void fileReadCorrectTest() {
        ArrayList<EmployeeDTO> testEmployees = CsvFileReader.readFromFile("src/test/resources/TestInput.csv");
        ArrayList<EmployeeDTO> correctEmployees = new ArrayList<>();

        String[] employee1 = {"198429", "Mrs.", "Serafina", "I", "Bumgarner", "F", "serafina.bumgarner@exxonmobil.com", "9/21/1982", "2/1/2008", "69294"};
        correctEmployees.add(new EmployeeDTO(employee1));

        Assertions.assertEquals(correctEmployees, testEmployees);
    }
}