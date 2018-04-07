package ru.ivmiit.alfia.repository;

import ru.ivmiit.alfia.model.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> getAllProducts();

    void saveProduct(Product product);

}
