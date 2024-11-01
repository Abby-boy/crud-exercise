package com.atguigu.spring.exercise.controller;


import com.atguigu.spring.exercise.bean.Goods;
import com.atguigu.spring.exercise.common.R;
import com.atguigu.spring.exercise.service.GoodsService;
import com.atguigu.spring.exercise.vo.req.GoodsVo;
import com.atguigu.spring.exercise.vo.resp.GoodsRespVo;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Tag(name="商品管理",description = "商品的增删改查操作")
public class GoodsController {

    @Autowired
    GoodsService goodsService;


    /**
     * 新增商品
     */
    @PostMapping("/goods/add")
    @Schema(description = "商品信息")
    public R addGoods(@RequestBody @Valid GoodsVo goodsVo){
        GoodsVo vo = new GoodsVo();
        BeanUtils.copyProperties(goodsVo,vo);
        goodsService.addGoods(vo);
        return R.ok();
    }

    /**
     * 查看所有商品
     */
    @GetMapping("/goods")
    @Schema(description = "查看所有商品信息")
    public R<List<GoodsRespVo>> allGoods(){
        List<Goods> goods = goodsService.allGoods();
        List<GoodsRespVo> respVos = new ArrayList<>();
        for (Goods good : goods) {
            GoodsRespVo respVo = new GoodsRespVo();
            BeanUtils.copyProperties(good,respVo);
            respVos.add(respVo);
        }
        return R.ok(respVos);
    }

    /**
     * 根据id查询商品
     */
    @GetMapping("/goods/{id}")
    @Schema(description = "根据id查询商品信息")
    public R<GoodsVo> goodsById(@PathVariable("id") Long id){
        GoodsVo vo = goodsService.findGoodsById(id);
        if (vo == null){
            return R.error(404,"商品不存在");
        }
        return R.ok(vo);
    }


    /**
     * 根据id删除商品
     */
    @DeleteMapping("/goods/{id}")
    @Schema(description = "根据id删除商品信息")
    public R deleteGoods(@PathVariable("id") Long id){
        goodsService.deleteGoods(id);
        return R.ok();
    }

    /**
     * 更新商品
     */
    @PutMapping("/goods")
    @Schema(description = "更新商品信息")
    public R updateGoods(@RequestBody @Valid GoodsVo goodsVo){
        goodsService.updateGoods(goodsVo);
        return R.ok();
    }
}
