package ru.ivmiit.projectFixCourse.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.ivmiit.projectFixCourse.config.DaoConfig;
import ru.ivmiit.projectFixCourse.model.Product;

import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDaoJdbcTemplateImpl implements ProductDao {

    private JdbcTemplate template;

    public ProductDaoJdbcTemplateImpl() {
        DaoConfig daoConfig = new DaoConfig();
        try {
            this.template = new JdbcTemplate(daoConfig.getDataSource());
        } catch (IOException e) {
            throw new Error(e.getMessage());
        }

    }

    private Map<Integer, Product> productMap = new HashMap<>();

    private RowMapper<Product> productRowMapper
            = (ResultSet resultSet, int i) -> {
        Integer id = resultSet.getInt("id");

        if (!productMap.containsKey(id)) {
            String name = resultSet.getString("name");
            Product product = new Product(name);
            productMap.put(id, product);
        }

        return productMap.get(id);
    };

    @Override
    public List<Product> getAllProducts() {
        String getAllQuery = "SELECT * FROM product";
        return template.query(getAllQuery, productRowMapper);
    }

    @Override
    public void save(Product product) {
        String insertString = "INSERT INTO product(name) VALUES (?)";
        template.update(insertString, product.getName());
    }
}
