package tasks;

import java.util.ArrayList;
import java.util.Collections;

public class TaskF {
    public static void execute(ArrayList<Integer> list){
        Collections.rotate(list, 1);
        System.out.println("f) Циклический сдвиг на 1 вправо");
        System.out.println(list + "\n");
    }
}
