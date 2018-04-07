package ru.ivmiit.alfia.repository;

import ru.ivmiit.alfia.config.DaoConfig;
import ru.ivmiit.alfia.model.Product;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryJDBCImpl implements ProductRepository {

    private DaoConfig daoConfig = new DaoConfig();

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = daoConfig.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM product");
            while (result.next()) {
                Product product = new Product();
                product.setName(result.getString("name"));
                products.add(product);
            }
        } catch (ClassNotFoundException | SQLException | IOException e) {
            throw new Error(e.getMessage());
        }
        return products;
    }

    @Override
    public void saveProduct(Product product) {
        try (Connection connection = daoConfig.getConnection()) {
            String insertString = "INSERT INTO product(name) VALUES (?)";
            PreparedStatement preparedStatement=connection.prepareStatement(insertString);
            preparedStatement.setString(1,product.getName());
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException | IOException e) {
            throw new Error(e.getMessage());
        }
    }
}
