package it.finmatica.academy.solid.fizzbuzz;

import java.util.List;

public class FizzBuzzRefactored {

    private final int n;
    private final List<Rule> rules;

    public FizzBuzzRefactored(int n, List<Rule> rules) {
        this.n = n;
        this.rules = rules;
    }

    public void print() {
        for (int i = 0; i < n; i++) {
            for (Rule rule : rules) {
                rule.print(i);
            }
        }
    }

    public static class Rule {

        private final int i;
        private final String word;

        public Rule(int i, String word) {
            this.i = i;
            this.word = word;
        }

        public void print(int n) {
            if (n % i == 0) {
                System.out.println(word);
            }
        }
    }
}
