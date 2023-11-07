package com.CinemaApp.mapper;


import com.CinemaApp.dto.request.SeatTypeRequest;
import com.CinemaApp.dto.response.SeatTypeResponse;
import com.CinemaApp.entity.SeatType;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
        ,unmappedTargetPolicy = ReportingPolicy.IGNORE
        ,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class SeatTypeMapper {
    public static final SeatTypeMapper INSTANCE= Mappers.getMapper(SeatTypeMapper.class);

    public abstract SeatType dtoToEntity(SeatTypeRequest request);

    public abstract SeatTypeResponse entityToDto(SeatType seatType);

    public abstract void dtoToEntity(@MappingTarget SeatType seatType, SeatTypeRequest request);

    public abstract List<SeatTypeResponse> entityListToDtoList(List<SeatType> teachers);
}

