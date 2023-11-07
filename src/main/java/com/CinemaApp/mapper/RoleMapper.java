package com.CinemaApp.mapper;

import com.CinemaApp.dto.request.RoleRequest;
import com.CinemaApp.dto.request.SeatTypeRequest;
import com.CinemaApp.dto.response.MovieResponse;
import com.CinemaApp.dto.response.RoleResponse;
import com.CinemaApp.entity.Movie;
import com.CinemaApp.entity.Role;
import com.CinemaApp.entity.SeatType;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
        ,unmappedTargetPolicy = ReportingPolicy.IGNORE
        ,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class RoleMapper {
    public static final RoleMapper INSTANCE= Mappers.getMapper(RoleMapper.class);

    public abstract Role dtoToEntity(RoleRequest request);

    public abstract RoleResponse entityToDto(Role role);

    public abstract void dtoToEntity(@MappingTarget Role role, RoleRequest request);

    public abstract List<RoleResponse> entityListToDtoList(List<Role> lessons);

}
