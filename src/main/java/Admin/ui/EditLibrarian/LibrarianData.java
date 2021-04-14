package Admin.ui.EditLibrarian;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LibrarianData
{
  private final StringProperty ID;
  private final StringProperty titlu;
  private final StringProperty autor;
  private final StringProperty editie;
  private final StringProperty an;
  private final StringProperty raft;
  private final StringProperty exemplare;
  private final StringProperty subiect;
  private final StringProperty pagini;

  public LibrarianData(String id, String titlu, String autor, String editie, String an, String raft, String exemplare, String subiect, String pagini)
  {
    this.ID = new SimpleStringProperty(id);
    this.titlu = new SimpleStringProperty(titlu);
    this.autor = new SimpleStringProperty(autor);
    this.an = new SimpleStringProperty(an);
    this.subiect = new SimpleStringProperty(subiect);
    this.editie = new SimpleStringProperty(editie);
    this.pagini = new SimpleStringProperty(pagini);
    this.exemplare = new SimpleStringProperty(exemplare);
    this.raft = new SimpleStringProperty(raft);
  }
  //getters
  public String getID()
  {
    return (String)this.ID.get();
  }
  
  public String getTitlu()
  {
    return (String)this.titlu.get();
  }
  
  public String getAutor()
  {
    return (String)this.autor.get();
  }
  
  public String getEditie()
  {
    return (String)this.editie.get();
  }
  
  public String getAn()
  {
    return (String)this.an.get();
  }

  public String getRaft()
{
  return (String)this.raft.get();
}

  public String getExemplare()
  {
    return (String)this.exemplare.get();
  }
  public String getSubiect()
  {
    return (String)this.subiect.get();
  }
  public String getPagini()
  {
    return (String)this.pagini.get();
  }

  //setters
  public void setID(String value)
  {
    this.ID.set(value);
  }
  
  public void setTitlu(String value)
  {
    this.titlu.set(value);
  }
  
  public void setAutor(String value)
  {
    this.autor.set(value);
  }
  
  public void setditie(String value)
  {
    this.editie.set(value);
  }
  
  public void setAn(String value)
  {
    this.an.set(value);
  }

  public void setRaft(String value)
  {
    this.raft.set(value);
  }

  public void setPagini(String value)
  {
    this.pagini.set(value);
  }

  public void setSubiect(String value)
  {
    this.subiect.set(value);
  }

  public void setExemplare(String value)
  {
    this.exemplare.set(value);
  }


  public StringProperty idProperty()
  {
    return this.ID;
  }
  
  public StringProperty titluProperty()
  {
    return this.titlu;
  }
  
  public StringProperty autorProperty()
  {
    return this.autor;
  }
  
  public StringProperty editieProperty()
  {
    return this.editie;
  }
  
  public StringProperty anProperty()
  {
    return this.an;
  }

  public StringProperty raftProperty()
  {
    return this.raft;
  }

  public StringProperty subiectProperty()
  {
    return this.subiect;
  }

  public StringProperty exemplareProperty()
  {
    return this.exemplare;
  }

  public StringProperty paginiProperty()
  {
    return this.pagini;
  }

}
