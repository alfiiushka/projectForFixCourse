package ru.ivmiit.alfia.model;

public class StoreUser {
    private String login;
    private String password;

    public StoreUser() {
    }

    public StoreUser(String login, String password) {
        this.login = login;
        this.password = password;
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
}
