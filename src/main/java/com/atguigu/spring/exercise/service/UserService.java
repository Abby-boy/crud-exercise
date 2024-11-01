package com.atguigu.spring.exercise.service;


import com.atguigu.spring.exercise.bean.User;
import com.atguigu.spring.exercise.mapper.UserMapper;
import com.atguigu.spring.exercise.vo.req.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;


    /**
     * 按照用户 id 查询用户信息
     * @param id
     * @return
     */
    public User selectById(Long id) {
        User user = userMapper.selectById(id);
        return user;
    }

    /**
     * 新增用户信息
     * @param user
     */
    public void insert(User user){
        userMapper.insert(user);
    }

    /**
     * 按照用户 id 查询用户信息，并查询用户订单信息
     * @param id
     * @return
     */
    public UserVo selectByIdWithOrder(Long id) {
        UserVo userVo = userMapper.selectByIdWithOrder(id);
        return userVo;

    }

    /**
     * 查询所有用户信息
     */
    public List<User> selectAll(){
        List<User> users = userMapper.selectAll();
        return users;
    }


    /**
     * 更新用户信息
     */
    public void update(User user){
        userMapper.update(user);
    }
}
