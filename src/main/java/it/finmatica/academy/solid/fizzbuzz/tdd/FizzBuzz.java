package it.finmatica.academy.solid.fizzbuzz.tdd;

import java.util.List;

public class FizzBuzz {

    private final List<Rule> rules;

    public FizzBuzz(List<Rule> rules) {
        this.rules = rules;
    }

    public String print(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (Rule rule : rules) {
                if (rule.match(i)) {
                    sb.append(rule.print(i));
                    break;
                }
            }

            if (i < n) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public interface Rule {

        String print(int n);

        boolean match(int i);
    }

    public static class IdentityRule implements Rule {

        @Override
        public String print(int n) {
            return Integer.toString(n);
        }

        @Override
        public boolean match(int i) {
            return true;
        }
    }

    public static class DivRule implements Rule {

        private final int div;
        private final String word;

        public DivRule(int div, String word) {
            this.div = div;
            this.word = word;
        }

        public String print(int n) {
            return word;
        }

        @Override
        public boolean match(int i) {
            return (i % div == 0);
        }
    }
}
