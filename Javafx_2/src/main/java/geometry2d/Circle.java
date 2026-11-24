package geometry2d;

public class Circle implements Figure{
    private double x;
    private double y;
    private final double radius;

    public Circle(double x, double y, double radius){
        if (radius <= 0) throw new  IllegalArgumentException("Радиус должен быть > 0");
        this.x = x;
        this.y =y;
        this.radius = radius;
    }

    public double getX() {return x; }
    public double getY() {return y;}
    public double getRadius() {return radius;}

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
    @Override
    public boolean contains(double px, double py) {
        double dx = px - x;
        double dy = py - y;
        return dx * dx + dy * dy <= radius * radius;
    }

    @Override
    public void move(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

}
