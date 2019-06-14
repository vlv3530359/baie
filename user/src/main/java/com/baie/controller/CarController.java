package com.baie.controller;


import com.baie.core.entity.Car;
import com.baie.core.entity.User;
import com.baie.core.module.CarData;
import com.baie.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/car")
@Slf4j
//@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600, allowCredentials = "true") you can comment it if you use gateway to access this service, else you need to consider the cors.
public class CarController {

    @Autowired
    CarService carService;

    @PostMapping("/addCar")
    public boolean addCar(HttpSession session, @RequestBody CarData carData) {
        User user = (User)session.getAttribute("user");
        if (carService.saveCar(user, carData)) {
            return true;
        } else {
            log.error("Add  car failed.");
            return false;
        }
    }

//    @PostMapping("/delete")
//    public String deleteUser() {
//        return "Save user failed.";
//    }
//
//    @PostMapping("/update")
//    public String updateUser() {
//        return "Save user failed.";
//    }
//
//    @GetMapping("/find/{id}")
//    public User findUserById(@PathVariable Long id) throws InterruptedException {
//
//        //Thread.sleep(6000);
//        User user = userService.findUserById(id);
//
//        return user;
//    }

    @GetMapping("/carlist")
    public List<Car> findCarList(HttpSession session) throws InterruptedException {

        //Thread.sleep(6000);
        User user = (User)session.getAttribute("user");
        if (user == null) {
            log.error("Please login first when you open the car.");
            return null;
        }
        List<Car> carList = carService.findCarListByUser(user);
        return carList;
    }

//    @GetMapping("/query")
//    public List<User> queryUses() {
//        return new ArrayList<>();
//    }
//
//    @GetMapping("/checkLogin")
//    public User checkLogin(HttpSession session, HttpServletRequest request) {
//        String sessionId = request.getSession().getId();
//        Object obj = session.getAttribute("user");
//        return (User) obj;
//    }
//
//    @PostMapping("/login")
//    public boolean login(HttpSession session, @RequestBody UserData userData) {
//        User user = userService.findByUserName(userData.getUserName());
//        session.setAttribute("user", user);
//        return user == null ? false : true;
//    }
//
//    @PostMapping("/logout")
//    public boolean logout(HttpSession session, HttpServletRequest request) {
//        String sessionId = request.getSession().getId();
//        session.setAttribute("user", null);
//        return true;
//    }
}
