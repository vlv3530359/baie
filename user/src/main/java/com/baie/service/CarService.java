package com.baie.service;

import com.baie.core.entity.Car;
import com.baie.core.entity.Product;
import com.baie.core.entity.User;
import com.baie.core.integration.IntegrationAPIService;
import com.baie.core.module.CarData;
import com.baie.repository.CarRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    @Autowired
    IntegrationAPIService integrationAPIService;

    public boolean saveCar(User user, CarData carData) {
        try {
            Car car = buildCar(user, carData);
            carRepository.save(car);
            return true;
        } catch (Exception e) {
            log.error("CarService.saveCar error: ", e);
            return false;
        }
    }


    public List<Car> findCarListByUser(User user) {
        List<Car> carList = carRepository.findByUser(user);
        return carList;
    }

    private Car buildCar(User user, CarData carData) {
        Product product = integrationAPIService.findProductById(carData.getProductId());
        return Car.builder().user(user).price(product.getProductPrice()).product(product).count(carData.getCount()).build();
    }
}
