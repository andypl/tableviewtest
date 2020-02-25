package pl.info.czerniak.tableviewtest.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("/fxml/tablePane.fxml"));
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Dodaj człowieka do tabeli");
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        System.out.println("To już jest koniec...nie ma już nic...jesteśmy wolni...możemy iść pić :)");
        super.stop();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
