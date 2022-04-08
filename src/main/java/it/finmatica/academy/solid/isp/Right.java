package it.finmatica.academy.solid.isp;

public class Right {

    public static void main(String[] args) {
        new Printer(new PlottedShapeImpl(new Circle(10), 10, 10)).printIfAbove(5, 5);
    }


    public static class Printer {
        private final PlottedShape shape;

        public Printer(PlottedShape shape) {
            this.shape = shape;
        }

        public void printIfAbove(int x, int y) {
            if (shape.getX() > x && shape.getY() > y) {
                System.out.printf("x: %g, y: %g", shape.getX(), shape.getY());
            }
        }
    }

    public interface Shape {
        double perimeter();
    }

    public interface PlottedShape {
        double getX();
        double getY();
    }

    // decorator pattern
    public static class PlottedShapeImpl implements Shape, PlottedShape {
        private final Shape shape;
        private final int x, y;

        public PlottedShapeImpl(Shape shape, int x, int y) {
            this.shape = shape;
            this.x = x;
            this.y = y;
        }

        @Override
        public double perimeter() {
            return shape.perimeter();
        }

        @Override
        public double getX() {
            return this.x;
        }

        @Override
        public double getY() {
            return this.y;
        }
    }

    public static class Point implements PlottedShape {

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
    }

    public static class Rectangle implements Shape, PlottedShape {
        private final int base, height;
        private final int x, y;

        public Rectangle(int base, int height, int y, int x) {
            this.base = base;
            this.height = height;
            this.y = y;
            this.x = x;
        }

        public double perimeter() {
            return base * height;
        }

        @Override
        public double getX() {
            return this.x;
        }

        @Override
        public double getY() {
            return this.y;
        }
    }

    public static class Circle implements Shape {
        private final int radius;

        public Circle(int radius) {
            this.radius = radius;
        }

        public double perimeter() {
            return radius * 3.14;
        }
    }
}
