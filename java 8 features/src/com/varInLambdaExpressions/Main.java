package com.varInLambdaExpressions;

public class Main {
    int a = 10;
        private void doSomething(){
//            int a = 10;
            Employee emp = () -> {
                a = 20;
                return "100";
            };
            System.out.println(emp.getSalary());
        }
}
