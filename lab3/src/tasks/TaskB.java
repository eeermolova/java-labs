package tasks;
// работает с пн.а
import java.util.ArrayList;
import java.util.Arrays;

public class TaskB {
    public static ArrayList<Integer> execute(Integer[] array){
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(array));
        System.out.println("b) Созданный на основе массива список List");
        System.out.println(list + "\n");
        return list;
    }
}
