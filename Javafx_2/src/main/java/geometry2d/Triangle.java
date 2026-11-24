package geometry2d;

public class Triangle implements Figure {
    private final double[] xs;
    private final double[] ys;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.xs = new double[]{x1, x2, x3};
        this.ys = new double[]{y1, y2, y3};
    }

    public double[] getXs() { return xs; }
    public double[] getYs() { return ys; }

    @Override
    public double area() {
        return Math.abs(
                (xs[0] * (ys[1] - ys[2]) +
                        xs[1] * (ys[2] - ys[0]) +
                        xs[2] * (ys[0] - ys[1])) / 2.0
        );
    }
    @Override
    public boolean contains(double px, double py) {
        boolean inside = false;
        for (int i = 0, j = 2; i < 3; j = i++) {
            if (((ys[i] > py) != (ys[j] > py)) &&
                    (px < (xs[j] - xs[i]) * (py - ys[i]) / (ys[j] - ys[i]) + xs[i])) {
                inside = !inside;
            }
        }
        return inside;
    }

    @Override
    public void move(double dx, double dy) {
        for (int i = 0; i < 3; i++) {
            xs[i] += dx;
            ys[i] += dy;
        }
    }
}
