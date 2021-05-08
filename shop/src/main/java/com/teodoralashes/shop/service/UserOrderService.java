package com.teodoralashes.shop.service;

import com.teodoralashes.shop.dto.CreateUserOrderDTO;
import com.teodoralashes.shop.model.User;
import com.teodoralashes.shop.model.UserOrder;
import com.teodoralashes.shop.repository.UserOrderRepository;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserOrderService {

    @Autowired
    UserOrderRepository userOrderRepository;

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    public void create (CreateUserOrderDTO requestDTO) {
        User user = this.userService.getOneById(requestDTO.getUserId());

        UserOrder order = new UserOrder();

        requestDTO.getProductID().forEach(id->{
            order.getProducts().add(this.productService.findOneById(id));
        } );

        order.setUser(user);

        this.userOrderRepository.save(order);
    }
}
