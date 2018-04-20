package ru.ivmiit.projectFixCourse.dao;

import ru.ivmiit.projectFixCourse.fakeDataBase.ProductStorage;
import ru.ivmiit.projectFixCourse.model.Product;

import java.util.List;

public class ProductDaoInMemoryImpl implements ProductDao {

    @Override
    public void save(Product product) {
        ProductStorage.getInstance().add(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return ProductStorage.getInstance();
    }
}
