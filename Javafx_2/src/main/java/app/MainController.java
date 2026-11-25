package app;

import geometry2d.*;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import model.DrawingModel;
import model.Rgb;
import model.ShapeItem;

import java.util.Random;

public class MainController {
    @FXML private Pane canvasHolder;
    @FXML private Canvas canvas;

    private final DrawingModel model;
    private final Random random = new Random();

    private ShapeItem draggedItem;
    private double lastX;
    private double lastY;

    public MainController(DrawingModel model) {
        this.model = model;
    }

    @FXML
    public void initialize() {
        canvas.widthProperty().bind(canvasHolder.widthProperty());
        canvas.heightProperty().bind(canvasHolder.heightProperty());

        canvas.widthProperty().addListener(o -> refresh());
        canvas.heightProperty().addListener(o -> refresh());

        model.addListener(this::refresh);
    }

    @FXML
    private void onAddCircle() {
        double r = 20 + random.nextDouble() * 40;
        double maxX = Math.max(1, canvas.getWidth() - 2 * r);
        double maxY = Math.max(1, canvas.getHeight() - 2 * r);
        double cx = r + random.nextDouble() * maxX;
        double cy = r + random.nextDouble() * maxY;

        model.add(new ShapeItem(new Circle(cx, cy, r), randomColor()));
    }

    @FXML
    private void onAddRectangle() {
        double w = 30 + random.nextDouble() * 80;
        double h = 30 + random.nextDouble() * 80;
        double maxX = Math.max(1, canvas.getWidth() - w);
        double maxY = Math.max(1, canvas.getHeight() - h);
        double x = random.nextDouble() * maxX;
        double y = random.nextDouble() * maxY;

        model.add(new ShapeItem(new Rectangle(x, y, w, h), randomColor()));
    }

    @FXML
    private void onAddTriangle() {
        double size = 40 + random.nextDouble() * 70;
        double startX = random.nextDouble() * Math.max(1, canvas.getWidth() - size);
        double startY = random.nextDouble() * Math.max(1, canvas.getHeight() - size);

        double x1 = startX + size / 2.0;
        double y1 = startY;
        double x2 = startX;
        double y2 = startY + size;
        double x3 = startX + size;
        double y3 = startY + size;

        model.add(new ShapeItem(new Triangle(x1, y1, x2, y2, x3, y3), randomColor()));
    }

    @FXML
    private void onAddStar() {
        double outerR = 25 + random.nextDouble() * 35;
        double innerR = outerR * 0.4;
        double maxX = Math.max(1, canvas.getWidth() - 2 * outerR);
        double maxY = Math.max(1, canvas.getHeight() - 2 * outerR);
        double cx = outerR + random.nextDouble() * maxX;
        double cy = outerR + random.nextDouble() * maxY;

        model.add(new ShapeItem(new Star(cx, cy, outerR, innerR), randomColor()));
    }

    @FXML
    private void onClearCanvas() {
        draggedItem = null;
        model.clear();
    }

    @FXML
    private void onMousePressed(MouseEvent event) {
        ShapeItem hit = model.findTopAt(event.getX(), event.getY());
        if (hit == null) return;

        if (event.getButton() == MouseButton.PRIMARY) {
            model.bringToFront(hit);
            draggedItem = hit;
            lastX = event.getX();
            lastY = event.getY();
        } else if (event.getButton() == MouseButton.SECONDARY) {
            model.changeColor(hit, randomColor());
        }
    }

    @FXML
    private void onMouseDragged(MouseEvent event) {
        if (draggedItem != null && event.getButton() == MouseButton.PRIMARY) {
            double dx = event.getX() - lastX;
            double dy = event.getY() - lastY;
            lastX = event.getX();
            lastY = event.getY();

            model.moveItem(draggedItem, dx, dy);
        }
    }

    @FXML
    private void onMouseReleased(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {
            draggedItem = null;
        }
    }

    private void refresh() {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        for (ShapeItem item : model.getItems()) {
            Rgb rgb = item.getColor();
            gc.setFill(Color.rgb(rgb.red(), rgb.green(), rgb.blue()));

            Figure figure = item.getFigure();
            if (figure instanceof Circle c) {
                double r = c.getRadius();
                gc.fillOval(c.getX() - r, c.getY() - r, 2 * r, 2 * r);
            } else if (figure instanceof Rectangle r) {
                gc.fillRect(r.getX(), r.getY(), r.getWight(), r.getHeight());
            } else if (figure instanceof Triangle t) {
                gc.fillPolygon(t.getXs(), t.getYs(), 3);
            } else if (figure instanceof Star s) {
                gc.fillPolygon(s.getXs(), s.getYs(), 10);
            }
        }
    }

    private Rgb randomColor() {
        return new Rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }
}
