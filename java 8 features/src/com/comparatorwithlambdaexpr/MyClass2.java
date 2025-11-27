package com.comparatorwithlambdaexpr;

import java.util.Comparator;

//Without Lambda Expression
public class MyClass2 implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
        return b - a; // For descending order
    }
}