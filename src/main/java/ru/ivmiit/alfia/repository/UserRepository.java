package ru.ivmiit.alfia.repository;

import ru.ivmiit.alfia.model.StoreUser;

import java.util.List;

public interface UserRepository {

    void save(StoreUser user);

    boolean isExist(String login, String password);

    StoreUser findbylogin(String login);

}
