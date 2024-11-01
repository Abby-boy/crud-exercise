package com.atguigu.spring.exercise.vo.req;

import com.atguigu.spring.exercise.bean.Order;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "用户信息")
public class UserVo {

    @Schema(description = "用户id")
    @NotNull(message = "用户id不能为空")
    private Long id;

    @Schema(description = "用户名")
    @NotBlank(message = "用户名不能为空")
    private String name;

    @Schema(description = "年龄")
    @Max(value = 100, message = "年龄最大值不能超过100")
    @Min(value = 0, message = "年龄最小值不能低于0")
    private Integer age;

    @Schema(description = "邮箱")
    @Email(message = "邮箱格式不正确")
    private String email;

    @Schema(description = "密码")
    @NotBlank(message = "密码不能为空")
    private String password;

    @Schema(description = "手机号")
    private String phone;

    @Schema(description = "性别")
    @NotBlank(message = "性别不能为空")
    @Pattern(regexp = "^[男|女]$", message = "性别只能是男或女")
    private String sex;

    @Schema(description = "出生日期")
    private Date brith;

    @Schema(description = "余额")
    @Min(value = 0,message = "余额最小值不能低于0")
    private BigDecimal balance;



    @Schema(description = "订单列表")
    private List<Order> orders;
}
