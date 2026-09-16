public class Task_4 {
    public static void main (String[] args){
        double sum = 0.0;
        int n = 2;
        double limit = 1e-6;
        while(true){
            double term = 1.0 / (n*n + n -2);
            if(term < limit){
                break;
            }
            sum += term;
            n++;
        }
        System.out.println("Сумма ряда: " + sum);
    }
}
