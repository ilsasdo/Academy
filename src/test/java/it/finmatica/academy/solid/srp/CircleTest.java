package it.finmatica.academy.solid.srp;

import it.finmatica.academy.solid.srp.Right.Circle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CircleTest {

    // given ___ expect ___
    @Test
    public void dato_un_cerchio_ne_calcolo_l_area() {
        // setup
        Circle circle = new Circle(1);

        // execute
        double area = circle.area();

        // expect
        Assertions.assertEquals(3.14, area, "L'area di un cerchio di raggio 1 è 3.14");
    }

//    @Test
//    public void non_e_possibile_inserire_raggi_inferiori_a_zero() {
//        // setup
//        try {
//            new Circle(-1);
//            Assertions.fail("La classe Circle non deve essere istanziabile con raggi < 0");
//        } catch (IllegalArgumentException e) {
//            Assertions.assertEquals("un raggio non può essere negativo", e.getMessage());
//        }
//    }
//
    // issue: 1234, segnalato dal cliente pinco pallo
    @Test
    public void non_e_possibile_inserire_raggi_inferiori_a_zero_2() {
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> new Circle(-1)
        );
    }
}
