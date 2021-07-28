package com.project.common.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 供应商供货结算单Dto
 * @author wangsj
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class SupplyAccountOrderDto implements Serializable {

    /**
     * 结算单编号
     */
    private String accountNum;

    /**
     * 结算单总金额
     */
    private BigDecimal accountTotal;

    /**
     * 供货单编号
     */
    private String supplyNum;

    /**
     * 结算数量
     */
    private Integer accountQuantity;

    /**
     * 结算日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate accountDate;
}
