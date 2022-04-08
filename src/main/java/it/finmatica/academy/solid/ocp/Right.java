package it.finmatica.academy.solid.ocp;

import java.io.File;

public class Right {

    // cosa succede se voglio stampare l'area di un rettangolo?

    public void main() {
        Printer printer = new PrintToFile(new Circle(2));

        // otterrò errore:
        printer.printPerimeter();
    }

    // se voglio stampare anche un'altra figura, basta creare la relativa classe.

    public static class PrintToFile extends Printer {

        public PrintToFile(Shape shape) {
            super(shape);
        }

        public void printToFile(File file) {
            // stampo il valore del perimetro sul file
        }

        @Override
        public void printPerimeter() {

        }
    }

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

    public static class Triangle implements Shape {
        private final int lato1, lato2, lato3;

        public Triangle(int lato1, int lato2, int lato3) {
            this.lato1 = lato1;
            this.lato2 = lato2;
            this.lato3 = lato3;
        }

        public double perimeter() {
            return (lato1 + lato2 + lato3);
        }
    }

    public static class Rectangle implements Shape {
        private final int base, height;

        public Rectangle(int base, int height) {
            this.base = base;
            this.height = height;
        }

        public double perimeter() {
            return (base + height) * 2;
        }
    }

    public static class Circle implements Shape {
        private final int radius;

        public Circle(int radius) {
            this.radius = radius;
        }

        public double perimeter() {
            return 2 * radius * 3.14;
        }
    }
}
