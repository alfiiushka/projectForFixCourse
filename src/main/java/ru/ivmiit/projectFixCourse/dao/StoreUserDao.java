package ru.ivmiit.projectFixCourse.dao;

import ru.ivmiit.projectFixCourse.model.StoreUser;

public interface StoreUserDao extends AbstractDao<StoreUser> {

    boolean isExist(String login, String password);

    StoreUser findbylogin(String login);

}
