import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextFlagApp extends Application {

    @Override
    public void start(Stage primaryStage){
        Label label1 = new Label("Первая полоса:");
        ToggleGroup group1 = new ToggleGroup();

        RadioButton r1_red = new RadioButton("RED");
        RadioButton r1_green = new RadioButton("GREEN");
        RadioButton r1_blue = new RadioButton("BLUE");

        r1_red.setToggleGroup(group1); r1_green.setToggleGroup(group1);r1_blue.setToggleGroup(group1);
        r1_red.setSelected(true);
        HBox row1 = new HBox(10, r1_red, r1_green, r1_blue);

        Label label2 = new Label("Вторая полоса");
        ToggleGroup group2 = new ToggleGroup();
        RadioButton r2_red = new RadioButton("RED");
        RadioButton r2_green = new RadioButton("GREEN");
        RadioButton r2_blue = new RadioButton("BLUE");
        r2_red.setToggleGroup(group2); r2_green.setToggleGroup(group2); r2_blue.setToggleGroup(group2);
        r2_green.setSelected(true);
        HBox row2 = new HBox(10,r2_red,r2_green,r2_blue);

        Label label3 = new Label("Третья полоса");
        ToggleGroup group3 = new ToggleGroup();
        RadioButton r3_red = new RadioButton("RED");
        RadioButton r3_green = new RadioButton("GREEN");
        RadioButton r3_blue = new RadioButton("BLUE");
        r3_red.setToggleGroup(group3); r3_green.setToggleGroup(group3); r3_blue.setToggleGroup(group3);
        r3_blue.setSelected(true);
        HBox row3 = new HBox(10,r3_red,r3_green,r3_blue);

        Button drawButton = new Button("Рисовать");
        Label resultLabel = new Label("Цвета флага");
        resultLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");

        drawButton.setOnAction(e ->{
            RadioButton selected1 = (RadioButton) group1.getSelectedToggle();
            RadioButton selected2 = (RadioButton) group2.getSelectedToggle();
            RadioButton selected3 = (RadioButton) group3.getSelectedToggle();

            String result = String.format("Цвета флага: %s, %s, %s",
                    selected1.getText(), selected2.getText(), selected3.getText());
            resultLabel.setText(result);
        });

        VBox root = new VBox(15);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.TOP_LEFT);
        root.getChildren().addAll(
          label1, row1,
          label2, row2,
          label3, row3,
          drawButton,
          resultLabel
        );

        Scene scene = new Scene(root,400,500);
        primaryStage.setTitle("Текстовый флаг");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args){
        launch(args);
    }
}
