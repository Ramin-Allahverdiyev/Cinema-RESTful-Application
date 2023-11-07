package com.CinemaApp.dto.response;

import com.CinemaApp.dto.SessionDto;
import lombok.*;


import java.util.Set;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HallResponse {
    private int id;
    private String name;
    private Set<SessionDto> sessions;
}
