package com.atguigu.spring.exercise.controller;


import com.atguigu.spring.exercise.bean.User;
import com.atguigu.spring.exercise.common.R;
import com.atguigu.spring.exercise.service.UserService;
import com.atguigu.spring.exercise.vo.req.UserVo;
import com.atguigu.spring.exercise.vo.resp.UserRespVo;
import com.github.pagehelper.PageHelper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Tag(name="用户管理", description="用户相关操作")
@RestController
public class UserController {


    @Autowired
    UserService userService;


    /**
     *   按照 id 查询用户信息
     */
    @GetMapping("/user/{id}")
    @Operation(summary = "按照id查询用户信息")
    public R<User> getUserInfo(@PathVariable("id") Long id) {
        User user = userService.selectById(id);
        if (user == null) {
            return R.error(401,"没有该用户");
        }
        return R.ok(user);
    }

    // 添加用户
    @PostMapping("/user")
    @Operation(summary = "添加用户")
    public R addUser(@RequestBody @Valid UserVo vo) {
        User user = new User();
        BeanUtils.copyProperties(vo, user);
        userService.insert(user);
        return R.ok();
    }

    // 按照 id 查询用户信息，并查询用户订单信息
    @GetMapping("/user/orders/{id}")
    @Operation(summary = "按照id查询用户信息，并查询用户订单信息")
    public R<UserVo> getUserInfoWithOrder(@PathVariable("id") Long id) {
        UserVo vo = userService.selectByIdWithOrder(id);
        if (vo == null) {
            return R.error(401,"没有该用户");
        }
        return R.ok(vo);
    }


    /**
     * 查询所有用户信息
     */
    @GetMapping("/users")
    @Operation(summary = "查询所有用户信息")
    public R<List<UserRespVo>> getUsers(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(1, 10);
        List<User> users = userService.selectAll();
        List<UserRespVo> respVos = new ArrayList<>();
        for (User user : users) {
            UserRespVo respVo = new UserRespVo();
            BeanUtils.copyProperties(user, respVo);
            respVos.add(respVo);
        }
        return R.ok(respVos);
    }


    /**
     * 更新用户信息
     */
    @PutMapping("/user")
    @Operation(summary = "更新用户信息")
    public R updateUser(@RequestBody @Valid UserVo vo) {
        User user = new User();
        BeanUtils.copyProperties(vo, user);
        userService.update(user);
        return R.ok();
    }

}
