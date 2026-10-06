import tasks.*;
import java.util.ArrayList;

public class task1 {
    public static void main(String[] args){
        int N = 10;
        // a) Вызов из класса TaskA
        Integer[] array = TaskA.execute(N);

        // b) Вызов из класса TaskB
        ArrayList<Integer> list = TaskB.execute(array);

        // c) Вызов из класса TaskC
        TaskC.execute(list);

        // d) Вызов из класса TaskD
        TaskD.execute(list);

        // e) Вызов из класса TaskE
        TaskE.execute(list);

        // f) Вызов из класса TaskF
        TaskF.execute(list);

        // Копии для изолированной проверки деструктивных методов g и h
        ArrayList<Integer> listForG = new ArrayList<>(list);
        ArrayList<Integer> listForH = new ArrayList<>(list);

        // g) Вызов из класса TaskG
        TaskG.execute(listForG);

        // h) Вызов из класса TaskH
        TaskH.execute(listForH);

        // i) Вызов из класса TaskI
        Integer[] newArray = TaskI.execute(list);

        // j) Вызов из класса TaskJ
        TaskJ.execute(newArray);
    }
}
