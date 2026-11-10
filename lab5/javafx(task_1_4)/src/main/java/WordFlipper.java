import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class WordFlipper extends Application{
    private boolean isForward = true;

    @Override
    public void start(Stage primaryStage){
        TextField leftFiled = new TextField();
        leftFiled.setPromptText("Введите текст...");

        TextField rightFiled = new TextField();
        rightFiled.setPromptText("Введите текст...");

        Button flipButton = new Button(" -> ");

        flipButton.setOnAction(event -> {
            String leftText = leftFiled.getText();
            String rightText = rightFiled.getText();
            if (!leftText.isEmpty() && !rightText.isEmpty()){
                leftFiled.setText(rightText);
                rightFiled.setText(leftText);
                if (isForward){
                    flipButton.setText(" <- ");
                    isForward = false;
                }
                else{
                    flipButton.setText(" -> ");
                    isForward = true;
                }
            }

            else if (isForward){
                if (!leftText.isEmpty()){
                    rightFiled.setText(leftText);
                    leftFiled.clear();
                }

                flipButton.setText(" <- ");
                isForward = false;
            }
            else{
                if (!rightText.isEmpty()){
                    leftFiled.setText(rightText);
                    rightFiled.clear();
                }

                flipButton.setText(" -> ");
                isForward = true;
            }
        });

        HBox root = new HBox(10); //расстояние 10 пикс
        root.setAlignment(Pos.CENTER);

        root.getChildren().addAll(leftFiled,rightFiled,flipButton);

        Scene scene = new Scene(root,500,150);

        primaryStage.setTitle("Перекидыватель слов");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}