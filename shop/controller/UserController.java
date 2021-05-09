package com.teodoralashes.shop.controller;


import com.teodoralashes.shop.dto.SignInDTO;
import com.teodoralashes.shop.dto.SignUpDTO;
import com.teodoralashes.shop.dto.UserResponseDTO;
import com.teodoralashes.shop.model.User;

import com.teodoralashes.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<UserResponseDTO> handleGetAll () {

        return userService.getAll();
    }
    @GetMapping ("/{id}")
    public User handleGetOneById (@PathVariable("id") Long id){
        return userService.getOneById(id);
    }

    @PostMapping ("/sign-up")
    public ResponseEntity<UserResponseDTO> handleSignUp (@RequestBody SignUpDTO signUpDTO){
        return new ResponseEntity<UserResponseDTO> ( userService.signUp (signUpDTO), HttpStatus.CREATED);
    }

    @PostMapping ("/sign-in")
    public UserResponseDTO handleSignIn (@RequestBody SignInDTO signInDTO){
        return userService.signIn (signInDTO);
    }

}
