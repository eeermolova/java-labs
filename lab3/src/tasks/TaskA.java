package tasks;

import java.util.Arrays;
import java.util.Random;

public class TaskA {
    public static Integer[] execute(int n){
        Random random = new Random();
        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++){
            array[i] = random.nextInt(101);
        }
        System.out.println("a) Создание случайных чисел: ");
        System.out.println(Arrays.toString(array) + "\n");
        return array;
    }
}
