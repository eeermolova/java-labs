package geometry2d;

import exceptions.InvalidFigureException;

public class Rectangle implements Figure{
    private final double width;
    private final double height;

    public Rectangle(double width, double height) throws InvalidFigureException{
        if (width <= 0 || height <= 0){
            throw new InvalidFigureException("Стороны должны быть больше 0");
        }
        this.height = height;
        this.width = width;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return String.format("Прямоугольник размеры: %.2f x %.2f", width, height);
    }
}
