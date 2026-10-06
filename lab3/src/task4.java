import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class task4 {
    public static void main(String[] args){
        String text = "Hello world! Hello mom and dad! apple And banana";
        System.out.println("Исходный текст: " + text);

        String lowerCase = text.toLowerCase();

        String cleanText = lowerCase.replaceAll("[^a-zA-Z ]", "");
        String[] words = cleanText.split("\\s");

        Map<String,Integer> wordCount = new HashMap<>();

        for (String word : words){
            if(!word.isEmpty()){
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }

        System.out.println("Частота встречаемости: ");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()){
            System.out.println("Слово " + entry.getKey() + " встречается " + entry.getValue()+ " раз");
        }
    }
}
