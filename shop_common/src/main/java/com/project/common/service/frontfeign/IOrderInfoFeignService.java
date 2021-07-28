package com.project.common.service.frontfeign;

import com.project.common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="shop-front-desk")
@Api("订单详情远程调用接口")
public interface IOrderInfoFeignService {

    @ApiOperation("通过订单详情编号修改订单详情状态,状态为：发货中，已退货")
    @PutMapping("/sc-orderinfo-bean/updateOrderInfoByOrderInfoCode")
    Result updateOrderInfoByOrderInfoCode(@RequestParam String orderInfoCode,@RequestParam String state);
}
