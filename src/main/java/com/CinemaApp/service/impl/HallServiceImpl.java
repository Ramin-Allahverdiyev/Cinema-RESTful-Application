package com.CinemaApp.service.impl;

import com.CinemaApp.Model.ExistStatus;
import com.CinemaApp.dto.request.HallRequest;
import com.CinemaApp.dto.response.HallResponse;
import com.CinemaApp.exception.NotFoundException;
import com.CinemaApp.mapper.HallMapper;
import com.CinemaApp.repository.HallRepository;
import com.CinemaApp.service.HallService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HallServiceImpl implements HallService {
    private final HallRepository hallRepository;
    @Override
    public HallResponse saveHall(HallRequest request) {
        var hall = HallMapper.INSTANCE.dtoToEntity(request);
        var savedHall = hallRepository.save(hall);
        return HallMapper.INSTANCE.entityToDto(savedHall);
    }

    @Override
    public HallResponse getHall(int id) {
        var hall = hallRepository.findByIdAndHallStatus(id,ExistStatus.ACTIVE.getId())
                .orElseThrow(() -> new NotFoundException("Hall is not found for this id!"));
        return HallMapper.INSTANCE.entityToDto(hall);
    }

    @Override
    public HallResponse updateHall(int id, HallRequest request) {
        var hall = hallRepository.findByIdAndHallStatus(id,ExistStatus.ACTIVE.getId())
                .orElseThrow(() -> new NotFoundException("Hall is not found for this id!"));
        HallMapper.INSTANCE.dtoToEntity(hall,request);
        var updatedHall = hallRepository.save(hall);
        return HallMapper.INSTANCE.entityToDto(updatedHall);
    }

    @Override
    public List<HallResponse> getAllHalls() {
        var allHalls = hallRepository.findAllByHallStatus(ExistStatus.ACTIVE.getId());
        return HallMapper.INSTANCE.entityListToDtoList(allHalls);
    }

    @Override
    public void deleteHall(int id) {
        var category = hallRepository.findByIdAndHallStatus(id,ExistStatus.ACTIVE.getId())
                .orElseThrow(() -> new NotFoundException("Hall is not found for this id!"));
        category.setHallStatus(ExistStatus.DEACTIVE.getId());
        hallRepository.save(category);
    }
}
