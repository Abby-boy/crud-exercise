package com.atguigu.spring.exercise.advice;


/**
 *  配置全局异常处理类
 */
import com.atguigu.spring.exercise.common.R;
import com.atguigu.spring.exercise.exception.BizException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;


@ControllerAdvice     // 告诉 spring 这是一个全局异常处理类
@ResponseBody

/**
 * 如果出现了异常：本类和全局都不能处理：
 *        springboot底层对springMVC有兜底处理机制，自适应处理（浏览器响应页面，移动端会响应json）
 *   在异常处理中：前端关心异常状态，后端关心正确的业务流程
 *
 */
public class GlobaExceptionHandler {


    // 最大的异常处理方法
   /* @ExceptionHandler(Throwable.class)
    public R handleThrowableException(Throwable e) {
        System.out.println("全局异常处理器：运行时异常"+e.getClass());
        return R.error(300,e.getMessage());
    }*/

    // 处理参数异常
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        // 获取到绑定结果对象
        BindingResult result = e.getBindingResult();
        HashMap<String, String> errorMap = new HashMap<>();
        for( FieldError fieldError: result.getFieldErrors() ){
            //1.获取到属性名
            String name = fieldError.getField();
            //2.获取到错误提示
            String message = fieldError.getDefaultMessage();
            errorMap.put(name,message);
            //System.out.println("属性:"+name + " 错误提示:"+message );
        }
        //System.out.println("全局异常处理器：参数校验异常"+e.getClass());
        return R.error(500,"参数校验异常",errorMap);
    }


    // ArithmeticException.class 表示只处理算术异常
    @ExceptionHandler(ArithmeticException.class)
    public R handleArithmeticException(ArithmeticException e) {
        System.out.println("全局异常处理器：算术异常");
        return R.error(401,e.getMessage());
    }

    // spring 对异常兜底处理
    @ExceptionHandler(Throwable.class)
    public R error(Throwable e){
        System.out.println("全局异常处理器：运行时异常"+e.getClass());
        return R.error(555,e.getMessage());
    }


    // 自定义业务异常处理
    @ExceptionHandler(BizException.class)
    public R handleBizException(BizException e){

        Integer code = e.getCode();
        String msg = e.getMsg();
        return R.error(code,msg);
    }

}
