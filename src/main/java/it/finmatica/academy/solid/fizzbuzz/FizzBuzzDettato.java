package it.finmatica.academy.solid.fizzbuzz;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FizzBuzzDettato {

    /*
     * dato un numero N per ogni numero da 0 a N
     * se il numero è divisibile per 3, stampa "Fizz"
     * se il numero è divisibile per 5, stampa "Buzz"
     * se il numero è divisibile per 3 e per 5, stampa "FizzBuzz"
     * se il numero è divisibile per 7 stampa "Bang"
     * altrimenti stampa il numero stesso
     */

    public static void main(String args[]) {
        List<Regola> list = Arrays.asList(
            new RegolaDivisore(15, "FizzBuzz"),
            new RegolaDivisore(11, "Guff"),
            new RegolaDivisore(9, "Poff"),
            new RegolaDivisore(7, "Bang"),
            new RegolaDivisore(5, "Buzz"),
            new RegolaDivisore(3, "Fizz"),
            new IdentityRegola()
        );

        fizzBuzz(list, 30);
    }

    public interface Regola {
        void print(int n);

        boolean match(int i);
    }

    public static class RegolaQuadrato implements Regola {

        @Override
        public void print(int n) {
            System.out.println("Pow");
        }

        @Override
        public boolean match(int i) {
            int sqrt = (int)Math.sqrt(i);
            return (sqrt * sqrt == i);
        }
    }

    public static class IdentityRegola implements Regola {

        @Override
        public boolean match(int i) {
            return true;
        }

        public void print(int n) {
            System.out.println(n);
        }
    }

    public static class RegolaDivisore implements Regola {

        private final int div;
        private final String word;

        public RegolaDivisore(int div, String word) {
            this.div = div;
            this.word = word;
        }

        @Override
        public boolean match(int i) {
            return isMultiplier(i,div);
        }

        public void print(int n) {
            if (isMultiplier(n, div)) {
                System.out.println(word);
            }
        }

        private boolean isMultiplier(int n, int div) {
            return (n % div) == 0;
        }
    }

    public static void fizzBuzz(List<Regola> regole, int n) {
        for (int i = 1; i < n; i++) {
            for (Regola regola : regole) {
                if (regola.match(i)) {
                    regola.print(i);
                    break;
                }
            }
        }
    }
}
