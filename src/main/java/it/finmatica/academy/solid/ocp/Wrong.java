package it.finmatica.academy.solid.ocp;

public class Wrong {

    // cosa succede se voglio stampare l'area di un rettangolo?

    public void main() {
        new Printer(new String("pippo"));
        new Printer(new Circle(1));
    }

    public static class Printer {

        private final Object shape;

        public Printer(Object shape) {
            this.shape = shape;
        }

        public void print(Circle circle) {
            System.out.println(((Circle)shape).perimeter());
        }

        public void print(Rectangle rectangle) {
            System.out.println(rectangle.perimeter());
        }

        public void printCircumference() {

            if (shape instanceof Circle) {
                System.out.println(((Circle)shape).perimeter());
            } else if (shape instanceof Rectangle) {
                System.out.println(((Rectangle)shape).perimeter());
            }
        }
    }

    public static class Rectangle {

        private final int base, height;

        public Rectangle(int base, int height) {
            this.base = base;
            this.height = height;
        }

        public int perimeter() {
            return (base + height) * 2;
        }
    }

    public static class Circle {

        private final int radius;

        public Circle(int radius) {
            this.radius = radius;
        }

        public double perimeter() {
            return 2 * radius * 3.14;
        }
    }
}
