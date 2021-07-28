package com.project.common.service.frontfeign;

import com.project.common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(value="shop-front-desk")
@Api("商品调用接口")
public interface IGoodsService {

    @ApiOperation("通过商品编号修改商品状态：上架，下架")
    @PutMapping("/goods/updateStateByGoodsCode")
    Result updateStateByGoodsCode(@RequestParam String goodsCode, @RequestParam String goodsState);

    @ApiOperation("通过商品编号删除")
    @DeleteMapping("/goods/delByGoodsCode/{goodsCode}")
    Result delByGoodsCode(@PathVariable("goodsCode") String goodsCode);

    @ApiOperation("通过商品编号修改商品促销情况以及修改对应折扣：促销，未促销")
    @PutMapping("/goods/updateStatusDis")
    Result updateStatusDis(@RequestParam String goodsCode,@RequestParam String status,@RequestParam BigDecimal discount);
}
