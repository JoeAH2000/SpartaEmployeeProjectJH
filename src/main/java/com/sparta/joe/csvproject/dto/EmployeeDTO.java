package com.sparta.joe.csvproject.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class EmployeeDTO {
    private int employeeID;
    private String namePrefix;
    private String firstName;
    private String middleInitial;
    private String lastName;
    private String gender;
    private String email;
    private Date dateOfBirth;
    private Date dateOfJoining;
    private int salary;

    public EmployeeDTO(String[] csvData) {
        this.employeeID = Integer.parseInt(csvData[0]);
        this.namePrefix = csvData[1];
        this.firstName = csvData[2];
        this.middleInitial = csvData[3];
        this.lastName = csvData[4];
        this.gender = csvData[5];
        this.email = csvData[6];

        try {
            this.dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(csvData[7]);
            this.dateOfJoining = new SimpleDateFormat("dd/MM/yyyy").parse(csvData[8]);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            System.out.println(employeeID);
        }

        this.salary = Integer.parseInt(csvData[9]);;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getNamePrefix() {
        return namePrefix;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDTO that = (EmployeeDTO) o;
        return employeeID == that.employeeID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeID);
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "employeeID=" + employeeID +
                ", namePrefix='" + namePrefix + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleInitial=" + middleInitial +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", dateOfJoining=" + dateOfJoining +
                ", salary=" + salary +
                '}';
    }
}
