package it.finmatica.academy.solid.fizzbuzz;

import java.io.PrintStream;

public class FizzBuzz {

    private final int n;

    public FizzBuzz(int n) {
        this.n = n;
    }

    public void print() {
        for (int i=0; i<n; i++) {
            if (i % 15 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }

}
