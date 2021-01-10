package org.java.multi.data.source.sakila.repository;

import org.java.multi.data.source.sakila.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
