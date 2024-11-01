package com.atguigu.spring.exercise.service;


import com.atguigu.spring.exercise.bean.User;
import com.atguigu.spring.exercise.common.R;
import com.atguigu.spring.exercise.vo.req.GoodsVo;
import com.atguigu.spring.exercise.vo.req.OrderVo;

import com.atguigu.spring.exercise.vo.req.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
// 标识事务
@Transactional
public class SubmitOrderService {


    @Autowired
    GoodsService goodsService;

    @Autowired
    UserService userService;

    @Autowired
    OrderService orderService;

    public R submitOrder(OrderVo orderVo){

        try {
            // 1. 查看用户
            User user = userService.selectById(orderVo.getUserId());
            if (user == null) {
                return R.error(404, "用户不存在");
            } else if (user.getBalance().compareTo(orderVo.getTotalPrice()) < 0) {
                return R.error(400, "余额不足");
            } else {
                user.setBalance(user.getBalance().subtract(orderVo.getTotalPrice()));
                userService.update(user);
            }

            // 2. 查看商品
            GoodsVo goods = goodsService.findGoodsById(orderVo.getGoodsId());
            if (goods == null) {
                return R.error(404, "商品不存在");
            } else if (goods.getCount() < orderVo.getCount()) {
                return R.error(400, "库存不足");
            } else {
                goods.setCount(goods.getCount() - orderVo.getCount());
                goodsService.updateGoods(goods);
            }

            // 3. 生成订单
            orderService.addOrder(orderVo);

            // 如果所有操作都成功，返回成功的响应
            return R.ok();

        } catch (Exception e) {
            // 捕获其他未处理的异常，并返回通用的错误响应
            return R.error(500, "系统异常");
        }
    }

}
