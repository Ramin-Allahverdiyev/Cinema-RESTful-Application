package com.CinemaApp.service.impl;

import com.CinemaApp.Model.ExistStatus;
import com.CinemaApp.dto.request.RoleRequest;
import com.CinemaApp.dto.response.RoleResponse;
import com.CinemaApp.exception.NotFoundException;
import com.CinemaApp.mapper.RoleMapper;
import com.CinemaApp.repository.RoleRepository;
import com.CinemaApp.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    @Override
    public RoleResponse saveRole(RoleRequest request) {
        var role = RoleMapper.INSTANCE.dtoToEntity(request);
        var savedRole = roleRepository.save(role);
        return RoleMapper.INSTANCE.entityToDto(savedRole);
    }

    @Override
    public RoleResponse updateRole(int id, RoleRequest request) {
        var role = roleRepository.findByIdAndRoleStatus(id, ExistStatus.ACTIVE.getId())
                .orElseThrow(() -> new NotFoundException("Role is not found"));
        RoleMapper.INSTANCE.dtoToEntity(role,request);
        var updatedRole = roleRepository.save(role);
        return RoleMapper.INSTANCE.entityToDto(updatedRole);
    }

    @Override
    public void deleteRole(int id) {
        var role = roleRepository.findByIdAndRoleStatus(id, ExistStatus.ACTIVE.getId())
                .orElseThrow(() -> new NotFoundException("Role is not found"));
        role.setRoleStatus(ExistStatus.DEACTIVE.getId());
        roleRepository.save(role);
    }

    @Override
    public List<RoleResponse> getAllRoles() {
        var allRoles = roleRepository.findAllByRoleStatus(ExistStatus.ACTIVE.getId());
        return RoleMapper.INSTANCE.entityListToDtoList(allRoles);
    }
}
