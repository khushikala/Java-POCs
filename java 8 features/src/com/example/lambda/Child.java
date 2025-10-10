package com.example.lambda;

@FunctionalInterface
public interface Child extends Parent{
//    public void sayBye(); // This will give error because Parent interface has one abstract method

    public void sayHello(); // This is inherited from Parent interface

    default void sayHi() {
        System.out.println("Hi from default method in Child");
    }
    static void sayWelcome() {
        System.out.println("Welcome from static method in Child");
    }
}
