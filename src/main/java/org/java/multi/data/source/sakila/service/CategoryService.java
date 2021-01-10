package org.java.multi.data.source.sakila.service;

import org.java.multi.data.source.sakila.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    Category findById(Long id);

    Category save(Category object);

    void delete(Category object);

    void deleteById(Long id);

}
