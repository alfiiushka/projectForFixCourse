package ru.ivmiit.projectFixCourse.dao;

import ru.ivmiit.projectFixCourse.model.Product;

import java.util.List;

public interface ProductDao extends AbstractDao<Product> {

    List<Product> getAllProducts();

}
