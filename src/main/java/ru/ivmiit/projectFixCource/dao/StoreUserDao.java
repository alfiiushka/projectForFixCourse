package ru.ivmiit.projectFixCource.dao;

import ru.ivmiit.projectFixCource.model.StoreUser;

public interface StoreUserDao extends AbstractDao<StoreUser> {

    boolean isExist(String login, String password);

    StoreUser findbylogin(String login);

}
