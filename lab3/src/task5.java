import java.util.Map;
import java.util.HashMap;

public class task5 {
    public static void main(String[] args){
        Map<String, Integer> passportData = new HashMap<>();
        passportData.put("Ivanov", 123456);
        passportData.put("Petrov", 666777);
        passportData.put("VLV", 778899);

        System.out.println("Оригинальный" + passportData);
        Map<Integer,String> invertedData = invertMap(passportData);
        System.out.println("измененный" + invertedData);

    }

    public static <K, V> Map<V, K> invertMap(Map<K,V> originalMap){
        Map<V,K> invertedMap = new HashMap<>();
        if(originalMap==null){
            return invertedMap;
        }
        for(Map.Entry<K,V> entry : originalMap.entrySet()){
            invertedMap.put(entry.getValue(), entry.getKey());
        }
        return invertedMap;
    }
}
