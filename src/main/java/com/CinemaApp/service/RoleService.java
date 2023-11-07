package com.CinemaApp.service;

import com.CinemaApp.dto.request.RoleRequest;
import com.CinemaApp.dto.response.RoleResponse;

import java.util.List;

public interface RoleService {
    RoleResponse saveRole(RoleRequest request);
    RoleResponse updateRole(int id,RoleRequest request);

    void deleteRole(int id);
    List<RoleResponse> getAllRoles();
}
