package com.mehul.basicAuthentication.pojo;

import lombok.Data;

@Data
public class LoginResponse {
    private Long id;
    private String token;
    private String role;

}
