import task_3.Human;
import task_3.HumanComparatorByLastName;
import java.util.*;

public class Task3 {
    static void main(String[] args) {
        // Создаем исходный список объектов Human
        List<Human> list = new ArrayList<>();
        list.add(new Human("Иван", "Петров", 25));
        list.add(new Human("Анна", "Иванова", 20));
        list.add(new Human("Сергей", "Петров", 30));
        list.add(new Human("Иван", "Петров", 25));

        System.out.println("--- Исходный список ---");
        list.forEach(System.out::println);

        // a) HashSet
        Set<Human> hashSet = new HashSet<>(list);
        System.out.println("\na) HashSet:");
        hashSet.forEach(System.out::println);

        // b) LinkedHashSet
        Set<Human> linkedHashSet = new LinkedHashSet<>(list);
        System.out.println("\nb) LinkedHashSet:");
        linkedHashSet.forEach(System.out::println);

        // c) TreeSet
        Set<Human> treeSetNatural = new TreeSet<>(list);
        System.out.println("\nc) TreeSet с Comparable:");
        treeSetNatural.forEach(System.out::println);

        // d) TreeSet
        Set<Human> treeSetByLastName = new TreeSet<>(new HumanComparatorByLastName());
        treeSetByLastName.addAll(list);
        System.out.println("\nd) TreeSet с HumanComparatorByLastName:");
        treeSetByLastName.forEach(System.out::println);

        // e) TreeSet
        Set<Human> treeSetByAge = new TreeSet<>((h1, h2) -> Integer.compare(h1.getAge(), h2.getAge()));
        treeSetByAge.addAll(list);
        System.out.println("\ne) TreeSet с компаратором по возрасту:");
        treeSetByAge.forEach(System.out::println);
    }
}
