package com.example.test2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;

@Controller
public class TestController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("error", "");
        return "home";
    }

    @GetMapping("/search")
    public String search() {
        return "search";
    }

    @GetMapping("/result")
    public String result() {
        return "result";
    }

    @GetMapping("/join")
    public String join(Model model) {
        model.addAttribute("error", "");
        return "join";
    }
}
