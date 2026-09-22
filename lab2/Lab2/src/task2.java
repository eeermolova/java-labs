import balance.Balance;

public class task2 {
    public static void main(String[] args){
        Balance scale = new Balance();

        scale.addLeft(10);
        scale.addRight(5);
        scale.result();
    }
}
