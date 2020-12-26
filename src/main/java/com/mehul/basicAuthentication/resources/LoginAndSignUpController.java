/**
 * Author : Mehul Gupta
 * Email : mehul10101@gmail.com
 */
package com.mehul.basicAuthentication.resources;

import com.mehul.basicAuthentication.pojo.LoginRequest;
import com.mehul.basicAuthentication.pojo.SignUpRequest;
import com.mehul.basicAuthentication.pojo.SignUpResponse;
import com.mehul.basicAuthentication.services.LoginService;
import com.mehul.basicAuthentication.services.SignUpService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/v1/auth")
public class LoginAndSignUpController {

    private final SignUpService signUpService;
    private final LoginService loginService;

    @PostMapping("/login")
    public void login(@RequestBody LoginRequest loginRequest) throws Exception {
        loginService.signIn(loginRequest);
    }

    @PostMapping("/signUp")
    public SignUpResponse signUp(@RequestBody SignUpRequest signUpRequest) {
        return signUpService.signUp(signUpRequest);
    }

}
