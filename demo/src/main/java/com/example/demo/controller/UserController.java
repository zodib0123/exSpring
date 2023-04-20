package com.example.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/joinUs.do", method = RequestMethod.POST)
    public String joinUs(UserVO vo) {

        userService.joinUser(vo);
        return "index";
    }

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public String login(UserVO vo, Model model) {
        System.out.println("vo = " + vo);
        UserVO userVO = userService.loginUser(vo.getUserId(), vo.getPassword());
        if(userVO==null){
            model.addAttribute("loginMessage", "아이디 혹은 비밀번호가 일치하지 않습니다.");
            return "join";
        }
        model.addAttribute("data", vo.getUserName());
        return "index";
     }

//
//    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
//    public String Login(HttpServletRequest request, Model model) {
//        String id=request.getParameter("userId");
//        String pwd=request.getParameter("password");
//        System.out.println("id = " + id);
//        System.out.println("pwd = " + pwd);
//        UserVO userVO = userService.loginUser(id, pwd);
//        model.addAttribute("userName", userVO.getUserName());
//        model.addAttribute("data", id);
//        return "index";
//    }

}
