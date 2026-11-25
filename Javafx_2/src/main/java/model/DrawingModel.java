package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DrawingModel {
    private static final int MAX_ITEMS = 10;

    private final List<ShapeItem> items = new ArrayList<>();
    private final List<Runnable> listeners = new ArrayList<>();

    public void addListener(Runnable listener){
        listeners.add(listener);
    }

    private void fireChanged(){
        for (Runnable listener : listeners){
            listener.run();
        }
    }

    public void add(ShapeItem item){
        if (items.size() >= MAX_ITEMS){
            items.remove(0);
        }
        items.add(item);
        fireChanged();
    }

    public void clear() {
        items.clear();
        fireChanged();
    }

    public List<ShapeItem> getItems() {
        return Collections.unmodifiableList(items);
    }
    public ShapeItem findTopAt(double x, double y) {
        for (int i = items.size() - 1; i >= 0; i--) {
            ShapeItem item = items.get(i);
            if (item.getFigure().contains(x, y)) {
                return item;
            }
        }
        return null;
    }

    public void bringToFront(ShapeItem item) {
        if (items.remove(item)) {
            items.add(item);
            fireChanged();
        }
    }

    public void moveItem(ShapeItem item, double dx, double dy) {
        item.getFigure().move(dx, dy);
        fireChanged();
    }

    public void changeColor(ShapeItem item, Rgb newColor) {
        item.setColor(newColor);
        fireChanged();
    }
}
