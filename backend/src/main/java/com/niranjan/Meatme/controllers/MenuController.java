package com.niranjan.Meatme.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {

    @RequestMapping("/")
    public String test() {
        return "Welcome to M-eat me !!!";
    }

}
