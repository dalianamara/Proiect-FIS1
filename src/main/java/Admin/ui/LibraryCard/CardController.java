package Admin.ui.LibraryCard;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class CardController implements Initializable {
    @FXML
    private JFXTextField username2;
    @FXML
    private JFXTextField ID;
    @FXML
    private JFXTextField username;


    public void handleLoginButtonAction(ActionEvent actionEvent) throws InterruptedException {
        //crearea fisierului pentru persistarea credențialelor
        JSONObject obj = new JSONObject();
        JSONArray jrr = new JSONArray();
        JSONParser jp = new JSONParser();
        try{
            FileReader file = new FileReader("src/main/resources/Databases/Card.json");
            jrr=(JSONArray)jp.parse(file);
        }catch(Exception ex){

        }


        obj.put("Nume", username.getText());
        obj.put("Prenume", username2.getText());
        obj.put("ID", ID.getText());
        jrr.add(obj);
        try{
            FileWriter file = new FileWriter("src/main/resources/Databases/Card.json");
            file.write(jrr.toJSONString());
            file.close();
        }catch(Exception ex){

        }
        //crearea unei casete de text
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Emitere cu succes");
        String s ="Cardul a fost emis cu succes! ";
        alert.setContentText(s);
        alert.show();
        TimeUnit.SECONDS.sleep(1);
        alert.close();

    }

    public void handleCancelButtonAction(ActionEvent actionEvent) {
        System.exit(0);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TO DO
    }
}
