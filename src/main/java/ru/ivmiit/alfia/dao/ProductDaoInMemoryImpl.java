package ru.ivmiit.alfia.dao;

import ru.ivmiit.alfia.fakeDataBase.ProductStorage;
import ru.ivmiit.alfia.model.Product;

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
