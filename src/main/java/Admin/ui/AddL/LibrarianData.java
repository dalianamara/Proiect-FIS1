package Admin.ui.AddL;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LibrarianData
{
  private final StringProperty ID;
  private final StringProperty firstName;
  private final StringProperty lastName;
  private final StringProperty email;
  private final StringProperty adresa;
  private final StringProperty telefon;
  
  public LibrarianData(String id, String firstname, String lastname, String email, String adresa, String telefon)
  {
    this.ID = new SimpleStringProperty(id);
    this.firstName = new SimpleStringProperty(firstname);
    this.lastName = new SimpleStringProperty(lastname);
    this.email = new SimpleStringProperty(email);
    this.adresa = new SimpleStringProperty(adresa);
    this.telefon = new SimpleStringProperty(telefon);
  }
  
  public String getID()
  {
    return (String)this.ID.get();
  }
  
  public String getFirstName()
  {
    return (String)this.firstName.get();
  }
  
  public String getLastName()
  {
    return (String)this.lastName.get();
  }
  
  public String getEmail()
  {
    return (String)this.email.get();
  }
  
  public String getAdresa()
  {
    return (String)this.adresa.get();
  }

  public String getTelefon()
  {
    return (String)this.telefon.get();
  }
  
  public void setID(String value)
  {
    this.ID.set(value);
  }
  
  public void setFirstName(String value)
  {
    this.firstName.set(value);
  }
  
  public void setLastName(String value)
  {
    this.lastName.set(value);
  }
  
  public void setEmail(String value)
  {
    this.email.set(value);
  }
  
  public void setAdresa(String value)
  {
    this.adresa.set(value);
  }

  public void setTelefon(String value)
  {
    this.telefon.set(value);
  }
  
  public StringProperty idProperty()
  {
    return this.ID;
  }
  
  public StringProperty firstNameProperty()
  {
    return this.firstName;
  }
  
  public StringProperty lastNameProperty()
  {
    return this.lastName;
  }
  
  public StringProperty emailProperty()
  {
    return this.email;
  }
  
  public StringProperty dobProperty()
  {
    return this.adresa;
  }

  public StringProperty telefonProperty()
  {
    return this.telefon;
  }

}
