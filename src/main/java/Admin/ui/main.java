package Admin.ui;


import javafx.application.Application;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/LoginAdmin/login.fxml"));
        primaryStage.setTitle("Admin");
        primaryStage.setScene(new Scene(root, 1036, 705));
        primaryStage.show();
    }
}
