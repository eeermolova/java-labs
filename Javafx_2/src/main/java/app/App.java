package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.DrawingModel;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        DrawingModel model = new DrawingModel();

        FXMLLoader loader = new FXMLLoader(App.class.getResource("main-view.fxml"));
        loader.setControllerFactory(type -> new MainController(model));

        Scene scene = new Scene(loader.load());
        stage.setTitle("JavaFX 2 — Фигуры на холсте");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
