package tasks;

import java.util.ArrayList;
import java.util.Collections;

public class TaskD {
    public static void execute(ArrayList<Integer> list){
        list.sort(Collections.reverseOrder());
        System.out.println("d) Список, отсортированный в обратном порядке");
        System.out.println(list + "\n");
    }
}
