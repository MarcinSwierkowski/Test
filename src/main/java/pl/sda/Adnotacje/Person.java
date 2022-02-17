package pl.sda.Adnotacje;

public class Person {
    private String login;
    @Sensitive(value = "password")
    private String password;
    private String pesel;

    public Person(String login, String password, String pesel) {
        this.login = login;
        this.password = password;
        this.pesel = pesel;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Sensitive
    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }
}
