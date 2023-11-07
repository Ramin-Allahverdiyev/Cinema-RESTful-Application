package com.CinemaApp.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SessionResponse {
    private int id;
    private int movieId;
    @JsonFormat(pattern = "HH:mm dd.MM.yyyy")
    private Date showTime;
}
