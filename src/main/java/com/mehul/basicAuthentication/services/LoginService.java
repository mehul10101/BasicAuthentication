package com.mehul.basicAuthentication.services;

import com.mehul.basicAuthentication.entities.UserEntity;
import com.mehul.basicAuthentication.pojo.LoginRequest;
import com.mehul.basicAuthentication.pojo.LoginResponse;
import com.mehul.basicAuthentication.repository.UserRepository;
import com.mehul.basicAuthentication.security.jwt.JwtUtils;
import com.mehul.basicAuthentication.utils.ApiError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

// The service class will contain the business logic and will talk directly to the rest end point
@Service
@Component
@Slf4j
public class LoginService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MyUserDetailService userDetailService;
    @Autowired
    private JwtUtils jwtUtil;
    @Autowired
    AuthenticationManager authenticationManager;

    public LoginResponse signIn(LoginRequest loginRequest) throws ApiError {
        Optional<UserEntity> userOptional = userRepository.findFirstByUserName(loginRequest.getUserName());
        UserEntity userEntity = getUserEntityAndValidateUserNameAndPassword(loginRequest, userOptional);
        log.info("login successful");

        return getLoginResponse(loginRequest, userEntity);

    }

    private LoginResponse getLoginResponse(LoginRequest loginRequest, UserEntity userEntity) {
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setId(userEntity.getId());
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtUtil.generateJwtToken(authentication);
        loginResponse.setToken(token);
        return loginResponse;
    }

    //to validate userName and password using BCrypt
    private UserEntity getUserEntityAndValidateUserNameAndPassword(LoginRequest loginRequest, Optional<UserEntity> userOptional) throws ApiError {
        if(!userOptional.isPresent()){
            throw new ApiError(HttpStatus.UNPROCESSABLE_ENTITY, "email not registered", "email not registered");
        }
        UserEntity userEntity = userOptional.get();
        if(!BCrypt.checkpw(loginRequest.getPassword(), userEntity.getPassword())){
            throw new ApiError(HttpStatus.UNPROCESSABLE_ENTITY, "password doesn't match", "password doesn't match");
        }
        return userEntity;
    }

}
