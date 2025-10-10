package com.diffBtwLambdaAndAnonymousFunc;

public class Main {
    public static void main(String[] args) {
        // Using a concrete class that implements the interface
//        Employee emp = new SoftwareEngineer();
//        System.out.println("Salary: " + emp.getSalary());
//        System.out.println("Designation: " + emp.getDesignation());

        // Using an anonymous class to implement the interface
        Employee emp2 = new Employee() {
            @Override
            public String getSalary() {
                return "20";
            }

            @Override
            public String getDesignation() {
                return "Manager";
            }
        };
        System.out.println("Salary: " + emp2.getSalary());
        System.out.println("Designation: " + emp2.getDesignation());
    }

    //variables and this in lambda expressions
    // In lambda expressions, you can access final or effectively final variables from the enclosing scope.
    // You cannot modify these variables within the lambda expression.
    // The 'this' keyword in a lambda expression refers to the enclosing instance where the lambda is defined.
    // In contrast, in anonymous classes, you can access and modify instance variables of the enclosing class.
    // The 'this' keyword in an anonymous class refers to the instance of the anonymous class itself.
}
