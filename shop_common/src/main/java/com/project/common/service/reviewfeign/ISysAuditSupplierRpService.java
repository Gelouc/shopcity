package com.project.common.service.reviewfeign;

import com.project.common.dto.OrderDto;
import com.project.common.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "shop-review")
public interface ISysAuditSupplierRpService {

    /**
     * 按照订单唯一标识修改供应商退货订单
     * @param pOnlyId  供应商退货订单唯一标识
     * @param state  状态
     * @return
     */

    @PostMapping("srpRG/update")
    public Object updateState(@RequestParam String pOnlyId,@RequestParam  String state);
}
