package com.example.lambda;

@FunctionalInterface
public interface MyInterface {
    public void sayHello();

    default void sayBye() {
        System.out.println("Bye from default method in MyInterface");
    }
    static void sayOk() {
        System.out.println("Ok from static method in MyInterface");
    }
}
