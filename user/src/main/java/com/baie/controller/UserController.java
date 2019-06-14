package com.baie.controller;


import com.baie.core.entity.User;
import com.baie.core.module.UserData;
import com.baie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
//@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600, allowCredentials = "true") you can comment it if you use gateway to access this service, else you need to consider the cors.
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/save")
    public String saveUser(@RequestBody UserData userData) {
        if (userService.saveUser(userData)) {
            return "Save User successfully.";
        } else {
            return "Save User failed.";
        }
    }

    @PostMapping("/delete")
    public String deleteUser() {
        return "Save user failed.";
    }

    @PostMapping("/update")
    public String updateUser() {
        return "Save user failed.";
    }

    @GetMapping("/find/{id}")
    public User findUserById(@PathVariable Long id) throws InterruptedException {

        //Thread.sleep(6000);
        User user = userService.findUserById(id);

        return user;
    }

    @GetMapping("/find/all")
    public List<User> findAllUser() throws InterruptedException {

        //Thread.sleep(6000);
        List<User> users = userService.findAllUser();

        return users;
    }

    @GetMapping("/query")
    public List<User> queryUses() {
        return new ArrayList<>();
    }

    @GetMapping("/checkLogin")
    public User checkLogin(HttpSession session, HttpServletRequest request) {
        String sessionId = request.getSession().getId();
        Object obj = session.getAttribute("user");
        return (User) obj;
    }

    @PostMapping("/login")
    public boolean login(HttpSession session, @RequestBody UserData userData) {
        User user = userService.findByUserName(userData.getUserName());
        session.setAttribute("user", user);
        return user == null ? false : true;
    }

    @PostMapping("/logout")
    public boolean logout(HttpSession session, HttpServletRequest request) {
        String sessionId = request.getSession().getId();
        session.setAttribute("user", null);
        return true;
    }
}
