package com.baie.other.cache;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Student implements Serializable {
    private String id;
    private String firstName;
    private String gender;
    private String lastName;

    public Student(String id, String firstName, String lastName, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }
}
