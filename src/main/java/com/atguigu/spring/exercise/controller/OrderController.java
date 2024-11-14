package com.atguigu.spring.exercise.controller;


import com.atguigu.spring.exercise.common.R;
import com.atguigu.spring.exercise.service.OrderService;
import com.atguigu.spring.exercise.vo.resp.OrderRespVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageInterceptor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name="订单控制器", description="订单控制器")
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;


    /**
     *  根据id查询订单
     */
    @Operation(summary = "根据id查询订单")
    @GetMapping("/order/{id}")
    public R<OrderRespVo> getOrderById(@PathVariable("id") Long id) {
        R<OrderRespVo> order = orderService.findOrderById(id);
        return order;
    }

    /**
     *  查询所有订单
     */
    @GetMapping("/orders")
    @Operation(summary = "查询所有订单")
    public List<OrderRespVo> getAllOrders() {
        List<OrderRespVo> vos = orderService.allOrder();
        int a = 10/ 0;
        return vos;
    }

    /**
     *  分页查询所有订单
     */
    @GetMapping("/ordersPage")
    @Operation(summary = "查询所有订单")
    public PageInfo getAllPage(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum, 5);
        List<OrderRespVo> vos = orderService.allOrder();
        return new PageInfo(vos);
    }


    @GetMapping("/order/delete/{id}")
    @Operation(summary = "删除订单")
    public R deleteOrder(@PathVariable("id") Long id) {
        orderService.deleteOrder(id);
        return R.ok();
    }


}
