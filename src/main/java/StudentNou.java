public class StudentNou {
    private String user, parola, nume, telefon, email;

    public StudentNou(String user, String nume,String email, String parola, String telefon ) {

        this.user = user;
        this.parola = parola;
        this.nume = nume;
        this.email = email;
        this.telefon = telefon;
    }

    public String getUser() {
        return user;
    }

    public String getParola() {
        return parola;
    }

    public String getNume() {
        return nume;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "StudentNou{" +
                "user='" + user + '\'' +
                ", parola='" + parola + '\'' +
                ", nume='" + nume + '\'' +
                ", telefon='" + telefon + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
    public boolean equals(Object o) {
        if(o instanceof StudentNou)
        {
            StudentNou s=(StudentNou)o;
            return s.getTelefon().equals(this.getTelefon());
        }

        else
            return false;
    }

}
