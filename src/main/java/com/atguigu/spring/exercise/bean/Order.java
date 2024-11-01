package com.atguigu.spring.exercise.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Long id;
    private String address;
    private Long goodsId;
    private Long userId;
    private Date createTime;
    private Integer count;
    private BigDecimal totalPrice;
    private Long isDelete;

    private User user;
    private Goods goods;
}
