package Admin.ui.OTP;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LibrarianData
{
  private final StringProperty email;
  private final StringProperty password;


  public LibrarianData(String email, String password)
  {
    this.email = new SimpleStringProperty(email);
    this.password = new SimpleStringProperty(password);
  }
  public String getEmail()
  {
    return (String)this.email.get();
  }
  
  public String getPass()
  {
    return (String)this.password.get();
  }

  
  public void setEmail(String value)
  {
    this.email.set(value);
  }
  
  public void setPassword(String value)
  {
    this.password.set(value);
  }
  
  public StringProperty emailProperty()
  {
    return this.email;
  }
  
  public StringProperty passProperty()
  {
    return this.password;
  }
}
