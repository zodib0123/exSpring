package com.example.test2.Controller;

import com.example.test2.Entity.User;
import com.example.test2.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    UserService userService;



//    @PostMapping("/search")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(User vo, Model model) {
        User user = userService.selectUser(vo.getUserId());
        System.out.println("vo = " + user);
        if(user==null) {
            model.addAttribute("result", "실패");
            return "search";
        }
        model.addAttribute("result", "성공");
        model.addAttribute("list", user);
        return "search";
    }

    @PostMapping("/result")
    public String join(User vo, Model model) {
        User user = userService.selectUser(vo.getUserId());
        System.out.println("vo = " + user);
        if(user!=null) {
            model.addAttribute("error", "중복된 ID가 존재합니다.");
            return "home";
        }
        userService.joinUser(vo);
        model.addAttribute("data", vo.getUserName() + "님 가입 성공하였습니다.");
        return "result";
    }

    @GetMapping("/update")
    public String check(User vo, Model model) {
        User user = userService.selectUser(vo.getUserId());
        System.out.println("vo = " + user);
        if(user==null) {
            model.addAttribute("error", "아이디가 존재하지 않습니다.");
            return "join";
        }
        model.addAttribute("list", user);
        return "update";
    }

    @PutMapping("/result/{id}")
    public String update(@PathVariable("id")String Id, User vo, Model model) {
        userService.updateUser(Id, vo);
        model.addAttribute("data", vo.getUserName() + "님 계정정보를 수정하였습니다.");
        return "result";
    }
}
