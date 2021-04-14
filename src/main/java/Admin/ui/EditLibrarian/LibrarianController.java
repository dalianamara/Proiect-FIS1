package Admin.ui.EditLibrarian;

import Admin.ui.AddL.LibrarianData;
import Admin.ui.dbUtil.dbConnection2;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class LibrarianController implements Initializable {
    PreparedStatement pst;
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
    private Connection conn;

    public void initialize(URL url, ResourceBundle rb) {
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


    private void refresh()
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
    private Connection connect() {
        String url = "jdbc:sqlite:src/main/resources/Databases/login.sqlite";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    public void editLibrarian(ActionEvent actionEvent) throws InterruptedException {
        String query = ("UPDATE bibliotecari SET fname =?,lname =?,email=?,adresa=?,telefon=? WHERE id=?");
        try
        {
            Connection conn = dbConnection2.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, this.firstname.getText());
            stmt.setString(2, this.lastname.getText());
            stmt.setString(3, this.email.getText());
            stmt.setString(4, this.adresa.getText());
            stmt.setString(5, this.telefon.getText());
            stmt.setString(6, this.id.getText());
            stmt.execute();
            conn.close();
        }
        catch (SQLException e)
        {
            System.err.println("Exceptie!!");
            System.err.println(e.getMessage());
        }
        refresh();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Editare cu succes");
        String s ="Bibliotecarul a fost editat cu succes! ";
        alert.setContentText(s);
        alert.show();
        TimeUnit.SECONDS.sleep(1);
        alert.close();
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
}
