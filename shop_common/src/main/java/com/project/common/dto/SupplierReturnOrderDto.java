package com.project.common.dto;


import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 审核中心给供应商退货订单 dto
 */
@Data
public class SupplierReturnOrderDto implements Serializable {

    /**退货订单的商品名*/
    private String productName;
    /**退货订单的商品数量*/
    private Long number;
    /**退货订单的商品总价*/
    private BigDecimal totalPrice;
    /**退货订单的时间*/
    private LocalDate returnOrderDate = LocalDate.now();
    /**采购信息编号*/
    private String purchasingInfoNumber;
    /**
     * 退货订单唯一标识
     */
    private String srpOnlyId;
}
