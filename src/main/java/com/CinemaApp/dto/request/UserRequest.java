package com.CinemaApp.dto.request;

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
public class UserRequest {
    private String name;
    private String username;
    private String surname;
    private String fatherName;
    private String password;
    private Set<RoleDto> roles;
}
