import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Visibility extends Application{

    @Override
    public void start(Stage primaryStage){
        Button myButton = new Button("im a button");
        TextField myTextfield = new TextField("im a text field");
        Label myLabel = new Label("im a  inscription");

        CheckBox box1 = new CheckBox("Показать кнопку");
        box1.setSelected(true);
        CheckBox box2 = new CheckBox("Показать поле");
        box2.setSelected(true);
        CheckBox box3 = new CheckBox("Показать надпись");
        box3.setSelected(true);

        box1.setOnAction(e ->{
            myButton.setVisible(box1.isSelected());
            myButton.setManaged(box1.isSelected());
        });

        box2.setOnAction(e ->{
            myTextfield.setVisible(box2.isSelected());
            myTextfield.setManaged(box2.isSelected());
        });

        box3.setOnAction(e ->{
            myLabel.setVisible(box3.isSelected());
            myLabel.setManaged(box3.isSelected());
        });

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);
        grid.setVgap(15);
        grid.setPadding(new Insets(20));

        grid.add(box1,0,0); grid.add(myButton,1,0);
        grid.add(box2,0,1); grid.add(myTextfield,1,1);
        grid.add(box3,0,2); grid.add(myLabel,1,2);

        Scene scene = new Scene(grid,450,200);
        primaryStage.setTitle("Управление видимостью");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}