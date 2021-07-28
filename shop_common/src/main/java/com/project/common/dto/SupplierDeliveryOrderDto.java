package com.project.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 供应商和审核供货订单
 * @Author LZJ
 * @Date 2021/4/14 9:06
 **/
@Data
public class SupplierDeliveryOrderDto  implements Serializable {
    /**供货订单编号*/
    private String deliveryOrderNumber;
    /**订单编号*/
    private String orderNumber;
    /**发货数量*/
    private Long number;
    /**发货时间*/
    private LocalDate deliveryDate;
    /**供应商编号*/
    private String supplierNumber;
    /**供应商名称*/
    private String supplierName;
    /**商品单价*/
    private BigDecimal productPrice;

}
