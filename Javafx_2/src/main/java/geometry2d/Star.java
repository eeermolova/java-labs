package geometry2d;

public class Star implements Figure {
    private double x;
    private double y;
    private final double outerRadius;
    private final double innerRadius;

    public Star(double x, double y, double outerRadius, double innerRadius) {
        if (outerRadius <= 0 || innerRadius <= 0) {
            throw new IllegalArgumentException("Радиусы должны быть > 0");
        }
        this.x = x;
        this.y = y;
        this.outerRadius = outerRadius;
        this.innerRadius = innerRadius;
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public double getOuterRadius() { return outerRadius; }

    // Вычисляет координаты X для 10 вершин звезды
    public double[] getXs() {
        double[] xs = new double[10];
        for (int i = 0; i < 10; i++) {
            double angle = Math.toRadians(-90 + i * 36); // -90 чтобы верхний луч смотрел строго вверх
            double r = (i % 2 == 0) ? outerRadius : innerRadius;
            xs[i] = x + r * Math.cos(angle);
        }
        return xs;
    }

    // Вычисляет координаты Y для 10 вершин звезды
    public double[] getYs() {
        double[] ys = new double[10];
        for (int i = 0; i < 10; i++) {
            double angle = Math.toRadians(-90 + i * 36);
            double r = (i % 2 == 0) ? outerRadius : innerRadius;
            ys[i] = y + r * Math.sin(angle);
        }
        return ys;
    }

    @Override
    public double area() {
        // Площадь 10-угольника по формуле шнурования (Гаусса)
        double[] xs = getXs();
        double[] ys = getYs();
        double sum = 0;
        for (int i = 0; i < 10; i++) {
            int next = (i + 1) % 10;
            sum += xs[i] * ys[next] - xs[next] * ys[i];
        }
        return Math.abs(sum) / 2.0;
    }
    @Override
    public boolean contains(double px, double py) {
        double[] xs = getXs();
        double[] ys = getYs();
        boolean inside = false;
        for (int i = 0, j = 9; i < 10; j = i++) {
            if (((ys[i] > py) != (ys[j] > py)) &&
                    (px < (xs[j] - xs[i]) * (py - ys[i]) / (ys[j] - ys[i]) + xs[i])) {
                inside = !inside;
            }
        }
        return inside;
    }

    @Override
    public void move(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }
}
