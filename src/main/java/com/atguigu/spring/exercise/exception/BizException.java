package com.atguigu.spring.exercise.exception;


import lombok.Data;

/**
 * 业务异常类
 *    异常处理的最终方式：
 *      1.必须有业务异常类： BizException
 *      2.必须有业务异常枚举类： BizExceptionEnume    列举项目中每个模块将会出现的所有异常情况
 *      3.编写业务代码的时候，只需要编写正确的逻辑，如果出现预期的问题，需要以抛异常的方式中断逻辑并通知上层
 *      4.全局异常处理类 GlobalExceptionHandler：处理所有异常，返回给前端
 */

@Data
public class BizException extends RuntimeException {

    // 异常业务状态码
    private Integer code;
    // 异常业务信息
    private String msg;

    public BizException(Integer code, String msg) {
        super("错误码：" + code + "，错误信息：" + msg);
        this.code = code;
        this.msg = msg;
    }

    public BizException(BizExceptionEnume  exceptionEnume) {
        super(exceptionEnume.getMsg());
        this.code = exceptionEnume.getCode();
        this.msg = exceptionEnume.getMsg();
    }
}
