package com.project.common.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 采购方案DTO
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class SchemeDto implements Serializable {


    /**采购方案编号*/
    private String schemeCode;

    /**请购人*/
    private String schemeBuyer;

    /**联系电话*/
    private String schemeTel;

    /**请购数量*/
    private Long schemeAmount;

    /**采购方案创建日期*/
    private LocalDate schemeDate;

    /**商品类型*/
    private String commodityType;
    /**商品规格*/
    private String commoditySize;
    /**商品名称*/
    private String commodityName;
    /**商品照片路径*/
    private String commoPath;
    /**商品单价*/
    private BigDecimal commoPrice;
    /**商品生产日期*/
    private LocalDate commoDate;
    /**商品库存*/
    private Long commoTotal;
    /**商品编号*/
    private String commoNum;
}
