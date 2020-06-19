package Admin.ui.main;

import Admin.ui.util.AdminUtil;
import com.jfoenix.controls.JFXDrawer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import com.jfoenix.controls.JFXTabPane;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
        AdminUtil.loadWindow(getClass().getResource("/AddL/Admin.fxml"), "Adaugă bibliotecar", null);
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
        AdminUtil.loadWindow(getClass().getResource("/SendEmail/FXMLDocument.fxml"), "Trimite notificare", null);
    }

    public void handleMenuAddCard(ActionEvent actionEvent) {
        AdminUtil.loadWindow(getClass().getResource("/LibraryCard/card.fxml"), "Emite card", null);
    }
}
