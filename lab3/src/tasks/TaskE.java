package tasks;

import java.util.ArrayList;
import java.util.Collections;

public class TaskE {
    public static void execute(ArrayList<Integer> list){
        Collections.shuffle(list);
        System.out.println("e) Перемешанный список");
        System.out.println(list + "\n");
    }
}
