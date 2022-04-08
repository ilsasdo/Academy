package it.finmatica.academy.solid.srp;


// single responsibility
// una cosa deve fare una cosa
public class Wrong {

    public static class Circle {
        private final int radius;

        public Circle(int radius) {
            this.radius = radius;
        }

        public int getRadius() {
            return radius;
        }

        public void printPerimeter() {
            System.out.println(2 * radius * 3.14);
        }
    }

}
