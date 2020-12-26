package com.mehul.basicAuthentication.pojo;

import lombok.Data;

@Data
public class SignUpRequest {
    private String email;
    private String password;
    private String userName;
    private String name;

}
