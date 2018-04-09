package ru.ivmiit.alfia.dao;

import ru.ivmiit.alfia.model.StoreUser;

public interface StoreUserDao extends AbstractDao<StoreUser> {

    boolean isExist(String login, String password);

    StoreUser findbylogin(String login);

}
