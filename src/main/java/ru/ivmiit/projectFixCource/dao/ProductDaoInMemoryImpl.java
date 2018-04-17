package ru.ivmiit.projectFixCource.dao;

import ru.ivmiit.projectFixCource.fakeDataBase.ProductStorage;
import ru.ivmiit.projectFixCource.model.Product;

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
