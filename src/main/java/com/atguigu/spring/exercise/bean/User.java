package com.atguigu.spring.exercise.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;
    private String name;
    private Integer age;
    private String email;
    private String password;
    private String phone;
    private String sex;
    private Date brith;
    private BigDecimal balance;

    private List<Order> orders;

}
