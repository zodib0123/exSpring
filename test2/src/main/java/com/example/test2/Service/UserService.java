package com.example.test2.Service;


import com.example.test2.Entity.User;
import com.example.test2.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User selectUser(String Id) {
        User user = userRepository.selectUserInfo(Id);
        return user;
    }

    public void joinUser(User vo) {
        vo.setPoint(0);
        vo.setCoin(0);
        userRepository.save(vo);
    }

    public void updateUser(String Id, User vo) {
        User user = userRepository.selectUserInfo(Id);

    }
}
