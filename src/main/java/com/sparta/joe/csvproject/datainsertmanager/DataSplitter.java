package com.sparta.joe.csvproject.datainsertmanager;

import com.sparta.joe.csvproject.dto.EmployeeDTO;
import com.sparta.joe.csvproject.jdbc.EmployeeDAO;

import java.util.ArrayList;
import java.util.List;

public class DataSplitter {
    public static List<EmployeeDTO>[] dataSplitter(List<EmployeeDTO> unsplitList, int numOfThreads) {
        ArrayList<EmployeeDTO>[] splitList = new ArrayList[numOfThreads];

        for (int i = 0; i < numOfThreads; i++) {
            splitList[i] = new ArrayList<>();
        }

        for (int i = 0; i < unsplitList.size(); i++) {
            splitList[(i%numOfThreads)].add(unsplitList.get(i));
        }
        System.out.println("Split Data into " + numOfThreads + " lists.");
        return splitList;
    }
}
