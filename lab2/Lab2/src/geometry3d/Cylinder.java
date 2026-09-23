package geometry3d;

import exceptions.MissingBaseException;
import exceptions.InvalidFigureException;
import geometry2d.Figure;

public class Cylinder {
    private final Figure base;
    private final double height;

    public Cylinder(Figure base, double height) throws MissingBaseException, InvalidFigureException{
        if(base == null){
            throw new MissingBaseException("основание цилиндра не может быть пустым");
        }
        if(height <= 0){
            throw new InvalidFigureException("Высота цилиндра должна быть больше нуля");
        }
        this.base = base;
        this.height = height;
    }

    public double volume(){
        return base.area() * height;
    }

    @Override
    public String toString() {
        return String.format("Цилиндр [Основание: %s, Высота: %.2f, Объем: %.2f]",
                base.toString(), height, volume());
    }
}
