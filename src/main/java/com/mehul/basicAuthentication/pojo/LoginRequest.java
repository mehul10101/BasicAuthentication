package com.mehul.basicAuthentication.pojo;

import lombok.Data;
import lombok.NonNull;

@Data
public class LoginRequest {
    @NonNull
    private String userName;
    @NonNull
    private String password;

}
