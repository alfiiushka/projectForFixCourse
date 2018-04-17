package ru.ivmiit.projectFixCource.dao;

import ru.ivmiit.projectFixCource.model.Product;

import java.util.List;

public interface ProductDao extends AbstractDao<Product> {

    List<Product> getAllProducts();

}
