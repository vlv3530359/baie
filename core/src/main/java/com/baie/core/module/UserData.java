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
public class UserData implements Serializable {

    private String firstName;

    private String lastName;

    private String gender;

    private String phoneNumber;

    private String address;

    private String userName;

    private String password;

    public User buildUser() {
        return User.builder().userName(userName).password(password).address(this.address).firstName(firstName).lastName(lastName).gender(gender).phoneNumber(phoneNumber).build();
    }
}
