package com.CinemaApp.mapper;


import com.CinemaApp.dto.request.SessionRequest;
import com.CinemaApp.dto.response.SessionResponse;
import com.CinemaApp.entity.Session;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
        ,unmappedTargetPolicy = ReportingPolicy.IGNORE
        ,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class SessionMapper {
    public static final SessionMapper INSTANCE= Mappers.getMapper(SessionMapper.class);

    @Mapping(target = "movie.id", source = "movieId")
    public abstract Session dtoToEntity(SessionRequest request);

    @Mapping(target = "movieId", source = "movie.id")
    public abstract SessionResponse entityToDto(Session session);

    @Mapping(target = "movie.id", source = "movieId")
    public abstract void dtoToEntity(@MappingTarget Session session, SessionRequest request);

    @Mapping(target = "movieId", source = "movie.id")
    public abstract List<SessionResponse> entityListToDtoList(List<Session> teachers);
}
