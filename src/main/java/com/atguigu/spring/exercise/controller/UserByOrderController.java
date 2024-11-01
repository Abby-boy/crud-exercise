package com.atguigu.spring.exercise.controller;


import com.atguigu.spring.exercise.common.R;
import com.atguigu.spring.exercise.service.SubmitOrderService;
import com.atguigu.spring.exercise.vo.req.OrderVo;
import com.atguigu.spring.exercise.vo.req.UserVo;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@Tag(name="用户相关接口", description="提供用户的增删改查功能")
public class UserByOrderController {

    @Autowired
    SubmitOrderService submitOrderService;
    /**
     * 用户新生成了一个订单
     */
    @Schema(description = "用户新生成一个订单")
    @PostMapping("/user/createOrder")
    public R createOrder(@RequestBody OrderVo orderVo){
        R r = submitOrderService.submitOrder(orderVo);
        return r;
    }


}
