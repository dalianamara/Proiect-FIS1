package Admin.ui.SendEmail;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class EmailController implements Initializable {

    @FXML
    private JFXTextField emailid;
    @FXML
    private JFXTextField subject;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXTextArea message;
    @FXML
    private JFXTextField receiverid;
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void handleSendButton(ActionEvent event) throws InterruptedException {
        
        SendEmail(emailid.getText(), password.getText(), receiverid.getText(), subject.getText() ,message.getText());
    }
    
    private void   SendEmail(final String user, final String pass, String to, String sub, String msg) throws InterruptedException {
        Properties prop= new Properties();
        
         prop.put("mail.smtp.ssl.trust","smtp.gmail.com");
         prop.put("mail.smtp.auth",true);
         prop.put("mail.smtp.starttls.enable",true);
         prop.put("mail.smtp.host","smtp.gmail.com");
         prop.put("mail.smtp.port","587");
         
         
         Session session= Session.getInstance(prop, new javax.mail.Authenticator()
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
             message1.setText(msg);
             
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
    
}
