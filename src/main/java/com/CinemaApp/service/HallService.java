package com.CinemaApp.service;

import com.CinemaApp.dto.request.HallRequest;
import com.CinemaApp.dto.response.HallResponse;

import java.util.List;

public interface HallService {
    HallResponse saveHall(HallRequest request);
    HallResponse getHall(int id);
    HallResponse updateHall(int id, HallRequest request);
    List<HallResponse> getAllHalls();
    void deleteHall(int id);
}
