package com.CinemaApp.controller;

import com.CinemaApp.dto.request.HallRequest;
import com.CinemaApp.dto.response.HallResponse;
import com.CinemaApp.service.HallService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${root.url}/hall")
@RequiredArgsConstructor
public class HallController {
    private final HallService hallService;

    @PostMapping("/save")
    public HallResponse saveHall(@RequestBody HallRequest request){
        return hallService.saveHall(request);
    }

    @GetMapping("/{id}")
    public HallResponse getHall(@PathVariable int id){
        return hallService.getHall(id);
    }

    @PutMapping("/{id}")
    public HallResponse updateHall(@PathVariable int id,@RequestBody HallRequest request){
        return hallService.updateHall(id,request);
    }

    @GetMapping("/all")
    public List<HallResponse> getAllHalls(){
        return hallService.getAllHalls();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHall(@PathVariable int id) {
        hallService.deleteHall(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
