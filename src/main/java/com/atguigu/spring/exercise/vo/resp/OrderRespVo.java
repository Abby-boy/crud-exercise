package com.atguigu.spring.exercise.vo.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Schema(description = "订单响应对象")
public class OrderRespVo {

    @Schema(description = "订单id")
    @NotBlank(message = "订单id不能为空")
    private Long id;

    @Schema(description = "收货地址")
    @NotNull(message = "收货地址不能为空")
    private String address;

    @Schema(description = "商品id")
    @NotNull(message = "商品id不能为空")
    private Long goodsId;

    @Schema(description = "用户id")
    @NotNull(message = "用户id不能为空")
    private Long userId;

    @Schema(description = "创建时间")
    private Date createTime;

    @Schema(description = "数量")
    @NotNull(message = "数量不能为空")
    private Integer count;

    @Schema(description = "总价")
    @NotNull(message = "总价不能为空")
    private BigDecimal totalPrice;

    @Schema(description = "用于判断订单是否删除")
    private Long isDelete;


}
