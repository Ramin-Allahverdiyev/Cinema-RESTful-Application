package com.CinemaApp.mapper;


import com.CinemaApp.dto.request.TicketRequest;
import com.CinemaApp.dto.response.TicketResponse;
import com.CinemaApp.entity.Ticket;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
        ,unmappedTargetPolicy = ReportingPolicy.IGNORE
        ,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class TicketMapper {

    public static final TicketMapper INSTANCE= Mappers.getMapper(TicketMapper.class);

    @Mapping(target = "seat.id", source = "seatId")
    @Mapping(target = "session.id", source = "sessionId")
    @Mapping(target = "hall.id", source = "hallId")
    @Mapping(target = "user.id", source = "userId")
    public abstract Ticket dtoToEntity(TicketRequest request);

    @Mapping(target = "seatId", source = "seat.id")
    @Mapping(target = "sessionId", source = "session.id")
    @Mapping(target = "hallId", source = "hall.id")
    @Mapping(target = "userId", source = "user.id")
    public abstract TicketResponse entityToDto(Ticket ticket);

    @Mapping(target = "seat.id", source = "seatId")
    @Mapping(target = "session.id", source = "sessionId")
    @Mapping(target = "hall.id", source = "hallId")
    @Mapping(target = "user.id", source = "userId")
    public abstract void dtoToEntity(@MappingTarget Ticket ticket, TicketRequest request);
    @Mapping(target = "seatId", source = "seat.id")
    @Mapping(target = "sessionId", source = "session.id")
    @Mapping(target = "hallId", source = "hall.id")
    @Mapping(target = "userId", source = "user.id")
    public abstract List<TicketResponse> entityListToDtoList(List<Ticket> teachers);
}
