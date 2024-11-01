package com.atguigu.spring.exercise.vo.req;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderVo {

    @Schema(description = "订单id")
    private Long id;

    @Schema(description = "收货地址")
    @NotBlank(message = "收货地址不能为空")
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
    @Min(value = 1,message = "最小值为1")
    @Max(value = 99,message = "最大值为99")
    private Integer count;

    @Schema(description = "总价")
    @NotNull(message = "总价不能为空")
    private BigDecimal totalPrice;

    @Schema(description = "用于判断是否被删除")
    private Long isDelete;

    @Schema(description = "余额")
    @Min(value = 0,message = "账户最小余额必须大于0")
    private BigDecimal balance;


}
