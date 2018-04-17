package ru.ivmiit.projectFixCource.dao;

public interface AbstractDao<T> {
    void save(T model);
}
