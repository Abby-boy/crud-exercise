package com.atguigu.spring.exercise.vo.resp;


import com.atguigu.spring.exercise.bean.Order;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class UserRespVo {

    private Long id;
    private String name;
    private Integer age;
    private String email;
    // 前端不需要展示密码
    //private String password;
    private String phone;
    private String sex;
    private Date brith;
    private BigDecimal balance;

}
