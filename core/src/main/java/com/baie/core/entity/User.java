package com.baie.core.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "USER")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity implements Serializable {
    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long                    userId;

    @Column(name = "FIRST_NAME")
    private String                    firstName;

    @Column(name = "LAST_NAME")
    private String                    lastName;

    @Column(name = "ADDRESS")
    private String                    address;

    @Column(name = "PHONE_NUMBER")
    private String                    phoneNumber;

    @Column(name="GENDER")
    private String                    gender;

    @Column(name="USER_NAME")
    private String                    userName;

    @Column(name="PASSWORD")
    private String                    password;
}
