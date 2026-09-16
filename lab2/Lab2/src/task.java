import buttons.button;

public class task {
    public static void main(String[] args){
        button b1 = new button();
        int click = b1.click();
        click = b1.click();
        button b2 = new button();
        int click2 = b2.click();

        System.out.println(click);
        System.out.println(click2);
    }
}
