package balabce;

public class Balance {
    private int leftWeight = 0;
    private int rightWeight = 0;

    public void addLeft(int weight){
        this.leftWeight += weight;
    }
    public void addRight(int weight){
        this.rightWeight += weight;
    }

    public void result(){
        if (this.leftWeight == this.rightWeight){
            System.out.println("=");
        }
        else if (this.leftWeight < this.rightWeight){
            System.out.println("R");
        }
        else{
            System.out.println("L");
        }
    }
}
