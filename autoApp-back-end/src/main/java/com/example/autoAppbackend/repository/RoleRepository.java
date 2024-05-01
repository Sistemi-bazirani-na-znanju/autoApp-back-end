package com.example.autoAppbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.autoAppbackend.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
    Role getRoleById(long id);
}
