package it.finmatica.academy.solid.dip;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Wrong {

    public static void main(String args[]) throws MalformedURLException {
        new Plotter().plotLine(10, 10, 10);
    }

    public static class Plotter {

        // y = x * m + b
        public void plotLine(int m, int x, int b) throws MalformedURLException {
            ApiClient apiClient = new ApiClient(new URL("https://plotter.io/plot"));
            List<Point> line = new ArrayList<>();
            for (int i = 0; i < x; i++) {
                line.add(new Point(i, m * x + b));
            }
            apiClient.upload(line);
        }
    }

    public static class ApiClient {

        private final URL url;

        public ApiClient(URL url) {
            this.url = url;
        }

        public void upload(List<Point> point) {
            // ...... invoca il servizio per disegnare una retta
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
