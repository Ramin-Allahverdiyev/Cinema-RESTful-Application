package com.CinemaApp.mapper;

import com.CinemaApp.dto.request.MovieRequest;
import com.CinemaApp.dto.response.MovieResponse;
import com.CinemaApp.entity.Movie;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
        ,unmappedTargetPolicy = ReportingPolicy.IGNORE
        ,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class MovieMapper {
    public static final MovieMapper INSTANCE= Mappers.getMapper(MovieMapper.class);

    @Mapping(target = "category.id", source = "categoryId")
    public abstract Movie dtoToEntity(MovieRequest request);

    @Mapping(target = "categoryId", source = "category.id")
    public abstract MovieResponse entityToDto(Movie movie);

    @Mapping(target = "category.id", source = "categoryId")
    public abstract void dtoToEntity(@MappingTarget Movie movie, MovieRequest request);
    @Mapping(target = "categoryId", source = "category.id")
    public abstract List<MovieResponse> entityListToDtoList(List<Movie> lessons);
}
