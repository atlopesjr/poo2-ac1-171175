package com.example.poo2aula09032020.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * IndexController
 */
@Controller
public class IndexController {
    @GetMapping
    public String Index(){
        return "index";
    }
    
}