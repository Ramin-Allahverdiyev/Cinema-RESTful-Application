package com.CinemaApp.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SeatResponse {
    private int id;
    private int hallId;
    private int seatTypeId;
    private double price;
}
