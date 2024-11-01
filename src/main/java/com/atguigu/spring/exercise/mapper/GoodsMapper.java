package com.atguigu.spring.exercise.mapper;


import com.atguigu.spring.exercise.bean.Goods;
import com.atguigu.spring.exercise.vo.req.GoodsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsMapper {


    /**
     * 查看所有商品
     */
    List<Goods> allGoods();

    /**
     *  根据id查询商品
     */
    GoodsVo selectById(Long id);


    /**
     *  新增一个商品商品
     */
    void insertGoods(GoodsVo goodsVo);

    /**
     * 删除一个商品
     */
    void deleteGoods(@Param("id") Long id);

    /**
     * 更新一个商品
     */
    void updateGoods(GoodsVo goodsVo);


}
