package com.example.backend.security.ws.facad.admin;

import com.example.backend.security.bean.Role;
import com.example.backend.security.services.facad.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("api_backend/api/admin/role")
public class RoleControllerAdmin {

    private RoleService roleService;
    public RoleControllerAdmin( RoleService roleService){
        this.roleService=roleService;
    }

    @GetMapping("/authority/{authority}")
    public Role findRoleByAuthority(@PathVariable String authority) {
        return roleService.findRoleByAuthority(authority);
    }
    @DeleteMapping("/authority/{authority}")
    public int deleteByAuthority(@PathVariable String authority) {
        return roleService.deleteByAuthority(authority);
    }
    @PostMapping("/")
    public Role save(@RequestBody Role role) {
        return roleService.save(role);
    }
    @PostMapping("/all")
    public void save(@RequestBody Collection<Role> role) {
        roleService.save(role);
    }
    @GetMapping("/")
    public List<Role> findAll() {
        return roleService.findAll();
    }
}
