package geometry2d;

public class Rectangle implements Figure{
    private double x;
    private double y;
    private final double wight;
    private final double height;

    public Rectangle(double x, double y, double wight, double height){
        if (wight <= 0 || height <= 0) throw new IllegalArgumentException("Стороны должны быть > 0");
        this.x = x;
        this.y = y;
        this.wight = wight;
        this.height = height;
    }

    public double getX() {return x;}
    public double getY() {return y;}
    public double getWight() {return wight;}
    public double getHeight() {return height;}

    @Override
    public double area(){
        return wight * height;
    }
    @Override
    public boolean contains(double px, double py) {
        return px >= x && px <= x + wight && py >= y && py <= y + height;
    }

    @Override
    public void move(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }
}
