package com.sparta.joe;

import com.sparta.joe.csvproject.cleaner.CsvFileCleaner;
import com.sparta.joe.csvproject.dto.EmployeeDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CleanerTests {
    @Test
    void cleanTest() {
        ArrayList<EmployeeDTO> uncleanEmployees = new ArrayList<>();
        ArrayList<EmployeeDTO> cleanEmployees = new ArrayList<>();

        String[] employee1 = {"198429", "Mrs.", "Serafina", "I", "Bumgarner", "F", "serafina.bumgarner@exxonmobil.com", "9/21/1982", "2/1/2008", "69294"};
        String[] employee2 = {"198429", "Mrs.", "Serafina", "I", "Bumgarner", "F", "serafina.bumgarner@exxonmobil.com", "9/21/1982", "2/1/2008", "69294"};
        uncleanEmployees.add(new EmployeeDTO(employee1));
        uncleanEmployees.add(new EmployeeDTO(employee2));

        cleanEmployees.add(new EmployeeDTO(employee1));

        Assertions.assertEquals(cleanEmployees, CsvFileCleaner.csvFileCleaner(uncleanEmployees));
    }

    @Test
    void cleanEmptyTest() {
        ArrayList<EmployeeDTO> uncleanEmployees = new ArrayList<>();
        ArrayList<EmployeeDTO> cleanEmployees = new ArrayList<>();

        Assertions.assertEquals(cleanEmployees, CsvFileCleaner.csvFileCleaner(uncleanEmployees));
    }
}
