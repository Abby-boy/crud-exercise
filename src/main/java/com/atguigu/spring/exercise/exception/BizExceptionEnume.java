package com.atguigu.spring.exercise.exception;

import lombok.Getter;

public enum BizExceptionEnume {

    ORDER_NOT_EXIST(100, "订单不存在"),
    ORDER_CLOSD(101, "订单已关闭"),
    ORDER_PAYED(102, "订单已支付"),
    ORDER_NOT_PAY(103, "订单未支付"),
    ORDER_NOT_DELIVER(104, "订单未发货"),
    ORDER_STOCK_NOT_ENOUGH(105, "库存不足"),
    ORDER_HSA_SOLD(106, "商品已经售完");

    @Getter
    private Integer code;
    @Getter
    private String msg;

    private BizExceptionEnume(Integer code, String message) {
        this.code = code;
        this.msg = message;
    }


}
