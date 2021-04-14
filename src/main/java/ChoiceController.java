import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class ChoiceController {
    @FXML
    private ImageView adminPIC;
    @FXML
    private ImageView librarianPIC;
    @FXML
    private ImageView studentPIC;


    public void handleAdminMenu(MouseEvent mouseEvent) {
        Stage mainStage = (Stage) adminPIC.getScene().getWindow();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/LoginAdmin/login.fxml"));
            Scene scene = new Scene(root);
            mainStage.setScene(scene);
            mainStage.setTitle("Administrator");
        }
        catch(Exception e){}
    }

    public void handleLibrarianMenu(MouseEvent mouseEvent) {
        Stage mainStage = (Stage) librarianPIC.getScene().getWindow();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/LoginBibliotecar/login.fxml"));
            Scene scene = new Scene(root);
            mainStage.setScene(scene);
            mainStage.setTitle("Bibliotecar");
        }
        catch(Exception e){}
    }

    public void handleStudentMenu(MouseEvent mouseEvent) {
        Stage mainStage = (Stage) studentPIC.getScene().getWindow();
        try {

            mainStage.setTitle("Student");
        }
        catch(Exception e){
            System.err.println("Exceptie!");
            System.err.println(e.getMessage());
        }
    }
}