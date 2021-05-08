package com.teodoralashes.shop.controller;

import com.teodoralashes.shop.model.Role;
import com.teodoralashes.shop.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/api/roles")
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping
    public List<Role> handleGetAll () {

        return roleService.getAll();
    }
    @GetMapping ("/{id}")
    public Role handleGetOneById (@PathVariable("id") Long id){
        return roleService.getOneById(id);
    }
}

