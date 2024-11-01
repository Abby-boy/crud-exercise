package com.atguigu.spring.exercise.vo.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Schema(description = "商品响应对象")
public class GoodsRespVo {

    private Long id;

    private String type;
    // 商品信息
    private String message;
    private String creatTime;
    private BigDecimal price;
    // 商品数量
    private Long count;

    // 商品是否上架
    //private Long isDelete;
}
