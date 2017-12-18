package com.agen.controller;

import com.agen.myagen.entity.XxOrder;
import com.agen.myagen.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Controller
public class MainController {

    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping("lo")
    public void getOrder(){

    }
}
