package com.CinemaApp.controller;

import com.CinemaApp.dto.request.SeatRequest;
import com.CinemaApp.dto.response.SeatResponse;
import com.CinemaApp.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${root.url}/seat")
@RequiredArgsConstructor
public class SeatController{
    private final SeatService seatService;

    @PostMapping
    public SeatResponse saveSeat(@RequestBody SeatRequest request){
        return seatService.saveSeat(request);
    }

    @GetMapping("/{id}")
    public SeatResponse getSeat(@PathVariable int id){
        return seatService.getSeat(id);
    }

    @PutMapping("/{id}")
    public SeatResponse updateSeat(@PathVariable int id,@RequestBody SeatRequest request){
        return seatService.updateSeat(id,request);
    }

    @GetMapping("/all")
    public List<SeatResponse> getAllSeats(){
        return seatService.getAllSeats();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSeat(@PathVariable int id) {
        seatService.deleteSeat(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
