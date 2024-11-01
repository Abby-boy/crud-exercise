package com.atguigu.spring.exercise.common;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class R<T> {

    @Schema(description = "状态码")
    private Integer code;
    @Schema(description = "状态信息")
    private String msg;
    @Schema(description = "数据")
    private T data;


    public static<T> R<T> ok(T data) {
        R<T> tr = new R<>();
        tr.setCode(200);
        tr.setMsg("success");
        tr.setData(data);
        return tr;
    }

    public static R ok() {
        R tr = new R<>();
        tr.setCode(200);
        tr.setMsg("success");
        return tr;
    }

    public static R error() {
        R tr = new R<>();
        tr.setCode(500);   //默认失败码
        tr.setMsg("fail");
        return tr;
    }

    public static R error(Integer code, String msg) {
        R tr = new R<>();
        tr.setCode(code);
        tr.setMsg(msg);
        return tr;
    }

    public static R error(Integer code, String msg , Object data) {
        R tr = new R<>();
        tr.setCode(code);
        tr.setMsg(msg);
        tr.setData(data);
        return tr;
    }


}
