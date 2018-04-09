package ru.ivmiit.alfia.dao;

public interface AbstractDao<T> {
    void save(T model);
}
