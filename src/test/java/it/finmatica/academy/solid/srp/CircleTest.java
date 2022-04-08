package it.finmatica.academy.solid.srp;

import it.finmatica.academy.solid.srp.Right.Circle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Aggiungo un commento
 *
 */
public class CircleTest {

    // given ___ expect ___
    @Test
    public void dato_un_cerchio_ne_calcolo_l_area() {
        // setup
        Circle circle = new Circle(1);

        // execute
        double area = circle.area();

        // expect
        Assertions.assertEquals(Math.PI, area, "L'area di un cerchio di raggio 1 è 3.14");
    }

    // issue: 1234, segnalato dal cliente pinco pallo
    @Test
    public void non_e_possibile_inserire_raggi_inferiori_a_zero_2() {
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> new Circle(-1)
        );
    }
}
