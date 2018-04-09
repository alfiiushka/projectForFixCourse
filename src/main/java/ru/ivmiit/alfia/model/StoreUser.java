package ru.ivmiit.alfia.model;

import javax.persistence.*;

@Entity
@Table(name = "store_user")
public class StoreUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "login")
    private String login;
    @Column(name = "password")
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
