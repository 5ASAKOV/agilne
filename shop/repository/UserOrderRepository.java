package com.teodoralashes.shop.repository;

import com.teodoralashes.shop.model.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserOrderRepository extends JpaRepository <UserOrder, Long>{


}
