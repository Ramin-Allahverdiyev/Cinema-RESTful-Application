package com.CinemaApp.mapper;

import com.CinemaApp.dto.request.HallRequest;
import com.CinemaApp.dto.response.HallResponse;
import com.CinemaApp.entity.Hall;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
        ,unmappedTargetPolicy = ReportingPolicy.IGNORE
        ,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class HallMapper {
    public static final HallMapper INSTANCE= Mappers.getMapper(HallMapper.class);

    public abstract Hall dtoToEntity(HallRequest request);

    public abstract HallResponse entityToDto(Hall hall);

    public abstract void dtoToEntity(@MappingTarget Hall hall, HallRequest request);

    public abstract List<HallResponse> entityListToDtoList(List<Hall> teachers);
}
