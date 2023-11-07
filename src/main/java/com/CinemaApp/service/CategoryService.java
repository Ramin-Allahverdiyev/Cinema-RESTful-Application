package com.CinemaApp.service;

import com.CinemaApp.dto.request.CategoryRequest;
import com.CinemaApp.dto.response.CategoryResponse;

import java.util.List;

public interface CategoryService {
    CategoryResponse saveCategory(CategoryRequest request);
    CategoryResponse getCategory(int id);
    CategoryResponse updateCategory(int id,CategoryRequest request);
    void deleteCategory(int id);
    List<CategoryResponse> getAllCategories();
}
