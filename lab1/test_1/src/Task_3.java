public class Task_3 {
    public static void main (String[] args){
        double a = 1.0;
        double b = -2.0;
        double c = 1.0;
        double disk = (b*b) - (4*a*c);
        if (disk > 0){
            double x1 = (-b + Math.sqrt(disk))/(2*a);
            double x2 = (-b - Math.sqrt(disk))/(2*a);
            System.out.println("Корень х1 = " + x1 + ", x2 = " + x2 );
        }
        else if ( disk == 0){
            double x = -b/(2*a);
            System.out.println("Корень один х = " + x);
        }
        else {
            System.out.print("Вещественных коренй нет");
        }
    }
}
