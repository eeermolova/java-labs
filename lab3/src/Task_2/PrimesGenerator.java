package Task_2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class PrimesGenerator implements Iterable<Integer>{
    private final List<Integer> primes;

    public PrimesGenerator(int n){
        this.primes = new ArrayList<>();
        generatePrimes(n);
    }

    private void generatePrimes(int n){
        int number = 2;
        while (primes.size() < n){
            if (isPrime(number)){
                primes.add(number);
            }
            number++;
        }
    }
    //проверка на простое число
    private boolean isPrime(int num){
        if(num < 2) return false;
        for (int i = 2; i * i <= num; i++){
            if (num % i == 0) return false;
        }
        return true;
    }

    @Override
    public Iterator<Integer> iterator(){
        return primes.iterator();
    }

    public Iterator<Integer> reversItertor(){
        return new Iterator<Integer>() {
            private int cursor = primes.size() - 1;

            @Override
            public boolean hasNext() {
                return cursor >= 0;
            }

            @Override
            public Integer next() {
                if (!hasNext()){
                    throw new NoSuchElementException("Больше нет элементов");
                }
                return primes.get(cursor--);
            }
        };
    }
}
