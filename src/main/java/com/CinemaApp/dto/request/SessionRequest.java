package com.CinemaApp.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SessionRequest {
    private int movieId;
    @JsonFormat(pattern = "HH:mm dd.MM.yyyy")
    private Date showTime;
}
