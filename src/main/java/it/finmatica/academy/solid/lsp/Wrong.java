package it.finmatica.academy.solid.lsp;

public class Wrong {

    // cosa succede se voglio stampare l'area di un rettangolo?

    // se voglio stampare anche un'altra figura, basta creare la relativa classe.

    public static class Printer {
        private final Shape shape;

        public Printer(Shape shape) {
            this.shape = shape;
        }

        public void printPerimeter() {
            System.out.println(shape.perimeter());
        }
    }

    public interface Shape {
        double perimeter();
    }

    public static class Point implements Shape {

        private int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public double perimeter() {
            return 0;
        }
    }

    public static class Rectangle implements Shape {
        private final int base, height;

        public Rectangle(int base, int height) {
            this.base = base;
            this.height = height;
        }

        public double perimeter() {
            return base * height;
        }
    }

    public static class Sphere implements Shape {
        private final int radius;

        public Sphere(int radius) {
            this.radius = radius;
        }

        public double perimeter() {
            return radius * 3.14;
        }
    }
}
