package com.CinemaApp.repository;

import com.CinemaApp.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    List<Category> findAllByCategoryStatus(int categoryStatus);

    Optional<Category> findByIdAndCategoryStatus(int id,int status);
}
