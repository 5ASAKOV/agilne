package com.teodoralashes.shop.repository;

import com.teodoralashes.shop.model.Role;
import com.teodoralashes.shop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findOneById (Long id);
    Optional <User> findOneByEmail (String email);

}
