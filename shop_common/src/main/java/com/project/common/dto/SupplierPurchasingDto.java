package com.project.common.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 审核中心和供应商的 采购（招标）信息dto
 */
@Data
public class SupplierPurchasingDto implements Serializable {
    /**
     * 招标编号（采购信息编号）
     */
    private String purchasingInfoNumber;
    /**招标公司名称*/
    private String companyName;
    /**招标商品*/
    private String commodity;
    /**招标商品类别*/
    private String commodityType;
    /**招标商品规格*/
    private String commoditySpecification;
    /**招标商品数量*/
    private Long commodityNumber;
    /**招标公司联系人*/
    private String contact;
    /**招标公司电话*/
    private String tel;
    /**招标审查意见*/
    private String purchasingInfo;
    /**供应商编号*/
    private String supplierNumber;
    /**招标状态*/

    private String supplierStatus;


}
