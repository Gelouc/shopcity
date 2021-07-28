package com.project.common.service.backfeign;

import com.project.common.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(value = "backstage-system")
public interface IProductUpService {

    /**
     * 查询所有前台系统，未添加且未上架的库存商品
     * @param pageNO 页码
     * @param pageSize 每页显示数
     * @return
     */
    @GetMapping("/back-product-bean/findAllWaitUpStock")
    Result findAllWaitUpStock(@RequestParam("pageNO") Integer pageNO, @RequestParam("pageSize") Integer pageSize);

    /**
     * 添加待上架商品(
     * @param proPrice 商品销售价格
     * @param productCode 商品唯一编号
     * @return
     */
    @PostMapping("/productStates/addWaitUpProduct")
    Result addWaitUpProduct(@RequestParam BigDecimal proPrice, @RequestParam String productCode);
}
