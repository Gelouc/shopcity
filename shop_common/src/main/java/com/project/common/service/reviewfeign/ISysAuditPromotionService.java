package com.project.common.service.reviewfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "shop-review")
public interface ISysAuditPromotionService {

    /**
     * 按照订单唯一标识修改促销审核订单
     * @param srpOnlyId  供应商退货订单唯一标识
     * @param state  状态
     * @return
     */
    @PostMapping("/promotion/updateCommon")
    public Object updateState(@RequestParam String srpOnlyId,@RequestParam  String state);
}
