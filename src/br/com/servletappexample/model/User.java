package br.com.servletappexample.model;

public class User {

    private String login;
    private String password;

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
    
    public boolean isEqual(String login, String password) {

        return (this.login.equals(login) && this.password.equals(password));
    }
}