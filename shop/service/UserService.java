package com.teodoralashes.shop.service;


import com.sun.deploy.security.BadCertificateDialog;
import com.teodoralashes.shop.dto.SignInDTO;
import com.teodoralashes.shop.dto.SignUpDTO;
import com.teodoralashes.shop.dto.UserResponseDTO;
import com.teodoralashes.shop.model.User;
import com.teodoralashes.shop.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleService roleService;

    @Autowired
    ModelMapper modelMapper;

    public List<UserResponseDTO> getAll() {
        List<User> users = this.userRepository.findAll();
        List<UserResponseDTO> usersDTO = new ArrayList<>();

        for(User user : users) {
            usersDTO.add(this.modelMapper.map(user, UserResponseDTO.class));
        }

        return usersDTO;
    }


    public User getOneById (Long id){
        return userRepository.findOneById(id).orElseThrow(() -> new EntityNotFoundException("User ne postoji!"));
    }

    public UserResponseDTO signUp (SignUpDTO signUpDTO){
        if (this.doesUserWithEmailExist(signUpDTO.getEmail())) {
            throw new EntityExistsException("User with that email already exists");
        }

        User user = new User();
        user.setEmail(signUpDTO.getEmail());
        user.setFirstName(signUpDTO.getFirstName());
        user.setLastName(signUpDTO.getLastName());
        user.setPassword(signUpDTO.getPassword());
        user.setRole(roleService.getOneById(2L));
        user = userRepository.save (user);
        return this.modelMapper.map(user, UserResponseDTO.class);

    }

    public boolean doesUserWithEmailExist(String email) {
        return this.userRepository.findOneByEmail(email).isPresent();
    }

    public UserResponseDTO signIn (SignInDTO signInDTO){
        User user = userRepository.findOneByEmail(signInDTO.getEmail()).orElseThrow(()->new EntityNotFoundException("User sa tim mejlom ne postoji"));
        if (user.getPassword().equals(signInDTO.getPassword())){

            return  this.modelMapper.map(user, UserResponseDTO.class);
        }
        else
        {
            throw new EntityNotFoundException("Password je pogresan");
        }

    }
}

