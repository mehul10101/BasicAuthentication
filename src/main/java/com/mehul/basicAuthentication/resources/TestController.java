package com.mehul.basicAuthentication.resources;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * This controller is used to verify the jwt token and role based authorization
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/api/test/")
public class TestController {

    @GetMapping("admin")
    @PreAuthorize("hasRole('ADMIN')")
    public void admin(){
        System.out.println("I am only accessible to admins");
    }

    @GetMapping("user")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public void users(){
        System.out.println("I am only accessible to both users and admins");
    }

    @GetMapping("mod")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public String moderatorAccess() {
        return "Moderator Board.";
    }

    @GetMapping("all")
    public void all(){
        System.out.println("I am accessible to all");
    }

}
