package com.atguigu.spring.exercise.service;


import com.atguigu.spring.exercise.bean.Goods;
import com.atguigu.spring.exercise.mapper.GoodsMapper;
import com.atguigu.spring.exercise.vo.req.GoodsVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    /**
     * 新增一个商品
     */
    public void addGoods(GoodsVo goodsVo) {
        goodsMapper.insertGoods(goodsVo);
    }


    /**
     * 查看所有商品
     */
    public List<Goods> allGoods() {
        List<Goods> goods = goodsMapper.allGoods();
        return goods;
    }

    /**
     * 根据  id 查询商品
     */
    public GoodsVo findGoodsById(Long id) {
        GoodsVo goodsVo = goodsMapper.selectById(id);
        return goodsVo;
    }

    /**
     * 删除一个商品
     */
    public void deleteGoods(Long id) {
        goodsMapper.deleteGoods(id);
    }

    /**
     * 更新商品信息
     */
    public void updateGoods(GoodsVo goodsVo) {
        goodsMapper.updateGoods(goodsVo);
    }
}
