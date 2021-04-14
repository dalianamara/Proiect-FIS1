package Admin.ui.OTP;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class FXMLDocumentController implements Initializable {

    @FXML
    private JFXTextField emailid;
    @FXML
    private JFXTextField subject;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXTextField receiverid;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleSendButton(ActionEvent event) throws InterruptedException {
        SendEmail(emailid.getText(), password.getText(), receiverid.getText());
    }
    
    private void   SendEmail(final String user, final String pass, String to) throws InterruptedException {
        Properties prop= new Properties();
        String sub = "Parola unică";
        String otp_generated = generateOTP();
        String otpString  = "Parola ta unică pentru înregistrare este: " + otp_generated +". Utilizează această parolă pentru ați valida autentificarea.";//function calling
         prop.put("mail.smtp.ssl.trust","smtp.gmail.com");
         prop.put("mail.smtp.auth",true);
         prop.put("mail.smtp.starttls.enable",true);
         prop.put("mail.smtp.host","smtp.gmail.com");
         prop.put("mail.smtp.port","587");
        JSONObject obj = new JSONObject();
        JSONArray jrr = new JSONArray();
        JSONParser jp = new JSONParser();
        try{
            //crearea unui fisier pentru stocarea credentialelor(username si OTP)
            FileReader file = new FileReader("src/main/resources/Databases/OTP.json");
            jrr=(JSONArray)jp.parse(file);
        }catch(Exception ex){
        }
        obj.put("Username", receiverid.getText());
        obj.put("OTP", otp_generated);
        jrr.add(obj);
        try{
            FileWriter file = new FileWriter("src/main/resources/Databases/OTP.json");
            file.write(jrr.toJSONString());
            file.close();
        }catch(Exception ex){
        }

        Session session;
        session = Session.getInstance(prop, new javax.mail.Authenticator()
        {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication()
            {
                return new javax.mail.PasswordAuthentication(user, pass);
            }

        });
        try
         {
             Message message1= new MimeMessage(session);
             message1.setFrom( new InternetAddress("no-reply@gmail.com"));
             message1.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
             message1.setSubject(sub);
             message1.setText(otpString);
             Transport.send(message1);
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setHeaderText("Trimitere cu succes");
             String s ="Email-ul a fost trimis cu succes! ";
             alert.setContentText(s);
             alert.show();
             TimeUnit.SECONDS.sleep(1);
             alert.close();
         }   
         
         catch(Exception e)
         {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setHeaderText("Eroare");
             String s ="Email-ul nu a putut fi trimis! ";
             alert.setContentText(s);
             alert.show();
             TimeUnit.SECONDS.sleep(1);
             alert.close();
         }
    }


    public char[] OTP(int len)
    {
        // folosim valori numerice
        String numbers = "0123456789";

        // folosim random pentru generare
        Random rndm_method = new Random();

        char[] otp = new char[len];

        for (int i = 0; i < len; i++)
        {
            otp[i] =
                    numbers.charAt(rndm_method.nextInt(numbers.length())); //charAt -> ia valoarea caracterului
        }
        return otp;
    }

    public static String generateOTP()
        {
            int randomPin   =(int) (Math.random()*9000)+1000; //pentru a stoca otp-ul
            String otp  = String.valueOf(randomPin);
            return otp; //returneaza valoarea otp-ului
        }
}
