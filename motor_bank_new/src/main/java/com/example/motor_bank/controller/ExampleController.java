package com.example.motor_bank.controller;

import com.example.motor_bank.BalanceController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/example")
public class ExampleController {
    @Autowired // позволяет использовать объект example, вызывать бины из класса BalanceController
    BalanceController example;

    @GetMapping("/example") //запрос будет выполнять метод
    public BalanceController getExample() {
        return example;
    }

    @Value("Motor Bank name in value")
    private String name;
    @GetMapping("/name")
    public String getName() {
        return name;
    }


}
