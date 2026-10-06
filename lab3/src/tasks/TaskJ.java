package tasks;

import java.util.HashMap;
import java.util.Map;

public class TaskJ {
    public static void execute(Integer[] array){
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (Integer num : array){
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        System.out.println("j) Количество вхождений каждого числа в массиве");
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()){
            System.out.println("Число " + entry.getKey() + " встречается " + entry.getValue() + " раз(а)");
        }
    }
}
