package tasks;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class TaskG {
    public static void execute(ArrayList<Integer> list){
        LinkedHashSet<Integer> set = new LinkedHashSet<>(list);
        list.clear();
        list.addAll(set);
        System.out.println("g) Список с уникальными элементами");
        System.out.println(list + "\n");
    }
}
