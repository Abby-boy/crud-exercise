package com.atguigu.spring.exercise.mapper;

import com.atguigu.spring.exercise.bean.Order;
import com.atguigu.spring.exercise.vo.req.OrderVo;
import com.atguigu.spring.exercise.vo.resp.OrderRespVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

    /**
     * 根据 id 查询订单
     */
    OrderRespVo selectById(Long id);


    /**
     * 查询所有订单
     */
    List<OrderRespVo> selectAll();

    /**
     * 新增一个订单
     */
    void addOrder(OrderVo order);

    /**
     * 删除一个订单
     */
    Order deleteOrder(Long id);
}
