package com.mehul.basicAuthentication.repository;

import com.mehul.basicAuthentication.entities.Role;
import com.mehul.basicAuthentication.pojo.EnumRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(EnumRole name);
}
