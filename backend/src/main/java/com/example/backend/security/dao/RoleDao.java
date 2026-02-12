package com.example.backend.security.dao;

import com.example.backend.security.bean.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role,Long> {
    public Role findRoleByAuthority(String authority);
    int deleteByAuthority(String authority);
}
