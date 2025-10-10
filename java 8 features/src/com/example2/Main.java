package com.example2;

public class Main {
    public static void main(String[] args) {
//        Employee emp = new SoftwareEngineer();
        Employee emp = () -> "Software Engineer";
        System.out.println("Employee Role: " + emp.getName());
    }
}
