import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;


public class LibraryApp {
    public static void main(String[] args) {
        Gson gson = new Gson();

        try (InputStream inputStream = LibraryApp.class.getClassLoader().getResourceAsStream("book.json")) {
            if (inputStream == null) {
                throw new FileNotFoundException("Файл не найден в папке resources");
            }

            try (Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {
                // Парсинг JSON-файла в список посетителей
                Type visitorListType = new TypeToken<List<Visitor>>(){}.getType();
                List<Visitor> visitors = gson.fromJson(reader, visitorListType);

                //ЗАДАНИЕ 1
                System.out.println("=== Список посетителей библиотеки ===");
                visitors.stream()
                        .forEach(v -> System.out.println(v.getSurname() + " " + v.getName() + " (Тел: " + v.getPhone() + ")"));

                long totalVisitors = visitors.stream().count();

                System.out.println("\nОбщее количество посетителей: " + totalVisitors);

                //ЗАДАНИЕ 2
                System.out.println("\n=== Список уникальных книг в избранном ===");

                visitors.stream()
                        .flatMap(v -> v.getFavoriteBooks().stream())
                        .distinct()
                        .forEach(b -> System.out.println("«" + b.getName() + "» — " + b.getAuthor() + " (" + b.getPublishingYear() + " г.)"));

                long uniqueBooksCount = visitors.stream()
                        .flatMap(v -> v.getFavoriteBooks().stream())
                        .distinct()
                        .count();

                System.out.println("\nКоличество уникальных книг в избранном: " + uniqueBooksCount);

                // --- ЗАДАНИЕ 3 ---
                System.out.println("\n=== Книги, отсортированные по году издания ===");
                visitors.stream()
                        .flatMap(v -> v.getFavoriteBooks().stream())
                        .distinct()
                        .sorted(Comparator.comparingInt(Book::getPublishingYear)) // Сортировка по возрастанию года
                        .forEach(b -> System.out.println(b.getPublishingYear() + " г. — «" + b.getName() + "» (" + b.getAuthor() + ")"));


// --- ЗАДАНИЕ 4 ---
                System.out.println("\n=== Проверка автора Jane Austen ===");
                boolean hasJaneAusten = visitors.stream()
                        .flatMap(v -> v.getFavoriteBooks().stream())
                        .anyMatch(b -> "Jane Austen".equals(b.getAuthor())); // Проверяем, есть ли хоть одно совпадение

                System.out.println("Есть ли в избранном книги Jane Austen? " + (hasJaneAusten ? "Да" : "Нет"));


// --- ЗАДАНИЕ 5 ---
                System.out.println("\n=== Максимальное число книг в избранном ===");
                int maxBooks = visitors.stream()
                        .mapToInt(v -> v.getFavoriteBooks().size()) // Превращаем поток посетителей в поток чисел (размеров списков)
                        .max()                                      // Находим максимальное число
                        .orElse(0);                                 // Если посетителей нет, вернет 0

                System.out.println("Максимальное количество книг у одного посетителя: " + maxBooks);


// --- ЗАДАНИЕ 6 ---
                System.out.println("\n=== Рассылка SMS по категориям ===");

// 1. Считаем среднее количество книг по всем посетителям
                double averageBooks = visitors.stream()
                        .mapToInt(v -> v.getFavoriteBooks().size())
                        .average()
                        .orElse(0.0);

                System.out.println("Среднее количество книг в избранном: " + averageBooks);

// 2. Группируем людей, согласных на рассылку, превращая их сразу в SMS-сообщения
                Map<String, List<SmsMessage>> smsGroups = visitors.stream()
                        .filter(Visitor::isSubscribed) // Оставляем только тех, кто подписан на рассылку
                        .map(v -> {
                            int count = v.getFavoriteBooks().size();
                            String text;
                            if (count > averageBooks) {
                                text = "you are a bookworm";
                            } else if (count < averageBooks) {
                                text = "read more";
                            } else {
                                text = "fine";
                            }
                            return new SmsMessage(v.getPhone(), text); // Превращаем посетителя в объект SMS
                        })
                        // Группируем по тексту сообщения (категориям)
                        .collect(Collectors.groupingBy(SmsMessage::getMessage));

// 3. Выводим результат на экран
                smsGroups.forEach((category, smsList) -> {
                    System.out.println("\nКатегория сообщения: [" + category + "]");
                    smsList.forEach(sms -> System.out.println("  Отправить на номер: " + sms.getPhone()));
                });

            }

        } catch (Exception e) {
            System.err.println("Произошла ошибка при работе с файлом: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
