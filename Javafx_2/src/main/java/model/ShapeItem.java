package model;
import geometry2d.Figure;

public class ShapeItem {
    private final Figure figure;
    private Rgb color;

    public ShapeItem(Figure figure, Rgb color){
        this.figure = figure;
        this.color = color;
    }

    public Figure getFigure() {return figure;}
    public Rgb getColor() {return color;}
    public void setColor(Rgb color) {this.color = color;}
}
