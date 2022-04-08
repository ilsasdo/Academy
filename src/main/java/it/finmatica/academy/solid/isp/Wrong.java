package it.finmatica.academy.solid.isp;

import it.finmatica.academy.solid.isp.Right.Point;
import it.finmatica.academy.solid.isp.Right.Printer;

public class Wrong {

    public static void main(String[] args) {
        new Printer(new Circle(10)).printIfAbove(5, 5);
    }

    // cosa succede se voglio stampare l'area di un rettangolo?

    // se voglio stampare anche un'altra figura, basta creare la relativa classe.

    public static class Printer {
        private final Shape shape;

        public Printer(Shape shape) {
            this.shape = shape;
        }

        public void printIfAbove(int x, int y) {
            if (shape.getX() > x && shape.getY() > y) {
                System.out.printf("x: %g, y: %g", shape.getX(), shape.getY());
            }
        }
    }

    public interface Shape {
        double getX();
        double getY();
        double perimeter();
    }

    public static class Point implements Shape {

        private final int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public double getX() {
            return this.x;
        }

        @Override
        public double getY() {
            return this.y;
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

        @Override
        public double getX() {
            throw new UnsupportedOperationException("il rettangolo non ha coordinate x e y");
        }

        @Override
        public double getY() {
            throw new UnsupportedOperationException("il rettangolo non ha coordinate x e y");
        }

        public double perimeter() {
            return base * height;
        }
    }

    public static class Circle implements Shape {
        private final int radius;

        public Circle(int radius) {
            this.radius = radius;
        }

        @Override
        public double getX() {
            throw new UnsupportedOperationException("la sfera non ha coordinate x e y");
        }

        @Override
        public double getY() {
            throw new UnsupportedOperationException("la sfera non ha coordinate x e y");
        }

        public double perimeter() {
            return radius * 3.14;
        }
    }
}
