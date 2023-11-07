package com.CinemaApp.dto.response;

import com.CinemaApp.dto.RoleDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private int id;
    private String name;
    private String username;
    private String surname;
    private String fatherName;
    private Set<RoleDto> roles;
}
