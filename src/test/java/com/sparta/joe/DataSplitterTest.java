package com.sparta.joe;

import com.sparta.joe.csvproject.datainsertmanager.DataSplitter;
import com.sparta.joe.csvproject.dto.EmployeeDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class DataSplitterTest {
    @Test
    void splitTest() {
        ArrayList<EmployeeDTO> uncleanEmployees = new ArrayList<>();
        ArrayList<EmployeeDTO> split1 = new ArrayList<>();
        ArrayList<EmployeeDTO> split2 = new ArrayList<>();

        String[] employee1 = {"198429", "Mrs.", "Serafina", "I", "Bumgarner", "F", "serafina.bumgarner@exxonmobil.com", "9/21/1982", "2/1/2008", "69294"};
        String[] employee2 = {"198429", "Mrs.", "Serafina", "I", "Bumgarner", "F", "serafina.bumgarner@exxonmobil.com", "9/21/1982", "2/1/2008", "69294"};
        uncleanEmployees.add(new EmployeeDTO(employee1));
        uncleanEmployees.add(new EmployeeDTO(employee2));
        split1.add(uncleanEmployees.get(0));
        split2.add(uncleanEmployees.get(1));

        List<EmployeeDTO>[] splitLists = DataSplitter.dataSplitter(uncleanEmployees, 2);

        Assertions.assertTrue((split1.equals(splitLists[0])) && split2.equals(splitLists[1]));
    }
}
