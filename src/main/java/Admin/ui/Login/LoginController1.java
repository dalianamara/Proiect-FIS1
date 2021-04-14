package Admin.ui.Login;

import Admin.ui.OTP.LibrarianData;
import Admin.ui.OTP.*;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.apache.commons.codec.digest.DigestUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class LoginController1 {
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXTextField username;

    public static JSONArray readFromFile(String fileName){
        JSONParser parser=new JSONParser();
        JSONArray list=new JSONArray();
        try{
            Reader reader=new FileReader(fileName);
            list=(JSONArray)parser.parse(reader);
        }catch(IOException e){
            e.printStackTrace();
        }catch(ParseException e){
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<AdminData> getDriver() {
        JSONArray list = readFromFile("src/main/resources/Databases/Admin.json");
        ArrayList<AdminData> administrator = new ArrayList<AdminData>();
        Iterator<JSONObject> it = list.iterator();
        while (it.hasNext()) {
            JSONObject obj = it.next();
            String objInt = (String) obj.get("Username");
            String objInt2 = (String) obj.get("Password");
            AdminData s = new AdminData(objInt, objInt2);
            administrator.add(s);
        }
        return administrator;
    }

    public void handleLoginButtonAction(ActionEvent actionEvent) throws InterruptedException {
        String uname = username.getText();
        String pass = password.getText();
        ArrayList<AdminData> administrator= getDriver();
        Iterator<AdminData> it=administrator.iterator();
        while(it.hasNext()) {
            AdminData s = it.next();
            if (s.getEmail().equals(uname) && s.getPass().equals(DigestUtils.shaHex(pass))) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Autentificare cu succes!");
                String mesj = "Autentificarea s-a realizat cu succes!";
                alert.setContentText(mesj);
                alert.show();
                TimeUnit.SECONDS.sleep(1);
                alert.close();
                closeStage();
                loadMain();
            }
            else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Login failed!");
                if (uname.isEmpty() || pass.isEmpty())
                {
                    String mesj = "Empty field!";
                    alert.setContentText(mesj);
                }
                else
                {
                    String mesj = "Username or password is incorrect!";
                    alert.setContentText(mesj);
                }

                alert.show();
                TimeUnit.SECONDS.sleep(1);
                alert.close();
            }
        }
    }

    @FXML
    private void handleCancelButtonAction(ActionEvent event) {
        System.exit(0);
    }

    private void closeStage() {
        ((Stage) username.getScene().getWindow()).close();
    }

    void loadMain() {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/AddL/main.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Administrator");
            stage.setScene(new Scene(parent));
            stage.show();
        }
        catch (IOException ex) {
            System.err.println("Exception!");
            System.err.println(ex.getMessage());
        }
    }
}
