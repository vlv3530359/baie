package com.baie.service;

import com.baie.core.entity.User;
import com.baie.core.module.UserData;
import com.baie.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public boolean saveUser(UserData userData) {
        try {
            User user = userData.buildUser();
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            log.error("UserService.saveUser error: ", e);
            return false;
        }
    }

    public User findUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    public List<User> findAllUser() {
        List<User> users = userRepository.findAll();
        return users;
    }

    public User findByUserName(String userName) {
        User user = userRepository.findByUserName(userName);
        return user;
    }
}
