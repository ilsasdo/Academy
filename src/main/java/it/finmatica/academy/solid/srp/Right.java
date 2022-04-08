package it.finmatica.academy.solid.srp;

public class Right {

    public void main() {

        Circle2 circle2 = new Circle2();
        circle2.area();

        Circle circle = new Circle(12);
        circle.area();
    }


    public static class Circle2 {

        private int radius;

        public int getRadius() {
            return radius;
        }

        public void setRadius(int radius) {
            this.radius = radius;
        }

        public double perimeter() {
            return radius * 2 * 3.14;
        }

        public double area() {
            return radius * radius * 3.14;
        }
    }


    public static class Circle {

        private final int radius;

        public Circle(int radius) {
            if (radius < 0) {
                throw new IllegalArgumentException("Non è possibile specificare un raggio < 0");
            }
            this.radius = radius;
        }

        public int getRadius() {
            return radius;
        }

        public double perimeter() {
            return radius * 2 * Math.PI;
        }

        public double area() {
            return radius * radius * Math.PI;
        }
    }

    public static class Printer {

        private final Circle sphere;

        public Printer(Circle sphere) {
            this.sphere = sphere;
        }

        public void printPerimeter() {
            System.out.println(sphere.perimeter());
        }
    }
}
