package com.CinemaApp.mapper;

import com.CinemaApp.dto.request.UserRequest;
import com.CinemaApp.dto.response.UserResponse;
import com.CinemaApp.entity.User;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
        ,unmappedTargetPolicy = ReportingPolicy.IGNORE
        ,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class UserMapper {
    public static final UserMapper INSTANCE= Mappers.getMapper(UserMapper.class);

    @Mapping(target = "status",expression = "java(getStatus())")
    public abstract User dtoToEntity(UserRequest request);


    public abstract List<UserResponse> entityListToDtoList(List<User> lessons);
    public abstract UserResponse entityToDto(User User);

    @Named("getStatus")
    protected boolean getStatus(){
        return true;
    }
}
