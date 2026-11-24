package geometry2d;

public interface Figure {
    double area();
    boolean contains(double px, double py);
    void move(double dx, double dy);
}
