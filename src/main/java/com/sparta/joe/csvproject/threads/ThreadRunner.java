package com.sparta.joe.csvproject.threads;

import com.sparta.joe.csvproject.datainsertmanager.DataHandler;
import com.sparta.joe.csvproject.datainsertmanager.DataSplitter;
import com.sparta.joe.csvproject.dto.EmployeeDTO;
import com.sparta.joe.csvproject.jdbc.ConnectionManager;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class ThreadRunner {
    public static void threadRunner(int numOfThreads, List<EmployeeDTO> employeesClean) {
        List<DataHandler> dataHandlers = new ArrayList<>();

        List<EmployeeDTO>[] splitLists = DataSplitter.dataSplitter(employeesClean, numOfThreads);

        List<Thread> threadList = new ArrayList<>();
        for(int i = 0; i < numOfThreads ; i++) {
            dataHandlers.add(new DataHandler());
            dataHandlers.get(i).setEmployeeSegment(splitLists[i]);
            threadList.add(new Thread(dataHandlers.get(i)));
        }

        long startTime = System.nanoTime();
        for (Thread thread : threadList) {
            thread.start();
        }

        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long endTime = System.nanoTime();

        ConnectionManager.closeConnection();

        double totalExecutionTimeSeconds = (((endTime)-(startTime))/1000000000.0);
        NumberFormat format = new DecimalFormat("#0.000");
        System.out.println("Inserting " + employeesClean.size() + " records took " + format.format(totalExecutionTimeSeconds) + " seconds");
    }
}
