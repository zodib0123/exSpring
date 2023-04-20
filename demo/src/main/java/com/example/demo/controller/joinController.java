package com.example.demo.controller;

import org.apache.coyote.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class joinController {
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginMessage", "");
        return "join";
    }

    @GetMapping("/join")
    public String join() {
        return "joinUs";
    }

}
