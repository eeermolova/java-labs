import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculator extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextField num1 = new TextField();
        num1.setPromptText("Число 1");

        TextField num2 = new TextField();
        num2.setPromptText("Число 2");

        Label result = new Label("Результат: ");
        result.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");

        Button sumButton = new Button("+");
        Button diffButton = new Button("-");
        Button multButton = new Button("*");
        Button divButton = new Button("/");

        sumButton.setPrefWidth(45);
        diffButton.setPrefWidth(45);
        multButton.setPrefWidth(45);
        divButton.setPrefWidth(45);

        // Сложение (+)
        sumButton.setOnAction(e -> {
            try {
                double val1 = Double.parseDouble(num1.getText());
                double val2 = Double.parseDouble(num2.getText());
                result.setText("Результат: " + (val1 + val2));
            } catch (NumberFormatException ex) {
                result.setText("Ошибка: введите корректные числа!");
            }
        });

        // Вычитание (-)
        diffButton.setOnAction(e -> {
            try {
                double val1 = Double.parseDouble(num1.getText());
                double val2 = Double.parseDouble(num2.getText());
                result.setText("Результат: " + (val1 - val2));
            } catch (NumberFormatException ex) {
                result.setText("Ошибка: введите корректные числа!");
            }
        });

        // Умножение (*)
        multButton.setOnAction(e -> {
            try {
                double val1 = Double.parseDouble(num1.getText());
                double val2 = Double.parseDouble(num2.getText());
                result.setText("Результат: " + (val1 * val2));
            } catch (NumberFormatException ex) {
                result.setText("Ошибка: введите корректные числа!");
            }
        });

        // Деление (/) с проверкой на 0
        divButton.setOnAction(e -> {
            try {
                double val1 = Double.parseDouble(num1.getText());
                double val2 = Double.parseDouble(num2.getText());

                // Проверяем деление на ноль
                if (val2 == 0) {
                    result.setText("Ошибка: деление на ноль невозможно!");
                } else {
                    result.setText("Результат: " + (val1 / val2));
                }
            } catch (NumberFormatException ex) {
                result.setText("Ошибка: введите корректные числа!");
            }
        });

        HBox buttonsRow = new HBox(10, sumButton, diffButton, multButton, divButton);
        buttonsRow.setAlignment(Pos.CENTER);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(15);
        grid.setPadding(new Insets(20));

        grid.add(new Label("Число 1:"), 0, 0);
        grid.add(num1, 1, 0);

        grid.add(new Label("Число 2:"), 0, 1);
        grid.add(num2, 1, 1);

        grid.add(buttonsRow, 0, 2, 2, 1);
        grid.add(result, 0, 3, 2, 1);

        Scene scene = new Scene(grid, 350, 250);
        primaryStage.setTitle("КАЛЬКУЛЯТОР");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
