package it.finmatica.academy.solid.srp;

import it.finmatica.academy.solid.fizzbuzz.tdd.FizzBuzz;
import it.finmatica.academy.solid.fizzbuzz.tdd.FizzBuzz.DivRule;
import it.finmatica.academy.solid.fizzbuzz.tdd.FizzBuzz.IdentityRule;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FizzBuzzTest {

    // stampa N numeri da 1 a N
    // se N divisibile per 3 stampa Fizz
    // se N divisibile per 5 stampa Buzz
    // se N divisibile per 3 e per 5 stampa FizzBuzz
    // altrimenti stampa N

    @Test
    public void da_1_a_n_stampa_fizzbuzz() {
        FizzBuzz fizzBuzz = new FizzBuzz(Arrays.asList(
            new DivRule(3 * 5, "FizzBuzz"),
            new IdentityRule()
        ));

        Assertions.assertEquals("1\n"
            + "2\n"
            + "3\n"
            + "4\n"
            + "5\n"
            + "6\n"
            + "7\n"
            + "8\n"
            + "9\n"
            + "10\n"
            + "11\n"
            + "12\n"
            + "13\n"
            + "14\n"
            + "FizzBuzz", fizzBuzz.print(15));
    }

    @Test
    public void se_N_divisibile_per_3_e_per_5_stampa_FizzBuzz() {
        DivRule rule = new DivRule(3 * 5, "FizzBuzz");

        Assertions.assertEquals("FizzBuzz", rule.print(15));
    }

    @Test
    public void per_ogni_numero_da_uno_a_n_stampa_fizz_buzz() {
        FizzBuzz fizzBuzz = new FizzBuzz(Arrays.asList(
            new DivRule(3, "Fizz"),
            new IdentityRule()
        ));

        Assertions.assertEquals("1\n2\nFizz", fizzBuzz.print(3));
    }

    @Test
    public void per_ogni_numero_stampa_se_stesso() {
        IdentityRule identityRule = new IdentityRule();

        Assertions.assertEquals("1", identityRule.print(1));
        Assertions.assertEquals("2", identityRule.print(2));
        Assertions.assertEquals("3", identityRule.print(3));
        Assertions.assertEquals("4", identityRule.print(4));
    }

    @Test
    public void per_ogni_numero_stampa_se_stesso_random() {

        // dato un input ben definito
        // ho un risultato atteso

        int random = (int) (Math.random() * 100 % 100);
        IdentityRule identityRule = new IdentityRule();
        Assertions.assertEquals(String.valueOf(random), identityRule.print(random));
    }

    @Test
    public void se_N_divisibile_per_3_stampa_Fizz() {
        int N = 3;
        int div = 3;

        Assertions.assertEquals("Fizz", new DivRule(div, "Fizz").print(N));
    }

    @Test
    public void se_N_non_e_divisibile_per_3_la_regola_non_deve_fare_match() {
        int N = 4;
        int div = 3;

        Assertions.assertEquals(false, new DivRule(div, "Fizz").match(N));
    }

    @Test
    public void se_N_divisibile_per_5_stampa_Buzz() {
        int N = 5;
        int div = 5;

        Assertions.assertEquals("Buzz", new DivRule(div, "Buzz").print(N));
    }
}
