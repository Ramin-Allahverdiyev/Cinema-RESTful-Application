package com.CinemaApp.mapper;


import com.CinemaApp.dto.request.SeatRequest;
import com.CinemaApp.dto.response.SeatResponse;
import com.CinemaApp.entity.Seat;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
        ,unmappedTargetPolicy = ReportingPolicy.IGNORE
        ,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class SeatMapper {
    public static final SeatMapper INSTANCE= Mappers.getMapper(SeatMapper.class);

    @Mapping(target = "seatType.id", source = "seatTypeId")
    @Mapping(target = "hall.id", source = "hallId")
    public abstract Seat dtoToEntity(SeatRequest request);

    @Mapping(target = "seatTypeId", source = "seatType.id")
    @Mapping(target = "hallId", source = "hall.id")
    public abstract SeatResponse entityToDto(Seat seat);

    @Mapping(target = "seatType.id", source = "seatTypeId")
    @Mapping(target = "hall.id", source = "hallId")
    public abstract void dtoToEntity(@MappingTarget Seat seat, SeatRequest request);

    @Mapping(target = "seatTypeId", source = "seatType.id")
    @Mapping(target = "hallId", source = "hall.id")
    public abstract List<SeatResponse> entityListToDtoList(List<Seat> teachers);

}
