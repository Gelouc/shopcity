package com.project.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 审核中心和供应商的 投标信息dto
 */
@Data
public class SupplierTenderDto implements Serializable {
    /**能提供的数量*/
    private Long tenderNum;
    /**商品单价*/
    private BigDecimal tenderPrice;
    /**投标时间*/
    private LocalDate tenderDate = LocalDate.now();
    /**商品编号*/
    private String productNumber;
    /**采购信息编号*/
    private String purchasingInfoNumber;
    /**投标编号*/
    private String quotationCode;
    /**供应商编号*/
    private String supplierCode;


}
