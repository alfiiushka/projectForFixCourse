package ru.ivmiit.alfia.dao;

import ru.ivmiit.alfia.model.Product;

import java.util.List;

public interface ProductDao extends AbstractDao<Product> {

    List<Product> getAllProducts();

}
