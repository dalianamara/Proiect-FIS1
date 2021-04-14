package Admin.ui.Dashboard;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXTabPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainController  {
    @FXML
    private StackPane rootPane;
    @FXML
    private JFXDrawer drawer;
    @FXML
    private AnchorPane rootAnchorPane;
    @FXML
    private JFXTabPane mainTabPane;

    public void initialize(URL url, ResourceBundle rb) {
        initComponents();
    }

    private Stage getStage() {
        return (Stage) rootPane.getScene().getWindow();
    }

    @FXML
    private void handleMenuClose(ActionEvent event) {
        getStage().close();
    }

    @FXML
    private void handleMenuAddMember(ActionEvent event) {
        loadWindow(getClass().getResource("/AddL/Admin.fxml"), "Adaugă bibliotecar", null);
    }
    @FXML
    private void handleMenuFullScreen(ActionEvent event) {
        Stage stage = getStage();
        stage.setFullScreen(!stage.isFullScreen());
    }


    private void initComponents() {
        mainTabPane.tabMinWidthProperty().bind(rootAnchorPane.widthProperty().divide(mainTabPane.getTabs().size()).subtract(15));
    }

    @FXML
    private void handleMenuOverdueNotification(ActionEvent event) {
        loadWindow(getClass().getResource("/SendEmail/Email.fxml"), "Trimite notificare", null);
    }

    public void handleMenuAddCard(ActionEvent actionEvent) {
        loadWindow(getClass().getResource("/LibraryCard/card.fxml"), "Emite card", null);
    }

    public void handleAddLib(MouseEvent mouseEvent) {
        loadWindow(getClass().getResource("/AddL/Admin.fxml"), "Adaugă bibliotecar", null);

    }

    public void handleEmiteCard(MouseEvent mouseEvent) {
        loadWindow(getClass().getResource("/LibraryCard/card.fxml"), "Emite card", null);
    }

    public void handleSendEmail(MouseEvent mouseEvent) {
        loadWindow(getClass().getResource("/SendEmail/Email.fxml"), "Trimite notificare", null);

    }

    public void handleMenuDeleteLibrarian(ActionEvent actionEvent) {
        loadWindow(getClass().getResource("/DeleteLibrarian/Librarian.fxml"), "Sterge bibliotecar", null);
    }
    public void handleMenuEditLibrarian(ActionEvent actionEvent) {
        loadWindow(getClass().getResource("/EditLibrarian/Librarian.fxml"), "Editează bibliotecar", null);
    }
    public static Object loadWindow(URL loc, String title, Stage parentStage) {
        Object controller = null;
        try {
            FXMLLoader loader = new FXMLLoader(loc);
            Parent parent = loader.load();
            controller = loader.getController();
            Stage stage = null;
            if (parentStage != null) {
                stage = parentStage;
            } else {
                stage = new Stage(StageStyle.DECORATED);
            }
            stage.setTitle(title);
            stage.setScene(new Scene(parent));
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return controller;
    }
}
