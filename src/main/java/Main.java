import javafx.application.Application;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/Choice/Choice.fxml"));
        primaryStage.setTitle("Library Management");
        primaryStage.setScene(new Scene(root, 1036, 705));
        primaryStage.show();
    }
}
