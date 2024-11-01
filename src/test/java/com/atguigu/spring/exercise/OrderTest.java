package com.atguigu.spring.exercise;


import com.atguigu.spring.exercise.mapper.OrderMapper;
import com.atguigu.spring.exercise.service.OrderService;
import com.atguigu.spring.exercise.vo.req.OrderVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class OrderTest {

    @Autowired
    OrderService orderService;

    @Test
    void addOrder(){
        OrderVo orderVo = new OrderVo();

        /**
         * 取一个立即时间作为 createTime
         */
        orderVo.setCreateTime(new java.util.Date());
        orderVo.setAddress("河北石家庄");
        orderVo.setGoodsId(6L);
        orderVo.setUserId(210523L);
        orderVo.setCount(1);
        orderVo.setTotalPrice(BigDecimal.valueOf(2000));

        orderService.addOrder(orderVo);
    }
}
