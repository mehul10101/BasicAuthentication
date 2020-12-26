package com.mehul.basicAuthentication.repository;

import com.mehul.basicAuthentication.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, String> {

    Optional<UserEntity> findFirstByEmail(String email);

    Optional<UserEntity> findFirstByUserName(String userName);
}
