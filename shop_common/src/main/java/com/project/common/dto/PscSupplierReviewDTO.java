package com.project.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 供应商公共类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PscSupplierReviewDTO  implements Serializable {
    /**供应商ID，数据库中的主键*/
    private Long supplierId;

    /**供应商编号*/
    private String supplierNumber;

    /**供应商联系人*/
    private String supplierContactname;

    /**联系人电话*/
    private String supplierTel;

    /**供应商执照--图片*/
    private String supplierLicense;

    /**供应商地址*/
    private String supplierAddress;

    /**供应商名称*/
    private String supplierName;

    /**供应商账号*/
    private String supplierCode;

    /**供应商密码*/
    private String supplierPass;

    /**供应商状态*/
    private String supplierStatus;

    /**供应商营业范围*/
    private String supplierRange;

    /**供应商等级*/
    private String supplierGrade;

    /**审核端对供应商的评价*/
    private String supplierComment;
}

