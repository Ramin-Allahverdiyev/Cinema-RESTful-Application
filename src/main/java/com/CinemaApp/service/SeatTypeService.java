package com.CinemaApp.service;

import com.CinemaApp.dto.request.SeatTypeRequest;
import com.CinemaApp.dto.response.SeatTypeResponse;

import java.util.List;

public interface SeatTypeService {
    SeatTypeResponse saveSeatType(SeatTypeRequest request);
    SeatTypeResponse getSeatType(int id);
    SeatTypeResponse updateSeatType(int id, SeatTypeRequest request);
    List<SeatTypeResponse> getAllSeatTypes();
    void deleteSeatType(int id);
}
