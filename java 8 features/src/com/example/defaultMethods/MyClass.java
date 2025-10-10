package com.example.defaultMethods;

interface A {
    default void display() {
        System.out.println("Display method from interface A");
    }
}
class Child implements A {
    @Override
    public void display() {
        System.out.println("Display method from Child class");
    }
}
public class MyClass {
    public static void main(String[] args) {
        Child obj = new Child();
        obj.display(); // Calls the default method from interface A
    }
}
