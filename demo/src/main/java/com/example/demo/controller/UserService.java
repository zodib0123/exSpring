package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void joinUser(UserVO vo) {
        vo.setRole("USER");
        userRepository.save(vo);
    }

    public UserVO loginUser(String Id, String pw) {
        UserVO userVO = userRepository.selectUserInfo(Id, pw);
        return userVO;
    }
}
