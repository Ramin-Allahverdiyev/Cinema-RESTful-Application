package com.CinemaApp.mapper;

import com.CinemaApp.dto.request.CategoryRequest;
import com.CinemaApp.dto.response.CategoryResponse;
import com.CinemaApp.entity.Category;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
        ,unmappedTargetPolicy = ReportingPolicy.IGNORE
        ,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class CategoryMapper {
    public static final CategoryMapper INSTANCE= Mappers.getMapper(CategoryMapper.class);

    public abstract Category dtoToEntity(CategoryRequest request);

    public abstract void dtoToEntity(@MappingTarget Category category, CategoryRequest request);
    public abstract CategoryResponse entityToDto(Category category);

    public abstract List<CategoryResponse> entityListToDtoList(List<Category> teachers);

}
