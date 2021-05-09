package com.teodoralashes.shop.controller;

import com.teodoralashes.shop.dto.CreateUserOrderDTO;
import com.teodoralashes.shop.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/api/orders")
@CrossOrigin("http://localhost:3000")
public class UserOrderController {

    @Autowired
    UserOrderService userOrderService;

    @PostMapping
    public void handleOrder(@RequestBody CreateUserOrderDTO requestDTO) {
        this.userOrderService.create(requestDTO);
    }
}
