package com.atguigu.spring.exercise.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {

    private Long id;
    // 商品类型
    private String type;
    // 商品信息
    private String message;
    private String creatTime;
    private BigDecimal price;
    // 商品数量
    private Long count;
    // 商品是否上架
    private Long isDelete;

    private Goods goods;

    private List<Order> orders;

}
