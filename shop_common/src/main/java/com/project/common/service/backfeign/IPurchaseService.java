package com.project.common.service.backfeign;

import com.project.common.result.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(value = "backstage-system")
public interface IPurchaseService {
    /**
     * 修改采购方案状态
     * @param purchaseOrderId 采购订单号
     * @param status 订单状态
     * @param remark 审核备注
     * @return
     */
    @PutMapping("/purchase-bean/updatePurchaseOrder")
    Result updatePurchaseOrder(@RequestParam String purchaseOrderId,
                               @RequestParam String status,@RequestParam String remark);

    /**
     * 根据采购方案编号修改采购订单编号
     * @param purchaseOrderId 采购方案编号
     * @param orderNumber 采购订单编号
     * @return
     */
    @PutMapping("/purchase-bean/updatePurchaseNumber")
    Result updatePurchaseNumber(@RequestParam String purchaseOrderId,@RequestParam String orderNumber);
}
