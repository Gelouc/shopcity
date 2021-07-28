package com.project.common.service.reviewfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("shop-review")
public interface ISysAuditSoFeignService {
    /**
     * 修改审核系统销售订单状态
     * @param orderCode 订单编号
     * @param status    订单状态
     * @return
     */
    @PostMapping("update")
    Object updateSoStatus(@RequestParam String orderCode,@RequestParam String status);
}
