package com.mehul.basicAuthentication.repository;

import com.mehul.basicAuthentication.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, String> {

    Optional<UserEntity> findFirstByEmail(String email);

    Optional<UserEntity> findFirstByUserName(String userName);
}
