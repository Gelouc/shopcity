package com.project.common.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 前台系统顾客退货订单DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CustomerReturnGoodsDto implements Serializable {
    /**
     * 发起退货的订单详情id，不是订单id，是详情id，是单个商品发起的退货，有商品数量
     */
    private String crpOrderId;

    /**
     * 单个商品发起的退货金额
     */
    private Double crpMoney;

    /**
     * 发起退货的客户名字
     */
    private String crpUserName;
    /**
     * 发起退货的商品名字
     */
    private String crpProductName;

    /**
     * 发起退货的商品数量
     */
    private Integer crpProductNum;

    /**
     * 发起退货的商品类别
     */
    private String crpProductType;

    /**
     * 商品唯一标识
     */

    private String srpProductOnlyId;

    /**
     * 客户唯一标识
     */

    private String crpUserId;

    /**
     * 发起退货的客户联系电话
     */
    private String crpUserTel;

    /**
     * 发起退货的申请日期
     */
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate crpApplyDate;

    /**
     * 默认未审核，未审核是0，已审核是1，已通过是2
     */
    private String crpAuditState;

    /**
     * 客户退货订单唯一标识
     */
    private String crpOnlyId;

    /**
     * 审核原因
     */
    private String info;

    /**
     * 客户退货订单审核日志
     */
//    @TableField(exist = false)
//    private List<SysAuditCrpInfoBean> sysAuditCrpInfoBeans;
}
