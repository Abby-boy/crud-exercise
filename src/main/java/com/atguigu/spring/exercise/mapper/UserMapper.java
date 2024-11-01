package com.atguigu.spring.exercise.mapper;
import com.atguigu.spring.exercise.bean.User;
import com.atguigu.spring.exercise.vo.req.UserVo;
import com.atguigu.spring.exercise.vo.resp.UserRespVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {


    /**
     * 新增用户信息
     * @param user
     */
    void insert(User user);

    /**
     * 根据 id 查询用户信息
     * @param id
     * @return
     */
    User selectById(Long id);

    /**
     * 根据用户 id 查询用户订单信息
      * @param id
     * @return
     */
    UserVo selectByIdWithOrder(Long id);

    /**
     * 查询所有用户信息
     * @return
     */
    List<User> selectAll();

    /**
     * 更新用户信息
     */
    void update(User user);
}
