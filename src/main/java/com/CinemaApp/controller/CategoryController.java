package com.CinemaApp.controller;

import com.CinemaApp.dto.request.CategoryRequest;
import com.CinemaApp.dto.response.CategoryResponse;
import com.CinemaApp.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${root.url}/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/save")
    public CategoryResponse saveCategory(@RequestBody CategoryRequest request){
        return categoryService.saveCategory(request);
    }

    @GetMapping("/{id}")
    public CategoryResponse getCategory(@PathVariable int id){
        return categoryService.getCategory(id);
    }

    @PutMapping("/{id}")
    public CategoryResponse updateCategory(@PathVariable int id, @RequestBody CategoryRequest request){
        return categoryService.updateCategory(id,request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable int id){
        categoryService.deleteCategory(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @GetMapping("/all")
    public List<CategoryResponse> getAllCategories(){
        return categoryService.getAllCategories();
    }

}
