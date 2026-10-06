package tasks;

import java.util.ArrayList;
import java.util.Collections;

public class TaskC {
    public static void execute(ArrayList<Integer> list){
        Collections.sort(list);
        System.out.println("c) Список, отсортированный по возрастанию");
        System.out.println(list + "\n");
    }
}
