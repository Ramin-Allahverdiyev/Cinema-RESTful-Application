package com.CinemaApp.controller;

import com.CinemaApp.dto.request.RoleRequest;
import com.CinemaApp.dto.response.RoleResponse;
import com.CinemaApp.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${root.url}/role")
public class RoleController {

    private final RoleService roleService;
    @PostMapping("/save")
    public RoleResponse saveRole(@RequestBody RoleRequest request){
        return roleService.saveRole(request);
    }

    @GetMapping("/roles")
    public List<RoleResponse> getAllRoles(){
        return roleService.getAllRoles();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRole(@PathVariable int id) {
        roleService.deleteRole(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public RoleResponse updateRole(@PathVariable int id, @RequestBody RoleRequest request){
        return roleService.updateRole(id,request);
    }
}
