package ru.ivmiit.projectFixCourse.dao;

public interface AbstractDao<T> {
    void save(T model);
}
