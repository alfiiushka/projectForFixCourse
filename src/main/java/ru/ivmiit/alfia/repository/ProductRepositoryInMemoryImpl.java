package ru.ivmiit.alfia.repository;

import ru.ivmiit.alfia.fakeDataBase.ProductStorage;
import ru.ivmiit.alfia.model.Product;

import java.util.List;

public class ProductRepositoryInMemoryImpl implements ProductRepository {

    @Override
    public void saveProduct(Product product) {
        ProductStorage.getInstance().add(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return ProductStorage.getInstance();
    }
}
