package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class testController {

    @GetMapping("/home")
    public String hello(Model model) {
        model.addAttribute("data", "유저");
        return "index";
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
