package com.CinemaApp.dto.request;

import com.CinemaApp.dto.SessionDto;
import lombok.*;


import java.util.Set;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HallRequest {
    private String name;
    private Set<SessionDto> sessions;
}
