package it.finmatica.academy.solid.dip;

import it.finmatica.academy.solid.dip.Wrong.Point;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Right {

    public static void main(String args[]) throws MalformedURLException {
        new Plotter(new FileCsvApi("file.csv")).plotLine(10, 10, 10);
    }

    public static class FileCsvApi implements Api {


        public FileCsvApi(String file) {
        }

        @Override
        public void upload(List<Wrong.Point> point) {

        }
    }

    public static class Plotter {

        private final Api api;

        public Plotter(Api api) {
            this.api = api;
        }

        public void plotLine(int m, int x, int b) {
            List<Wrong.Point> line = new ArrayList<>();
            for (int i = 0; i < x; i++) {
                line.add(new Wrong.Point(i, m * x + b));
            }
            api.upload(line);
        }
    }

    public interface Api {
        public void upload(List<Wrong.Point> point);
    }

    public static class ApiClient implements Api {

        private final URL url;

        public ApiClient(URL url) {
            this.url = url;
        }

        public void upload(List<Wrong.Point> point) {
            // ......
        }
    }

    public static class Point {

        private final int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return this.x;
        }

        public double getY() {
            return this.y;
        }
    }
}
