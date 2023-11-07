package com.CinemaApp.service.impl;

import com.CinemaApp.Model.ExistStatus;
import com.CinemaApp.dto.request.SeatTypeRequest;
import com.CinemaApp.dto.response.SeatTypeResponse;
import com.CinemaApp.exception.NotFoundException;
import com.CinemaApp.mapper.SeatTypeMapper;
import com.CinemaApp.repository.SeatTypeRepository;
import com.CinemaApp.service.SeatTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatTypeServiceImpl implements SeatTypeService {
    private final SeatTypeRepository seatTypeRepository;
    @Override
    public SeatTypeResponse saveSeatType(SeatTypeRequest request) {
        var seatType = SeatTypeMapper.INSTANCE.dtoToEntity(request);
        var savedSeatType = seatTypeRepository.save(seatType);
        return SeatTypeMapper.INSTANCE.entityToDto(savedSeatType);
    }

    @Override
    public SeatTypeResponse getSeatType(int id) {
        var seatType = seatTypeRepository.findByIdAndSeatTypeStatus(id,ExistStatus.ACTIVE.getId())
                .orElseThrow(() -> new NotFoundException("SeatType is not found for this id!"));
        return SeatTypeMapper.INSTANCE.entityToDto(seatType);
    }

    @Override
    public SeatTypeResponse updateSeatType(int id, SeatTypeRequest request) {
        var seatType = seatTypeRepository.findByIdAndSeatTypeStatus(id,ExistStatus.ACTIVE.getId())
                .orElseThrow(() -> new NotFoundException("SeatType is not found for this id!"));
        SeatTypeMapper.INSTANCE.dtoToEntity(seatType,request);
        var updatedSeatType = seatTypeRepository.save(seatType);
        return SeatTypeMapper.INSTANCE.entityToDto(updatedSeatType);
    }

    @Override
    public List<SeatTypeResponse> getAllSeatTypes() {
        var allSeatTypes = seatTypeRepository.findAllBySeatTypeStatus(ExistStatus.ACTIVE.getId());
        return SeatTypeMapper.INSTANCE.entityListToDtoList(allSeatTypes);
    }

    @Override
    public void deleteSeatType(int id) {
        var seatType = seatTypeRepository.findByIdAndSeatTypeStatus(id,ExistStatus.ACTIVE.getId())
                .orElseThrow(() -> new NotFoundException("SeatType is not found for this id!"));
        seatType.setSeatTypeStatus(ExistStatus.DEACTIVE.getId());
        seatTypeRepository.save(seatType);
    }
}
