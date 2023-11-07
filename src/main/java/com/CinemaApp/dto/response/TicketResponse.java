package com.CinemaApp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketResponse {
    private int id;
    private int sessionId;
    private int seatId;
    private int hallId;
    private int userId;
}
