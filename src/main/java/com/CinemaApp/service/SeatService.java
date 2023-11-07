package com.CinemaApp.service;

import com.CinemaApp.dto.request.SeatRequest;
import com.CinemaApp.dto.response.SeatResponse;

import java.util.List;

public interface SeatService {
    SeatResponse saveSeat(SeatRequest request);
    SeatResponse getSeat(int id);
    SeatResponse updateSeat(int id, SeatRequest request);
    List<SeatResponse> getAllSeats();
    void deleteSeat(int id);
}
