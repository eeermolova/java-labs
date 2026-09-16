public class task3 {
    public static void main(String[] args){
        Bell bell = new Bell();

        bell.sound();
        bell.sound();
    }
}

class Bell {
    private boolean isDing = true;
    public void sound(){
        if(isDing){
            System.out.println("ding");
        }
        else{
            System.out.println("dong");
        }
        isDing = !isDing;
    }
}
