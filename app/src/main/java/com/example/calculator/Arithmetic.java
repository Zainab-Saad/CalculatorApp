package com.example.calculator;

import java.util.ArrayList;

public class Arithmetic {
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }


    int subtract(int a, int b) {
        return a - b;
    }

    double subtract(double a, double b) {
        return a - b;
    }


    int multiply(int a, int b) throws Exception {
        return Math.multiplyExact(a, b);
    }

    double multiply(double a, double b) {
        return a * b;
    }


    double divide(double a, double b) {
        return a / b;
    }

    long exponent(int a, int b) {
        double exp = Math.pow(a, b);
        return (long) exp;
    }

    double exponent(double a, double b) {
        return Math.pow(a, b);
    }
    int maxIndex(ArrayList<Integer> args){
    int max = 0;
    for(int i = 0; i < args.size() - 1; i++){
        if(Math.max(args.get(i), args.get(i+1)) > max) max = Math.max(args.get(i), args.get(i+1));
    }
    return max;
}
}

