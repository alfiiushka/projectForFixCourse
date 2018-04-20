package ru.ivmiit.projectFixCourse.dao;

import ru.ivmiit.projectFixCourse.config.DaoConfig;
import ru.ivmiit.projectFixCourse.model.StoreUser;
import ru.ivmiit.projectFixCourse.security.SecurityService;
import ru.ivmiit.projectFixCourse.security.SecurityServiceImpl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StoreUserDaoJDBCImpl implements StoreUserDao {

    private DaoConfig daoConfig;
    private SecurityService securityService;

    public StoreUserDaoJDBCImpl() {
        this.daoConfig = new DaoConfig();
        this.securityService = new SecurityServiceImpl();
    }

    @Override
    public void save(StoreUser user) {
        try (Connection connection = daoConfig.getConnection()) {
            String insertString = "INSERT INTO store_user(login,password) VALUES (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertString);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.executeUpdate();

        } catch (ClassNotFoundException | SQLException | IOException e) {
            throw new Error(e.getMessage());
        }

    }

    @Override
    public boolean isExist(String login, String password) {
        StoreUser user = findbylogin(login);
        return user != null && securityService.checkPassword(password, user.getPassword());
    }

    @Override
    public StoreUser findbylogin(String login) {
        try (Connection connection = daoConfig.getConnection()) {
            String insertString = "SELECT * FROM store_user where login=?";
            PreparedStatement preparedStatement = connection.prepareStatement(insertString);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
                return new StoreUser(resultSet.getString("login"), resultSet.getString("password"));
            else return null;
        } catch (ClassNotFoundException | SQLException | IOException e) {
            throw new Error(e.getMessage());
        }
    }
}
