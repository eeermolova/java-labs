package buttons;

public class button {
    private int clickCount;

    public int click() {
        clickCount++;
        return clickCount;
    }
}
