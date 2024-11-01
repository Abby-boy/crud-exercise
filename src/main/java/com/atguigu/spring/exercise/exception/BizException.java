package com.atguigu.spring.exercise.exception;


import lombok.Data;

/**
 * 业务异常类
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

    public BizException(String msg) {
        super(msg);
    }
}
