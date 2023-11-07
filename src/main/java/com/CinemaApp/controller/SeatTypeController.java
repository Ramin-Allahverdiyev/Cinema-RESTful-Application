package com.CinemaApp.controller;

import com.CinemaApp.dto.request.SeatTypeRequest;
import com.CinemaApp.dto.response.SeatTypeResponse;
import com.CinemaApp.service.SeatTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${root.url}/stype")
public class SeatTypeController {
    private final SeatTypeService seatTypeService;

    @PostMapping("/save")
    public SeatTypeResponse saveSeatType(@RequestBody SeatTypeRequest request){
        return seatTypeService.saveSeatType(request);
    }
    @GetMapping("/{id}")
    public SeatTypeResponse getSeatType(@PathVariable int id){
        return seatTypeService.getSeatType(id);
    }

    @PutMapping("/{id}")
    public SeatTypeResponse updateSeatType(@PathVariable int id,@RequestBody SeatTypeRequest request){
        return seatTypeService.updateSeatType(id,request);
    }

    @GetMapping("/all")
    public List<SeatTypeResponse> getAllSeatTypes(){
        return seatTypeService.getAllSeatTypes();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSeatType(@PathVariable int id) {
        seatTypeService.deleteSeatType(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
