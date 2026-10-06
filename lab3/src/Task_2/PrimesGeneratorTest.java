package Task_2;

import java.util.Iterator;

public class PrimesGeneratorTest {
    public static void main(String[] args){
        int N = 10;

        PrimesGenerator generator = new PrimesGenerator(N);

        Iterator<Integer> directIterator = generator.iterator();
        while (directIterator.hasNext()){
            System.out.print(directIterator.next() + " ");
        }
        System.out.println("\n");

        Iterator<Integer> reverseIterator = generator.iterator();
        while (reverseIterator.hasNext()){
            System.out.print(reverseIterator.next() + " ");
        }
        System.out.println();

    }
}
