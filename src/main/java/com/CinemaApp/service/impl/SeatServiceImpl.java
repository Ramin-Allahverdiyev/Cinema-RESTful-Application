package com.CinemaApp.service.impl;

import com.CinemaApp.Model.ExistStatus;
import com.CinemaApp.dto.request.SeatRequest;
import com.CinemaApp.dto.response.SeatResponse;
import com.CinemaApp.exception.ExceedLimitException;
import com.CinemaApp.exception.NotFoundException;
import com.CinemaApp.mapper.SeatMapper;
import com.CinemaApp.repository.SeatRepository;
import com.CinemaApp.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatServiceImpl implements SeatService {
    private final SeatRepository seatRepository;
    @Override
    public SeatResponse saveSeat(SeatRequest request) {
        var countSeats = seatRepository.countSeatsByHallId(request.getHallId());
        if(countSeats>29){
            throw new ExceedLimitException("Number of seats for this hall exceed limit!");
        }
        var seat = SeatMapper.INSTANCE.dtoToEntity(request);
        var savedSeat = seatRepository.save(seat);
        return SeatMapper.INSTANCE.entityToDto(savedSeat);
    }

    @Override
    public SeatResponse getSeat(int id) {
        var seat = seatRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Seat is not found for this id!"));
        return SeatMapper.INSTANCE.entityToDto(seat);
    }

    @Override
    public SeatResponse updateSeat(int id, SeatRequest request) {
        var seat = seatRepository.findByIdAndSeatStatus(id,ExistStatus.ACTIVE.getId())
                .orElseThrow(() -> new NotFoundException("Seat is not found for this id!"));
        SeatMapper.INSTANCE.dtoToEntity(seat,request);
        var updatedSeat = seatRepository.save(seat);
        return SeatMapper.INSTANCE.entityToDto(updatedSeat);
    }

    @Override
    public List<SeatResponse> getAllSeats() {
        var allSeats = seatRepository.findAllBySeatStatus(ExistStatus.ACTIVE.getId());
        return SeatMapper.INSTANCE.entityListToDtoList(allSeats);
    }

    @Override
    public void deleteSeat(int id) {
        var seat = seatRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Seat is not found for this id!"));
        seat.setSeatStatus(ExistStatus.DEACTIVE.getId());
        seatRepository.save(seat);
    }
}
