import exceptions.InvalidFigureException;
import exceptions.MissingBaseException;
import geometry2d.Circle;
import geometry2d.Figure;
import geometry2d.Rectangle;
import geometry3d.Cylinder;

public class task_6 {
    public void main(String[] args){
        try {
            System.out.println("--- Создание 2д фигуры ---");

            Figure circle = new Circle(5.0);
            System.out.println(circle);

            Figure rectangle = new Rectangle(4.0, 6.0);
            System.out.println(rectangle);

            System.out.println("\n--- Создание 3D цилиндров ---");

            Cylinder roundCylinder = new Cylinder(circle, 10.0);
            System.out.println(roundCylinder);

            Cylinder rectCylinder = new Cylinder(rectangle, 5.0);
            System.out.println(rectCylinder);

            System.out.println("\n--- Проверка обработки ошибок ---");

            try {
                Cylinder errorCylinder = new Cylinder(circle, -2.0);
            }
            catch (InvalidFigureException e) {
                System.out.println("Успешно перехвачена ошибка: " + e.getMessage());
            }

            // Пробуем передать null вместо основания
            try {
                Cylinder errorCylinder2 = new Cylinder(null, 5.0);
            }
            catch (MissingBaseException e) {
                System.out.println("Успешно перехвачена ошибка: " + e.getMessage());
            }

        }
        catch (InvalidFigureException | MissingBaseException e) {
            System.err.println("Произошла ошибка при создании фигур: " + e.getMessage());
        }
    }
}
