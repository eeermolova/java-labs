import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//стоит ли добавлять не по одному блюду, а по несколько(счетчик тип)

public class RestaurantApp extends Application{

    @Override
    public void start(Stage primaryStage){
        String dish1Name = "Пицца с креветками"; int dish1Price = 1450;
        String dish2Name = "Суп Том Ям"; int dish2Price = 890;
        String dish3Name = "Салат Цезарь"; int dish3Price = 650;

        CheckBox chb1 = new CheckBox(dish1Name + "( " + dish1Price + " руб.)");
        CheckBox chb2 = new CheckBox(dish2Name + "( " + dish2Price + " руб.)");
        CheckBox chb3 = new CheckBox(dish3Name + "( " + dish3Price + " руб.)");

        TextField countField1 = new TextField("0"); countField1.setDisable(true); countField1.setPrefWidth(50);
        TextField countField2 = new TextField("0"); countField2.setDisable(true); countField2.setPrefWidth(50);
        TextField countField3 = new TextField("0"); countField3.setDisable(true); countField3.setPrefWidth(50);

        chb1.setOnAction(e ->{
            countField1.setDisable(!chb1.isSelected());
            countField1.setText(chb1.isSelected() ? "1" : "0");
        });

        chb2.setOnAction(e ->{
            countField2.setDisable(!chb2.isSelected());
            countField2.setText(chb2.isSelected() ? "1" : "0");
        });

        chb3.setOnAction(e ->{
            countField3.setDisable(!chb3.isSelected());
            countField3.setText(chb3.isSelected() ? "1" : "0");
        });

        Button orderButton = new Button("Оформить заказ");
        TextArea receiptArea = new TextArea();
        receiptArea.setDisable(false);
        receiptArea.setPromptText("Здесь отобразится ваш чек");

        orderButton.setOnAction(e ->{
            StringBuilder receipt = new StringBuilder("---ВАШ ЧЕК---\n\n");
            int totalSum = 0;

            if(chb1.isSelected()){
                int count = Integer.parseInt(countField1.getText());
                int cost = count * dish1Price;
                receipt.append(String.format("%s x%d = %d руб.\n", dish1Name,count,cost));
                totalSum += cost;
            }
            if(chb2.isSelected()){
                int count = Integer.parseInt(countField2.getText());
                int cost = count * dish2Price;
                receipt.append(String.format("%s x%d = %d руб.\n", dish2Name,count,cost));
                totalSum += cost;
            }
            if(chb3.isSelected()){
                int count = Integer.parseInt(countField3.getText());
                int cost = count * dish3Price;
                receipt.append(String.format("%s x%d = %d руб.\n", dish3Name,count,cost));
                totalSum += cost;
            }

            receipt.append("\n-----------------------------\n");
            receipt.append("ИТОГО К ОПЛАТЕ: ").append(totalSum).append(" руб.");

            receiptArea.setText(receipt.toString());
        });

        GridPane grid = new GridPane();
        grid.setHgap(20);
        grid.setVgap(10);
        grid.add(chb1,0,0); grid.add(countField1,1,0);
        grid.add(chb2,0,1); grid.add(countField2,1,1);
        grid.add(chb3,0,2); grid.add(countField3,1,2);

        VBox root = new VBox(15);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.TOP_CENTER);
        root.getChildren().addAll(grid, orderButton,receiptArea);

        Scene scene = new Scene(root,400,500);
        primaryStage.setTitle("Заказ в ресторане");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
