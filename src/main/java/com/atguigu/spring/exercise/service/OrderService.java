package com.atguigu.spring.exercise.service;


import com.atguigu.spring.exercise.bean.Order;
import com.atguigu.spring.exercise.common.R;
import com.atguigu.spring.exercise.mapper.OrderMapper;
import com.atguigu.spring.exercise.vo.req.OrderVo;
import com.atguigu.spring.exercise.vo.resp.OrderRespVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderMapper orderMapper;

    /**
     * 根据 id 查询订单信息
     */
    public R<OrderRespVo> findOrderById(Long id) {
        OrderRespVo order = orderMapper.selectById(id);
        if(order == null) {
            return R.error(400,"订单不存在",null);
        }
        if(order.getIsDelete() != 0L) {
            return R.error(403,"订单已被删除",null);
        }
        return R.ok(order);
    }

    /**
     *  查询所有订单
     */
    public List<OrderRespVo> allOrder() {
        // 查询了所有订单
        List<OrderRespVo> orders = orderMapper.selectAll();
        return orders;

    }

    /**
     * 新增一个订单
     */
    public void addOrder(OrderVo order) {
        orderMapper.addOrder(order);
        System.out.println("新增订单成功");
    }

    /**
     * 删除一个订单
     */
    public R<OrderRespVo> deleteOrder(Long id) {
        Order order = orderMapper.deleteOrder(id);
        OrderRespVo respVo = new OrderRespVo();
        BeanUtils.copyProperties(order,respVo);
        if(order.getIsDelete() != 0L) {
            return R.error(403,"订单已被删除",null);
        }
        return R.ok(respVo);
    }
}
