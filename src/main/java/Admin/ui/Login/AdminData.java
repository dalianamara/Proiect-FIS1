package Admin.ui.Login;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AdminData {
        private final StringProperty username;
        private final StringProperty password;


        public AdminData(String username, String password)
        {
            this.username = new SimpleStringProperty(username);
            this.password = new SimpleStringProperty(password);
        }
        public String getEmail()
        {
            return (String)this.username.get();
        }

        public String getPass()
        {
            return (String)this.password.get();
        }


        public void setEmail(String value)
        {
            this.username.set(value);
        }

        public void setPassword(String value)
        {
            this.password.set(value);
        }

        public StringProperty emailProperty()
        {
            return this.username;
        }

        public StringProperty passProperty()
        {
            return this.password;
        }
}
