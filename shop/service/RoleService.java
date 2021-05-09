package com.teodoralashes.shop.service;

import com.teodoralashes.shop.model.Role;
import com.teodoralashes.shop.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class RoleService {

     @Autowired
     RoleRepository roleRepository;

     public List<Role> getAll() {
         return roleRepository.findAll();
    }


    public Role getOneById (Long id){
         return roleRepository.findOneById(id).orElseThrow(() -> new EntityNotFoundException("Rola ne postoji!"));
    }
}
