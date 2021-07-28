package com.project.common.service.backfeign;


import com.project.common.dto.OrderDto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;

@FeignClient(value = "backstage-system")
public interface IProductOrderService {

    /**
     * 添加订单
     * @param orderDto  订单dto
     * @return
     */
    @PostMapping("/orders/add")
    Result saveProductOrder(@RequestBody OrderDto orderDto);


    /**
     * 修改订单状态
     * @param uk 订单唯一编号
     * @param status 订单状态
     * @return
     */
    @PutMapping("/orders/accpet/{uk}/{status}")
    Result updateProductOrderStatus(@PathVariable("uk") String uk,
                                    @PathVariable("status") String status);

}
