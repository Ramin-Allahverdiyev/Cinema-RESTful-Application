package com.CinemaApp.service.impl;

import com.CinemaApp.Model.ExistStatus;
import com.CinemaApp.dto.request.CategoryRequest;
import com.CinemaApp.dto.response.CategoryResponse;
import com.CinemaApp.exception.NotFoundException;
import com.CinemaApp.mapper.CategoryMapper;
import com.CinemaApp.repository.CategoryRepository;
import com.CinemaApp.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    @Override
    public CategoryResponse saveCategory(CategoryRequest request) {
        var category = CategoryMapper.INSTANCE.dtoToEntity(request);
        var savedCategory = categoryRepository.save(category);
        return  CategoryMapper.INSTANCE.entityToDto(savedCategory);
    }

    @Override
    public CategoryResponse getCategory(int id) {
        var category = categoryRepository.findByIdAndCategoryStatus(id,ExistStatus.ACTIVE.getId())
                .orElseThrow(() -> new NotFoundException("Category is not found for this ID !"));
        return CategoryMapper.INSTANCE.entityToDto(category);
    }

    @Override
    public CategoryResponse updateCategory(int id, CategoryRequest request) {
        var category = categoryRepository.findByIdAndCategoryStatus(id,ExistStatus.ACTIVE.getId())
                .orElseThrow(() -> new NotFoundException("Category is not found for this id!"));
        CategoryMapper.INSTANCE.dtoToEntity(category,request);
        var updatedCategory = categoryRepository.save(category);
        return CategoryMapper.INSTANCE.entityToDto(updatedCategory);
    }

    @Override
    public void deleteCategory(int id) {
        var category = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Category is not found for this id!"));
        category.setCategoryStatus(ExistStatus.DEACTIVE.getId());
        categoryRepository.save(category);
    }

    @Override
    public List<CategoryResponse> getAllCategories() {

        var allByCategoryStatus = categoryRepository.findAllByCategoryStatus(ExistStatus.ACTIVE.getId());
        return CategoryMapper.INSTANCE.entityListToDtoList(allByCategoryStatus);

    }
}
