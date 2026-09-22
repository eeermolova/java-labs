import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class task_4 {
    public static void main(String[] args){
        OddEven separator = new OddEven();
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.println("Введите целые числа по одному");
        System.out.println("Для завершения ввода и вывода списков напишите <exit>");

        while (true){
            System.out.println("Введите число: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")){ //привод к одному регистру. удаление пробелов
                break;
            }

            try{
                int number = Integer.parseInt(input); //приводим записанную строку в числа
                separator.addNum(number);
            }
            catch (NumberFormatException e){ //ошибка, которая при превращении в число, не может превратить его.
                // е - переменная в которой сохраняется объект исключения
                System.out.println("Ошибка: не целое число");
            }
        }
        System.out.println("Результаты");
        System.out.println("Четные");
        separator.even();

        System.out.println("Нечетные");
        separator.odd();

        scanner.close();
    }
}

class OddEven {
    private final java.util.List<Integer> evenNum = new java.util.ArrayList<>();
    private final java.util.List<Integer> oddNum = new java.util.ArrayList<>();

    public void addNum (int number){
        if (number % 2 == 0){
            evenNum.add(number);
        }
        else {
           oddNum.add(number);
        }
    }

    public void even(){
        System.out.println(evenNum);
    }
    public void odd(){
        System.out.println(oddNum);
    }
}
