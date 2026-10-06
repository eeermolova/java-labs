package tasks;

import java.util.ArrayList;
import java.util.HashSet;

public class TaskH {
    public static void execute(ArrayList<Integer> list){
        HashSet<Integer> uniques = new HashSet<>();
        HashSet<Integer> dublicates = new HashSet<>();
        for(Integer num : list){
            if( !uniques.add(num)){
                dublicates.add(num);
            }
        }
        list.clear();
        list.addAll(dublicates);
        System.out.println("h) Список только с дубликатами");
        System.out.println(list + "\n");
    }
}
