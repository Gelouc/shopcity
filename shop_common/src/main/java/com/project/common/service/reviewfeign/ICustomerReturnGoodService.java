package com.project.common.service.reviewfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "shop-review")
public interface ICustomerReturnGoodService {

    /**
     * 按照订单唯一标识修改顾客退货订单状态
     * @param srpOnlyId  供应商退货订单唯一标识
     * @param state  状态
     * @return
     */
    @PostMapping("customerRP/updateCommon")
    public Object updateStateCommon(@RequestParam String srpOnlyId,@RequestParam  String state);
}
