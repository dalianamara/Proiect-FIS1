package Admin.ui.AddL;

import Admin.ui.dbUtil.dbConnection2;
import Admin.ui.util.AdminUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class AdminController implements Initializable
{
  @FXML
  private TextField id;
  @FXML
  private TextField firstname;
  @FXML
  private TextField lastname;
  @FXML
  private TextField email;
  @FXML
  private TextField adresa;
  @FXML
  private TextField telefon;
  @FXML
  private TableView<LibrarianData> studenttable;
  @FXML
  private TableColumn<LibrarianData, String> idcolumn;
  @FXML
  private TableColumn<LibrarianData, String> firstnamecolumn;
  @FXML
  private TableColumn<LibrarianData, String> lastnamecolumn;
  @FXML
  private TableColumn<LibrarianData, String> emailcolumn;
  @FXML
  private TableColumn<LibrarianData, String> adresacolumn;
  @FXML
  private TableColumn<LibrarianData, String> telefoncolumn;
  @FXML
  private Button loadbutton;
  private ObservableList<LibrarianData> data;
  private dbConnection2 dc;



  public void initialize(URL url, ResourceBundle rb)
  {
    this.dc = new dbConnection2();
  }
  
  @FXML
  private void loadStudentData(ActionEvent event)
  {
    try
    {
      Connection conn = dbConnection2.getConnection();
      this.data = FXCollections.observableArrayList();
      
      ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM bibliotecari");
      while (rs.next()) {
        this.data.add(new LibrarianData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
      }
    }
    catch (SQLException e)
    {
      System.err.println("Eroare " + e);
    }
    this.idcolumn.setCellValueFactory(new PropertyValueFactory("ID"));
    this.firstnamecolumn.setCellValueFactory(new PropertyValueFactory("firstName"));
    this.lastnamecolumn.setCellValueFactory(new PropertyValueFactory("lastName"));
    this.emailcolumn.setCellValueFactory(new PropertyValueFactory("email"));
    this.adresacolumn.setCellValueFactory(new PropertyValueFactory("adresa"));
    this.telefoncolumn.setCellValueFactory(new PropertyValueFactory("telefon"));
    this.studenttable.setItems(null);
    this.studenttable.setItems(this.data);
  }

    @FXML
  private void addLibrarian(ActionEvent event) throws InterruptedException {
      String sql = "INSERT INTO bibliotecari (id, fname, lname, email, adresa, telefon) VALUES (? , ?, ?, ?, ?, ?)";
    try
    {
      Connection conn = dbConnection2.getConnection();
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, this.id.getText());
      stmt.setString(2, this.firstname.getText());
      stmt.setString(3, this.lastname.getText());
      stmt.setString(4, this.email.getText());
      stmt.setString(5, this.adresa.getText());
      stmt.setString(6, this.telefon.getText());
      stmt.execute();
      conn.close();
    }
    catch (SQLException e)
    {
      System.err.println("Exceptie!");
      System.err.println(e.getMessage());
    }
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setHeaderText("Adaugare cu succes");
    String s ="Bibliotecarul a fost adaugat cu succes! ";
    alert.setContentText(s);
    alert.show();
    TimeUnit.SECONDS.sleep(1);
    alert.close();
      try
      {
        Connection conn = dbConnection2.getConnection();
        this.data = FXCollections.observableArrayList();

        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM bibliotecari");
        while (rs.next()) {
          this.data.add(new LibrarianData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
        }
      }
      catch (SQLException e)
      {
        System.err.println("Eroare " + e);
      }
      this.idcolumn.setCellValueFactory(new PropertyValueFactory("ID"));
      this.firstnamecolumn.setCellValueFactory(new PropertyValueFactory("firstName"));
      this.lastnamecolumn.setCellValueFactory(new PropertyValueFactory("lastName"));
      this.emailcolumn.setCellValueFactory(new PropertyValueFactory("email"));
      this.adresacolumn.setCellValueFactory(new PropertyValueFactory("adresa"));
      this.telefoncolumn.setCellValueFactory(new PropertyValueFactory("telefon"));
      this.studenttable.setItems(null);
      this.studenttable.setItems(this.data);
  }
  
  @FXML
  private void clearFields(ActionEvent event)
  {
    this.id.setText("");
    this.firstname.setText("");
    this.lastname.setText("");
    this.email.setText("");
    this.adresa.setText("");
    this.telefon.setText("");
  }

  public void sendOTP(ActionEvent actionEvent) {
    AdminUtil.loadWindow(getClass().getResource("/AddL/FXMLDocument.fxml"), "Trimite notificare", null);
  }
}
