package tasks;

import java.util.ArrayList;
import java.util.Arrays;

public class TaskI {
    public static Integer[] execute(ArrayList<Integer> list){
        Integer[] array = list.toArray(new Integer[0]);
        System.out.println("i) Получеснный из списка массив");
        System.out.println(Arrays.toString(array) + "\n");
        return array;
    }
}
