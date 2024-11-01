package com.atguigu.spring.exercise.vo.req;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "商品信息")
public class GoodsVo {

    @Schema(description = "商品id")
    @NotNull(message = "商品id不能为空")
    private Long id;

    @Schema(description = "商品类型")
    private String type;

    @Schema(description = "商品名称")
    private String message;

    @Schema(description = "商品价格")
    @NotNull(message = "商品价格不能为空")
    private BigDecimal price;

    @Schema(description = "商品数量")
    @Min(value = 0, message = "商品数量不能小于0")
    private Long count;

    @Schema(description = "上架时间")
    private String creatTime;

    @Schema(description = "商品是否上架")
    @NotNull(message = "0-上架，其他-下架")
    private Long isDelete;



}
