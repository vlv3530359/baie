package com.baie.core.module;

import com.baie.core.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarData implements Serializable {

    private Long productId;

    private Integer count;

    private User user;

//    public Car buildCar() {
//
//        return Car.builder().user(user).count(count).product(product).price(product.getProductPrice()).build();
//    }
}
