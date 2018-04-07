package ru.ivmiit.alfia.repository;

import ru.ivmiit.alfia.config.DaoConfig;
import ru.ivmiit.alfia.model.StoreUser;
import ru.ivmiit.alfia.security.SecurityService;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserRepositoryJDBCImpl implements UserRepository {

    private DaoConfig daoConfig = new DaoConfig();

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
        return user != null && SecurityService.checkPassword(password, user.getPassword());
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
