package com.mehul.basicAuthentication.services;

import com.mehul.basicAuthentication.entities.UserEntity;
import com.mehul.basicAuthentication.pojo.LoginRequest;
import com.mehul.basicAuthentication.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Component
public class LoginService {

    private final UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void signIn(LoginRequest loginRequest) throws Exception {
        Optional<UserEntity> userOptional = userRepository.findFirstByEmail(loginRequest.getEmail());
        if(!userOptional.isPresent()){
            throw new Exception("email not registered");
        }
        UserEntity userEntity = userOptional.get();
        if(!BCrypt.checkpw(loginRequest.getPassword(), userEntity.getPassword())){
            throw new Exception("password doesn't match");
        }
        System.out.println("login successful");

    }

}
